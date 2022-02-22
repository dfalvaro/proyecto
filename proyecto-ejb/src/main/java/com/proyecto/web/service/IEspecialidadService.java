package com.proyecto.web.service;

import com.proyecto.web.exceptions.EntidadNoBorradaException;
import com.proyecto.web.exceptions.EntidadNoEncontradaException;
import com.proyecto.web.exceptions.EntidadNoGrabadaException;
import com.proyecto.web.model.TabEspecialidad;
import java.util.List;
import javax.ejb.Local;

@Local
public interface IEspecialidadService {

    /**
     * *
     *
     * @param paramLong
     * @return
     * @throws EntidadNoEncontradaException
     */
    public TabEspecialidad obtenerPorId(Long paramLong)
            throws EntidadNoEncontradaException;

    /**
     *
     * @param especialidad
     * @return
     */
    public List<TabEspecialidad> buscar(TabEspecialidad especialidad);

    /**
     *
     * @param especialidad
     * @throws EntidadNoGrabadaException
     */
    public void guardar(TabEspecialidad especialidad)
            throws EntidadNoGrabadaException;

    /**
     *
     * @param especialidad
     * @throws EntidadNoGrabadaException
     */
    public void actualizar(TabEspecialidad especialidad)
            throws EntidadNoGrabadaException;

    /**
     *
     * @param especialidad
     * @throws EntidadNoBorradaException
     * @throws EntidadNoEncontradaException
     */
    public void eliminar(TabEspecialidad especialidad)
            throws EntidadNoBorradaException, EntidadNoEncontradaException;


}
