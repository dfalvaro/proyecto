package com.proyecto.web.service;

import com.proyecto.web.exceptions.EntidadNoBorradaException;
import com.proyecto.web.exceptions.EntidadNoEncontradaException;
import com.proyecto.web.exceptions.EntidadNoGrabadaException;
import com.proyecto.web.model.TabMenu;
import com.proyecto.web.model.TabPerfil;
import com.proyecto.web.model.TabPerfilMenu;
import java.util.List;
import javax.ejb.Local;

@Local
public interface PerfilService {
/**
 * 
 * @param paramLong
 * @return
 * @throws EntidadNoEncontradaException 
 */
    public TabPerfil obtenerPorId(Long paramLong)
            throws EntidadNoEncontradaException;
/**
 * 
 * @param paramTabPerfil
 * @return 
 */
    public List<TabPerfil> buscar(TabPerfil paramTabPerfil);
/**
 * 
 * @return 
 */
    public List<TabPerfil> obtenerTodos();
/**
 * 
 * @param paramTabPerfil
 * @param paramList1
 * @param paramList2
 * @throws EntidadNoBorradaException
 * @throws EntidadNoGrabadaException
 * @throws EntidadNoEncontradaException 
 */
    public void creacionPerfil(TabPerfil paramTabPerfil, List<TabPerfilMenu> paramList1, List<TabPerfilMenu> paramList2)
            throws EntidadNoBorradaException, EntidadNoGrabadaException,EntidadNoEncontradaException;
/**
 * 
 * @param paramTabPerfil
 * @throws EntidadNoGrabadaException 
 */
    public void actualizar(TabPerfil paramTabPerfil)
            throws EntidadNoGrabadaException;
/**
 * 
 * @param paramTabPerfil
 * @throws EntidadNoBorradaException 
 */
    public void eliminar(TabPerfil paramTabPerfil)
            throws EntidadNoBorradaException;
/**
 * 
 * @param paramTabPerfil
 * @throws EntidadNoBorradaException
 * @throws EntidadNoEncontradaException 
 */
    public void eliminarPerfilFuncionalidad(TabPerfil paramTabPerfil)
            throws EntidadNoBorradaException,EntidadNoEncontradaException;
}
