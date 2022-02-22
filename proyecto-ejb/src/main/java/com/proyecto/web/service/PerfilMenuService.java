
package com.proyecto.web.service;

import com.proyecto.web.exceptions.EntidadNoBorradaException;
import com.proyecto.web.exceptions.EntidadNoEncontradaException;
import com.proyecto.web.exceptions.EntidadNoGrabadaException;
import com.proyecto.web.model.TabPerfilMenu;
import java.util.List;
import javax.ejb.Local;

/**
 clienteProveedor
 *
 * @author 
 * @revision $Revision: $
 */
@Local
public interface PerfilMenuService {

    /**
     *
     * @param id
     * @return
     * @throws EntidadNoEncontradaException
     */
    public TabPerfilMenu obtenerPorId(final Integer id)
            throws EntidadNoEncontradaException;

    /**
     *
     * @param perfilMenu
     * @return
     */
    public List<TabPerfilMenu> buscar(TabPerfilMenu perfilMenu);

    /**
     *
     * @return
     */
    public List<TabPerfilMenu> obtenerTodos();

    /**
     *
     * @param perfilMenu
     * @throws EntidadNoGrabadaException
     */
    public void guardar(TabPerfilMenu perfilMenu) throws EntidadNoGrabadaException;

    /**
     *
     * @param perfilMenu
     * @throws EntidadNoGrabadaException
     */
    public void actualizar(TabPerfilMenu perfilMenu) throws EntidadNoGrabadaException;
/**
 * 
 * @param perfilMenu
 * @throws EntidadNoBorradaException 
 */
    public void eliminar(TabPerfilMenu perfilMenu) throws EntidadNoBorradaException;

}
