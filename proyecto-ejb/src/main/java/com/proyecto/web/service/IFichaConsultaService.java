package com.proyecto.web.service;

import com.proyecto.web.exceptions.EntidadNoBorradaException;
import com.proyecto.web.exceptions.EntidadNoEncontradaException;
import com.proyecto.web.exceptions.EntidadNoGrabadaException;
import com.proyecto.web.model.FichaConstanteFisiologica;
import com.proyecto.web.model.FichaConsulta;
import com.proyecto.web.model.FichaDiagnostico;
import com.proyecto.web.model.FichaEvacuaciones;
import com.proyecto.web.model.FichaFisicaVisual;
import com.proyecto.web.model.FichaMedicacionPrescrita;
import java.util.List;
import javax.ejb.Local;

@Local
public interface IFichaConsultaService {

    /**
     *
     * @param paramLong
     * @return
     * @throws EntidadNoEncontradaException
     */
    public FichaConsulta obtenerPorId(Long paramLong)
            throws EntidadNoEncontradaException;

    /**
     *
     * @param paramTabEntidad
     * @return
     */
    public List<FichaConsulta> buscar(FichaConsulta paramTabEntidad);

    /**
     *
     * @return
     */
    public List<FichaConsulta> obtenerTodos();

    /**
     *
     * @param paramTabEntidad
     * @throws EntidadNoGrabadaException
     */
    public void guardar(FichaConsulta paramTabEntidad)
            throws EntidadNoGrabadaException;

    /**
     *
     * @param paramTabEntidad
     * @throws EntidadNoGrabadaException
     */
    public void actualizar(FichaConsulta paramTabEntidad)
            throws EntidadNoGrabadaException;

    /**
     *
     * @param paramTabEntidad
     * @throws EntidadNoBorradaException
     * @throws EntidadNoEncontradaException
     */
    public void eliminar(FichaConsulta paramTabEntidad)
            throws EntidadNoBorradaException, EntidadNoEncontradaException;

    /**
     *
     * @param paramTabEntidad
     * @throws EntidadNoGrabadaException
     */
    public void guardarHistoria(FichaConsulta consulta,FichaConstanteFisiologica constanteFisiologica, FichaFisicaVisual visual ,FichaEvacuaciones evacuaciones, FichaDiagnostico diagnostico, FichaMedicacionPrescrita medicacionPrescrita)
            throws EntidadNoGrabadaException;

}
