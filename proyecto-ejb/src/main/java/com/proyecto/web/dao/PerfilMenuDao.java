package com.proyecto.web.dao;

import java.util.List;

import javax.ejb.Local;
import com.proyecto.web.model.TabPerfilMenu;

/**
 * Clase ...
 *
 * @author 
 * @revision $Revision: 1.1 $
 */
@Local
public interface PerfilMenuDao extends IGenericDao<TabPerfilMenu, Long> {

    /**
     *
     * @param rolFuncionalidad
     * @return
     */
    List<TabPerfilMenu> buscar(TabPerfilMenu rolFuncionalidad);


}
