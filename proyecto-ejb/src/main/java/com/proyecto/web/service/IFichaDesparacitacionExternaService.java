package com.proyecto.web.service;

import com.proyecto.web.exceptions.EntidadNoBorradaException;
import com.proyecto.web.exceptions.EntidadNoEncontradaException;
import com.proyecto.web.exceptions.EntidadNoGrabadaException;
import com.proyecto.web.model.FichaDesparacitacionExterna;
import java.util.List;
import javax.ejb.Local;

@Local
public interface IFichaDesparacitacionExternaService {
/**
 * 
 * @param paramLong
 * @return
 * @throws EntidadNoEncontradaException 
 */
    public FichaDesparacitacionExterna obtenerPorId(Long paramLong)
            throws EntidadNoEncontradaException;
/**
 * 
 * @param paramTabEntidad
 * @return 
 */
    public List<FichaDesparacitacionExterna> buscar(FichaDesparacitacionExterna paramTabEntidad);
/**
 * 
 * @return 
 */
    public List<FichaDesparacitacionExterna> obtenerTodos();
/**
 * 
 * @param paramTabEntidad
 * @throws EntidadNoGrabadaException 
 */
    public void guardar(FichaDesparacitacionExterna paramTabEntidad)
            throws EntidadNoGrabadaException;
/**
 * 
 * @param paramTabEntidad
 * @throws EntidadNoGrabadaException 
 */
    public void actualizar(FichaDesparacitacionExterna paramTabEntidad)
            throws EntidadNoGrabadaException;
/**
 * 
 * @param paramTabEntidad
 * @throws EntidadNoBorradaException
 * @throws EntidadNoEncontradaException 
 */
    public void eliminar(FichaDesparacitacionExterna paramTabEntidad)
            throws EntidadNoBorradaException,EntidadNoEncontradaException;

}
