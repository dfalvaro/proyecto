package com.proyecto.web.dao;

import com.proyecto.web.model.TabMenu;
import java.util.List;
import javax.ejb.Local;

@Local
public interface MenuDao
        extends IGenericDao<TabMenu, Long> {

    /**
     *
     * @param paramTabMenu
     * @return
     */
    public List<TabMenu> buscar(TabMenu paramTabMenu);

    /**
     *
     * @return
     */
    public List<TabMenu> buscarMenuPadre();

    /**
     *
     * @return
     */
    public List<TabMenu> buscarMenuHijos();
}
