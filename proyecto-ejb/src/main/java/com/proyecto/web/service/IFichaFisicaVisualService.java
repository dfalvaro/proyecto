package com.proyecto.web.service;

import com.proyecto.web.exceptions.EntidadNoBorradaException;
import com.proyecto.web.exceptions.EntidadNoEncontradaException;
import com.proyecto.web.exceptions.EntidadNoGrabadaException;
import com.proyecto.web.model.FichaFisicaVisual;
import java.util.List;
import javax.ejb.Local;

@Local
public interface IFichaFisicaVisualService {
/**
 * 
 * @param paramLong
 * @return
 * @throws EntidadNoEncontradaException 
 */
    public FichaFisicaVisual obtenerPorId(Long paramLong)
            throws EntidadNoEncontradaException;
/**
 * 
 * @param paramTabEntidad
 * @return 
 */
    public List<FichaFisicaVisual> buscar(FichaFisicaVisual paramTabEntidad);
/**
 * 
 * @return 
 */
    public List<FichaFisicaVisual> obtenerTodos();
/**
 * 
 * @param paramTabEntidad
 * @throws EntidadNoGrabadaException 
 */
    public void guardar(FichaFisicaVisual paramTabEntidad)
            throws EntidadNoGrabadaException;
/**
 * 
 * @param paramTabEntidad
 * @throws EntidadNoGrabadaException 
 */
    public void actualizar(FichaFisicaVisual paramTabEntidad)
            throws EntidadNoGrabadaException;
/**
 * 
 * @param paramTabEntidad
 * @throws EntidadNoBorradaException
 * @throws EntidadNoEncontradaException 
 */
    public void eliminar(FichaFisicaVisual paramTabEntidad)
            throws EntidadNoBorradaException,EntidadNoEncontradaException;

}
