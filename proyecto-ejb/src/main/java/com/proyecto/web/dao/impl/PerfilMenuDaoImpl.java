package com.proyecto.web.dao.impl;

import com.proyecto.web.dao.PerfilMenuDao;
import java.util.HashMap;
import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.Query;

import com.proyecto.web.model.TabPerfilMenu;

/**
 *
 * @author 
 */
@Singleton
public class PerfilMenuDaoImpl extends GenericDao<TabPerfilMenu, Long> implements
        PerfilMenuDao {

    /**
     *
     */
    public PerfilMenuDaoImpl() {
        super(TabPerfilMenu.class);
    }

    /**
     *
     * @param rolFun
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<TabPerfilMenu> buscar(final TabPerfilMenu rolFun) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from TabPerfilMenu t where 1=1 ");
        if (rolFun.getPerfil() != null) {
            sql.append(" and t.perfil=:perfil");
            parametros.put("perfil", rolFun.getPerfil());
        }

        if (rolFun.getMenuPadre() != null) {
            sql.append(" and t.menu.padre=:padre");
            parametros.put("padre", rolFun.getMenuPadre());
        }

        if (rolFun.getMenu() != null) {
            sql.append(" and rf.menu =:menu");
            parametros.put("menu", rolFun.getMenu());
        }
        if (rolFun.getUrl() != null) {
            sql.append(" and t.menu.url=:url");
            parametros.put("url", rolFun.getUrl());
        }
        sql.append(" order by t.menu.orden  asc ");      

        final Query q = em.createQuery(sql.toString());
        for (Object key : parametros.keySet()) {
            q.setParameter((String) key, parametros.get(key));
        }
        return q.getResultList();

    }

}
