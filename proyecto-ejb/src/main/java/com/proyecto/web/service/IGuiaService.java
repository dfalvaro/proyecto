package com.proyecto.web.service;

import com.proyecto.web.exceptions.EntidadNoBorradaException;
import com.proyecto.web.exceptions.EntidadNoEncontradaException;
import com.proyecto.web.exceptions.EntidadNoGrabadaException;
import com.proyecto.web.model.TabGuia;
import com.proyecto.web.model.TabPersona;
import java.util.List;
import javax.ejb.Local;

@Local
public interface IGuiaService {

    /**
     * *
     *
     * @param paramLong
     * @return
     * @throws EntidadNoEncontradaException
     */
    public TabGuia obtenerPorId(Long paramLong)
            throws EntidadNoEncontradaException;

    /**
     *
     * @param guia
     * @return
     */
    public List<TabGuia> buscar(TabGuia guia);

    /**
     *
     * @param guia
     * @throws EntidadNoGrabadaException
     */
    public void guardar(TabGuia guia)
            throws EntidadNoGrabadaException;

    /**
     *
     * @param guia
     * @throws EntidadNoGrabadaException
     */
    public void actualizar(TabGuia guia)
            throws EntidadNoGrabadaException;

    /**
     *
     * @param guia
     * @throws EntidadNoBorradaException
     * @throws EntidadNoEncontradaException
     */
    public void eliminar(TabGuia guia)
            throws EntidadNoBorradaException, EntidadNoEncontradaException;

    public void guardarGuia(TabGuia guia, TabPersona persona) throws EntidadNoGrabadaException, EntidadNoEncontradaException;


}
