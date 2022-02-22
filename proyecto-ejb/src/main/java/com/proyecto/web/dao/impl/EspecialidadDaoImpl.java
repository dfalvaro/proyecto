package com.proyecto.web.dao.impl;

import com.proyecto.web.dao.ICanDao;
import com.proyecto.web.dao.IEspecialidadDao;
import com.proyecto.web.model.TabEspecialidad;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class EspecialidadDaoImpl
        extends GenericDao<TabEspecialidad, Long>
        implements IEspecialidadDao {

    public EspecialidadDaoImpl() {
        super(TabEspecialidad.class);
    }

    @Override
    public List<TabEspecialidad> buscar(TabEspecialidad especialidad) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from TabEspecialidad t where 1=1");
        if (especialidad.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", especialidad.getId());
        }

        if (especialidad.getNombre() != null) {
            sql.append(" and t.nombre=:nombre");
            parametros.put("nombre", especialidad.getNombre());
        }

        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }

}
