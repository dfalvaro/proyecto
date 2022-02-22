package com.proyecto.web.service;

import com.proyecto.web.exceptions.EntidadNoBorradaException;
import com.proyecto.web.exceptions.EntidadNoEncontradaException;
import com.proyecto.web.exceptions.EntidadNoGrabadaException;
import com.proyecto.web.model.FichaConstanteFisiologica;
import com.proyecto.web.model.TecnicaExamen;
import com.proyecto.web.model.FichaDiagnostico;
import com.proyecto.web.model.FichaEvacuaciones;
import com.proyecto.web.model.FichaFisicaVisual;
import com.proyecto.web.model.FichaMedicacionPrescrita;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ITecnicaExamenService {

    /**
     *
     * @param paramLong
     * @return
     * @throws EntidadNoEncontradaException
     */
    public TecnicaExamen obtenerPorId(Long paramLong)
            throws EntidadNoEncontradaException;

    /**
     *
     * @param paramTabEntidad
     * @return
     */
    public List<TecnicaExamen> buscar(TecnicaExamen paramTabEntidad);

    /**
     *
     * @return
     */
    public List<TecnicaExamen> obtenerTodos();

    /**
     *
     * @param paramTabEntidad
     * @throws EntidadNoGrabadaException
     */
    public void guardar(TecnicaExamen paramTabEntidad)
            throws EntidadNoGrabadaException;

    /**
     *
     * @param paramTabEntidad
     * @throws EntidadNoGrabadaException
     */
    public void actualizar(TecnicaExamen paramTabEntidad)
            throws EntidadNoGrabadaException;

    /**
     *
     * @param paramTabEntidad
     * @throws EntidadNoBorradaException
     * @throws EntidadNoEncontradaException
     */
    public void eliminar(TecnicaExamen paramTabEntidad)
            throws EntidadNoBorradaException, EntidadNoEncontradaException;

  
}
