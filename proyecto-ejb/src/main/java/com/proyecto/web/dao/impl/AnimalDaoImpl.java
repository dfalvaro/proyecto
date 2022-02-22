package com.proyecto.web.dao.impl;


import com.proyecto.web.dao.IAnimalDao;
import com.proyecto.web.model.TabAnimal;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class AnimalDaoImpl
        extends GenericDao<TabAnimal, Long>
        implements IAnimalDao {

    public AnimalDaoImpl() {
        super(TabAnimal.class);
    }

    @Override
    public List<TabAnimal> buscar(TabAnimal animal) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from TabAnimal t where 1=1");
        if (animal.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", animal.getId());
        }

        if (animal.getEstado() != null) {
            sql.append(" and t.estado=:estado");
            parametros.put("estado", animal.getEstado());
        }

        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }
     @Override
    public List<TabAnimal> redimencionarImagen() {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from TabAnimal t where t.imagen  is not null   and trim(t.imagen) !=''and length(t.imagen) >:cien");
         parametros.put("cien", 100);
       
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }
}
