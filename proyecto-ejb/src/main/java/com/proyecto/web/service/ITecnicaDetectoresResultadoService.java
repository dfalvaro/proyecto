package com.proyecto.web.service;

import com.proyecto.web.exceptions.EntidadNoBorradaException;
import com.proyecto.web.exceptions.EntidadNoEncontradaException;
import com.proyecto.web.exceptions.EntidadNoGrabadaException;
import com.proyecto.web.model.FichaConstanteFisiologica;
import com.proyecto.web.model.TecnicaDetectoresResultado;
import com.proyecto.web.model.FichaDiagnostico;
import com.proyecto.web.model.FichaEvacuaciones;
import com.proyecto.web.model.FichaFisicaVisual;
import com.proyecto.web.model.FichaMedicacionPrescrita;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ITecnicaDetectoresResultadoService {

    /**
     *
     * @param paramLong
     * @return
     * @throws EntidadNoEncontradaException
     */
    public TecnicaDetectoresResultado obtenerPorId(Long paramLong)
            throws EntidadNoEncontradaException;

    /**
     *
     * @param paramTabEntidad
     * @return
     */
    public List<TecnicaDetectoresResultado> buscar(TecnicaDetectoresResultado paramTabEntidad);

    /**
     *
     * @return
     */
    public List<TecnicaDetectoresResultado> obtenerTodos();

    /**
     *
     * @param paramTabEntidad
     * @throws EntidadNoGrabadaException
     */
    public void guardar(TecnicaDetectoresResultado paramTabEntidad)
            throws EntidadNoGrabadaException;

    /**
     *
     * @param paramTabEntidad
     * @throws EntidadNoGrabadaException
     */
    public void actualizar(TecnicaDetectoresResultado paramTabEntidad)
            throws EntidadNoGrabadaException;

    /**
     *
     * @param paramTabEntidad
     * @throws EntidadNoBorradaException
     * @throws EntidadNoEncontradaException
     */
    public void eliminar(TecnicaDetectoresResultado paramTabEntidad)
            throws EntidadNoBorradaException, EntidadNoEncontradaException;

 

}
