package com.proyecto.web.service;

import com.proyecto.web.exceptions.EntidadNoBorradaException;
import com.proyecto.web.exceptions.EntidadNoEncontradaException;
import com.proyecto.web.exceptions.EntidadNoGrabadaException;
import com.proyecto.web.model.TabAnimal;
import com.proyecto.web.model.TabEspecialidadSubtipo;
import java.util.List;
import javax.ejb.Local;

@Local
public interface IEspecialidadSubtipoService {

    /**
     * *
     *
     * @param paramLong
     * @return
     * @throws EntidadNoEncontradaException
     */
    public TabEspecialidadSubtipo obtenerPorId(Long paramLong)
            throws EntidadNoEncontradaException;

    /**
     *
     * @param especialidad
     * @return
     */
    public List<TabEspecialidadSubtipo> buscar(TabEspecialidadSubtipo especialidad);

    /**
     *
     * @param especialidad
     * @throws EntidadNoGrabadaException
     */
    public void guardar(TabEspecialidadSubtipo especialidad)
            throws EntidadNoGrabadaException;

    /**
     *
     * @param especialidad
     * @throws EntidadNoGrabadaException
     */
    public void actualizar(TabEspecialidadSubtipo especialidad)
            throws EntidadNoGrabadaException;

    /**
     *
     * @param especialidad
     * @throws EntidadNoBorradaException
     * @throws EntidadNoEncontradaException
     */
    public void eliminar(TabEspecialidadSubtipo especialidad)
            throws EntidadNoBorradaException, EntidadNoEncontradaException;


}
