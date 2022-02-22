package com.proyecto.web.dao.impl;

import com.proyecto.web.dao.MenuDao;
import com.proyecto.web.model.TabMenu;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Singleton;
import javax.persistence.Query;

@Singleton
public class MenuDaoImpl
        extends GenericDao<TabMenu, Long>
        implements MenuDao {

    public MenuDaoImpl() {
        super(TabMenu.class);
    }

    @Override
    public List<TabMenu> buscarMenuPadre() {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from TabMenu t where t.padre is null order by t.orden asc");

        Query q = this.em.createQuery(sql.toString());
       for (Object key : parametros.keySet()) {
            q.setParameter((String) key, parametros.get(key));
        }
        return q.getResultList();
    }
    
        @Override
    public List<TabMenu> buscarMenuHijos() {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from TabMenu t where t.padre is not null order by t.orden asc");

        Query q = this.em.createQuery(sql.toString());
       for (Object key : parametros.keySet()) {
            q.setParameter((String) key, parametros.get(key));
        }
        return q.getResultList();
    }

    @Override
    public List<TabMenu> buscar(TabMenu funcionalidad) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from TabMenu t where 1=1 ");

        if (funcionalidad.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", funcionalidad.getId());
        }

        if (funcionalidad.getNombre() != null) {
            sql.append(" and t.nombre =:nombre");
            parametros.put("nombre", funcionalidad.getNombre());
        }

        if (funcionalidad.getUrl() != null) {
            sql.append(" and t.url=:url");
            parametros.put("url", funcionalidad.getUrl());
        }

        if (funcionalidad.getOrden() != null) {
            sql.append(" and t.orden =:orden");
            parametros.put("orden", funcionalidad.getOrden());
        }
        
      sql.append(" order by t.orden asc");
                
                 

        Query q = this.em.createQuery(sql.toString());
       for (Object key : parametros.keySet()) {
            q.setParameter((String) key, parametros.get(key));
        }
        return q.getResultList();
    }
}
