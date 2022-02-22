package com.proyecto.web.dao.impl;

import com.proyecto.web.dao.IGuiaDao;
import com.proyecto.web.model.TabGuia;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class GuiaDaoImpl
        extends GenericDao<TabGuia, Long>
        implements IGuiaDao {

    public GuiaDaoImpl() {
        super(TabGuia.class);
    }

    @Override
    public List<TabGuia> buscar(TabGuia persona) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from TabGuia t where 1=1");
        if (persona.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", persona.getId());
        }

        if (persona.getEstado() != null) {
            sql.append(" and t.estado=:estado");
            parametros.put("estado", persona.getEstado());
        }

        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }

    @Override
    public List<TabGuia> redimencionarImagen() {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from TabGuia t where t.imagen  is not null   and trim(t.imagen) !=''and length(t.imagen) >:cien");
        parametros.put("cien", 100);

        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }
}
