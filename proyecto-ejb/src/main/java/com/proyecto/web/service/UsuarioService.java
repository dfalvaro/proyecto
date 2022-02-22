package com.proyecto.web.service;

import com.proyecto.web.exceptions.EntidadNoBorradaException;
import com.proyecto.web.exceptions.EntidadNoEncontradaException;
import com.proyecto.web.exceptions.EntidadNoGrabadaException;
import com.proyecto.web.model.TabPersona;
import com.proyecto.web.model.TabUsuario;
import java.util.List;
import javax.ejb.Local;

@Local
public interface UsuarioService {

    /**
     * *
     *
     * @param paramLong
     * @return
     * @throws EntidadNoEncontradaException
     */
    public TabUsuario obtenerPorId(Long paramLong)
            throws EntidadNoEncontradaException;

    /**
     *
     * @param paramTabUsuario
     * @return
     */
    public List<TabUsuario> buscar(TabUsuario paramTabUsuario);

    /**
     *
     * @return
     */
    public List<TabUsuario> obtenerTodos();

    /**
     *
     * @param paramTabUsuario
     * @throws EntidadNoGrabadaException
     */
    public void guardar(TabUsuario paramTabUsuario)
            throws EntidadNoGrabadaException;

    /**
     *
     * @param paramTabUsuario
     * @throws EntidadNoGrabadaException
     */
    public void actualizar(TabUsuario paramTabUsuario)
            throws EntidadNoGrabadaException;

    /**
     *
     * @param paramTabUsuario
     * @throws EntidadNoBorradaException
     * @throws EntidadNoEncontradaException
     */
    public void eliminar(TabUsuario paramTabUsuario)
            throws EntidadNoBorradaException, EntidadNoEncontradaException;

    /**
     *
     * @param usuario
     * @param entidad
     * @throws EntidadNoGrabadaException
     */
    public void guardarUsuario(TabUsuario usuario, TabPersona entidad,String enlace) throws EntidadNoGrabadaException,Exception;

}
