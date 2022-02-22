package com.proyecto.web.service;

import com.proyecto.web.exceptions.EntidadNoBorradaException;
import com.proyecto.web.exceptions.EntidadNoEncontradaException;
import com.proyecto.web.exceptions.EntidadNoGrabadaException;
import com.proyecto.web.model.TabPersona;
import java.util.List;
import javax.ejb.Local;

@Local
public interface PersonaService {
/**
 * 
 * @param paramLong
 * @return
 * @throws EntidadNoEncontradaException 
 */
    public TabPersona obtenerPorId(Long paramLong)
            throws EntidadNoEncontradaException;
/**
 * 
 * @param paramTabEntidad
 * @return 
 */
    public List<TabPersona> buscar(TabPersona paramTabEntidad);
/**
 * 
 * @return 
 */
    public List<TabPersona> obtenerTodos();
/**
 * 
 * @param paramTabEntidad
 * @throws EntidadNoGrabadaException 
 */
    public void guardar(TabPersona paramTabEntidad)
            throws EntidadNoGrabadaException;
/**
 * 
 * @param paramTabEntidad
 * @throws EntidadNoGrabadaException 
 */
    public void actualizar(TabPersona paramTabEntidad)
            throws EntidadNoGrabadaException;
/**
 * 
 * @param paramTabEntidad
 * @throws EntidadNoBorradaException
 * @throws EntidadNoEncontradaException 
 */
    public void eliminar(TabPersona paramTabEntidad)
            throws EntidadNoBorradaException,EntidadNoEncontradaException;

    public void guardarPersonas(TabPersona persona) throws EntidadNoGrabadaException;
}
