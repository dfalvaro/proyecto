package com.proyecto.web.service;

import com.proyecto.web.exceptions.EntidadNoBorradaException;
import com.proyecto.web.exceptions.EntidadNoEncontradaException;
import com.proyecto.web.exceptions.EntidadNoGrabadaException;
import com.proyecto.web.model.FichaDiagnostico;
import java.util.List;
import javax.ejb.Local;

@Local
public interface IFichaDiagnosticoService {
/**
 * 
 * @param paramLong
 * @return
 * @throws EntidadNoEncontradaException 
 */
    public FichaDiagnostico obtenerPorId(Long paramLong)
            throws EntidadNoEncontradaException;
/**
 * 
 * @param paramTabEntidad
 * @return 
 */
    public List<FichaDiagnostico> buscar(FichaDiagnostico paramTabEntidad);
/**
 * 
 * @return 
 */
    public List<FichaDiagnostico> obtenerTodos();
/**
 * 
 * @param paramTabEntidad
 * @throws EntidadNoGrabadaException 
 */
    public void guardar(FichaDiagnostico paramTabEntidad)
            throws EntidadNoGrabadaException;
/**
 * 
 * @param paramTabEntidad
 * @throws EntidadNoGrabadaException 
 */
    public void actualizar(FichaDiagnostico paramTabEntidad)
            throws EntidadNoGrabadaException;
/**
 * 
 * @param paramTabEntidad
 * @throws EntidadNoBorradaException
 * @throws EntidadNoEncontradaException 
 */
    public void eliminar(FichaDiagnostico paramTabEntidad)
            throws EntidadNoBorradaException,EntidadNoEncontradaException;

}
