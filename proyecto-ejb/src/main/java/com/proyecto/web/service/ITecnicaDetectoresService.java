package com.proyecto.web.service;

import com.proyecto.web.exceptions.EntidadNoBorradaException;
import com.proyecto.web.exceptions.EntidadNoEncontradaException;
import com.proyecto.web.exceptions.EntidadNoGrabadaException;
import com.proyecto.web.model.FichaConstanteFisiologica;
import com.proyecto.web.model.TecnicaDetectores;
import com.proyecto.web.model.FichaDiagnostico;
import com.proyecto.web.model.FichaEvacuaciones;
import com.proyecto.web.model.FichaFisicaVisual;
import com.proyecto.web.model.FichaMedicacionPrescrita;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ITecnicaDetectoresService {

    /**
     *
     * @param paramLong
     * @return
     * @throws EntidadNoEncontradaException
     */
    public TecnicaDetectores obtenerPorId(Long paramLong)
            throws EntidadNoEncontradaException;

    /**
     *
     * @param paramTabEntidad
     * @return
     */
    public List<TecnicaDetectores> buscar(TecnicaDetectores paramTabEntidad);

    /**
     *
     * @return
     */
    public List<TecnicaDetectores> obtenerTodos();

    /**
     *
     * @param paramTabEntidad
     * @throws EntidadNoGrabadaException
     */
    public void guardar(TecnicaDetectores paramTabEntidad)
            throws EntidadNoGrabadaException;

    /**
     *
     * @param paramTabEntidad
     * @throws EntidadNoGrabadaException
     */
    public void actualizar(TecnicaDetectores paramTabEntidad)
            throws EntidadNoGrabadaException;

    /**
     *
     * @param paramTabEntidad
     * @throws EntidadNoBorradaException
     * @throws EntidadNoEncontradaException
     */
    public void eliminar(TecnicaDetectores paramTabEntidad)
            throws EntidadNoBorradaException, EntidadNoEncontradaException;

  

}
