package com.proyecto.web.service;

import com.proyecto.web.exceptions.EntidadNoBorradaException;
import com.proyecto.web.exceptions.EntidadNoEncontradaException;
import com.proyecto.web.exceptions.EntidadNoGrabadaException;
import com.proyecto.web.model.FichaEvacuaciones;
import java.util.List;
import javax.ejb.Local;

@Local
public interface IFichaEvacuacionesService {
/**
 * 
 * @param paramLong
 * @return
 * @throws EntidadNoEncontradaException 
 */
    public FichaEvacuaciones obtenerPorId(Long paramLong)
            throws EntidadNoEncontradaException;
/**
 * 
 * @param paramTabEntidad
 * @return 
 */
    public List<FichaEvacuaciones> buscar(FichaEvacuaciones paramTabEntidad);
/**
 * 
 * @return 
 */
    public List<FichaEvacuaciones> obtenerTodos();
/**
 * 
 * @param paramTabEntidad
 * @throws EntidadNoGrabadaException 
 */
    public void guardar(FichaEvacuaciones paramTabEntidad)
            throws EntidadNoGrabadaException;
/**
 * 
 * @param paramTabEntidad
 * @throws EntidadNoGrabadaException 
 */
    public void actualizar(FichaEvacuaciones paramTabEntidad)
            throws EntidadNoGrabadaException;
/**
 * 
 * @param paramTabEntidad
 * @throws EntidadNoBorradaException
 * @throws EntidadNoEncontradaException 
 */
    public void eliminar(FichaEvacuaciones paramTabEntidad)
            throws EntidadNoBorradaException,EntidadNoEncontradaException;

}
