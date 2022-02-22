package com.proyecto.web.dao.impl;

import com.proyecto.web.model.TabPersona;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Singleton;
import javax.persistence.Query;
import com.proyecto.web.dao.PersonaDao;

@Singleton
public class PersonaDaoImpl
        extends GenericDao<TabPersona, Long>
        implements PersonaDao {

    public PersonaDaoImpl() {
        super(TabPersona.class);
    }

    @Override
    public List<TabPersona> buscar(TabPersona entidad) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from TabPersona t where 1=1 ");
        if (entidad.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", entidad.getId());
        }
        if (entidad.getCorreo() != null) {
            sql.append(" and t.correo=:correo");
            parametros.put("correo", entidad.getCorreo());
        }

        if (entidad.getIdentificacion() != null) {
            sql.append(" and t.identificacion=:identificacion");
            parametros.put("identificacion", entidad.getIdentificacion());
        }

        sql.append(" order by t.id  desc ");

        Query q = this.em.createQuery(sql.toString());
        for (Object key : parametros.keySet()) {
            q.setParameter((String) key, parametros.get(key));
        }
        return q.getResultList();
    }
}
