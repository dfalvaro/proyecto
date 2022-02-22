package com.proyecto.web.dao.impl;

import com.proyecto.web.dao.PerfilDao;
import com.proyecto.web.model.TabPerfil;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Singleton;
import javax.persistence.Query;

@Singleton
public class PerfilDaoImpl
        extends GenericDao<TabPerfil, Long>
        implements PerfilDao {

    public PerfilDaoImpl() {
        super(TabPerfil.class);
    }

    @Override
    public List<TabPerfil> buscar(TabPerfil rol) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from TabPerfil t where 1=1 ");
        if (rol.getId() != null) {
            sql.append(" and t.perId =:id");
            parametros.put("id", rol.getId());
        }

        if (rol.getNombre() != null) {
            sql.append(" and t.nombre =:nombre");
            parametros.put("nombre", rol.getNombre());
        }

        if (rol.getEstado() != null) {
            sql.append(" and t.estado=:estado");
            parametros.put("estado", rol.getEstado());
        }
        
       
        sql.append(" order by t.id  desc ");

        Query q = this.em.createQuery(sql.toString());
       for (Object key : parametros.keySet()) {
            q.setParameter((String) key, parametros.get(key));
        }
        return q.getResultList();
    }
}
