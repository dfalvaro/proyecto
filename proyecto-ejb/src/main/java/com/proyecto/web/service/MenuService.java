package com.proyecto.web.service;

import com.proyecto.web.exceptions.EntidadNoEncontradaException;
import com.proyecto.web.model.TabMenu;
import java.util.List;
import javax.ejb.Local;

@Local
public interface MenuService {

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
    public List<TabMenu> obtenerTodos();

    /**
     *
     * @param paramLong
     * @return
     * @throws EntidadNoEncontradaException
     */
    public TabMenu obtenerPorId(Long paramLong)
            throws EntidadNoEncontradaException;

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
