package com.proyecto.web.service;

import com.proyecto.web.exceptions.EntidadNoBorradaException;
import com.proyecto.web.exceptions.EntidadNoEncontradaException;
import com.proyecto.web.exceptions.EntidadNoGrabadaException;
import com.proyecto.web.model.FichaConstanteFisiologica;
import java.util.List;
import javax.ejb.Local;

@Local
public interface IFichaConstanteFisiologicaService {

    /**
     *
     * @param paramLong
     * @return
     * @throws EntidadNoEncontradaException
     */
    public FichaConstanteFisiologica obtenerPorId(Long paramLong)
            throws EntidadNoEncontradaException;

    /**
     *
     * @param paramTabEntidad
     * @return
     */
    public List<FichaConstanteFisiologica> buscar(FichaConstanteFisiologica paramTabEntidad);

    /**
     *
     * @return
     */
    public List<FichaConstanteFisiologica> obtenerTodos();

    /**
     *
     * @param paramTabEntidad
     * @throws EntidadNoGrabadaException
     */
    public void guardar(FichaConstanteFisiologica paramTabEntidad)
            throws EntidadNoGrabadaException;

    /**
     *
     * @param paramTabEntidad
     * @throws EntidadNoGrabadaException
     */
    public void actualizar(FichaConstanteFisiologica paramTabEntidad)
            throws EntidadNoGrabadaException;

    /**
     *
     * @param paramTabEntidad
     * @throws EntidadNoBorradaException
     * @throws EntidadNoEncontradaException
     */
    public void eliminar(FichaConstanteFisiologica paramTabEntidad)
            throws EntidadNoBorradaException, EntidadNoEncontradaException;

}
