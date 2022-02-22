package com.proyecto.web.service;

import com.proyecto.web.exceptions.EntidadNoBorradaException;
import com.proyecto.web.exceptions.EntidadNoEncontradaException;
import com.proyecto.web.exceptions.EntidadNoGrabadaException;
import com.proyecto.web.model.FichaDesparacitacionInterna;
import java.util.List;
import javax.ejb.Local;

@Local
public interface IFichaDesparacitacionInternaService {
/**
 * 
 * @param paramLong
 * @return
 * @throws EntidadNoEncontradaException 
 */
    public FichaDesparacitacionInterna obtenerPorId(Long paramLong)
            throws EntidadNoEncontradaException;
/**
 * 
 * @param paramTabEntidad
 * @return 
 */
    public List<FichaDesparacitacionInterna> buscar(FichaDesparacitacionInterna paramTabEntidad);
/**
 * 
 * @return 
 */
    public List<FichaDesparacitacionInterna> obtenerTodos();
/**
 * 
 * @param paramTabEntidad
 * @throws EntidadNoGrabadaException 
 */
    public void guardar(FichaDesparacitacionInterna paramTabEntidad)
            throws EntidadNoGrabadaException;
/**
 * 
 * @param paramTabEntidad
 * @throws EntidadNoGrabadaException 
 */
    public void actualizar(FichaDesparacitacionInterna paramTabEntidad)
            throws EntidadNoGrabadaException;
/**
 * 
 * @param paramTabEntidad
 * @throws EntidadNoBorradaException
 * @throws EntidadNoEncontradaException 
 */
    public void eliminar(FichaDesparacitacionInterna paramTabEntidad)
            throws EntidadNoBorradaException,EntidadNoEncontradaException;

}
