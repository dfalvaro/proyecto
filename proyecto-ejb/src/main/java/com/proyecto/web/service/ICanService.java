package com.proyecto.web.service;

import com.proyecto.web.exceptions.EntidadNoBorradaException;
import com.proyecto.web.exceptions.EntidadNoEncontradaException;
import com.proyecto.web.exceptions.EntidadNoGrabadaException;
import com.proyecto.web.model.TabAnimal;
import com.proyecto.web.model.TabCan;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ICanService {

    /**
     * *
     *
     * @param paramLong
     * @return
     * @throws EntidadNoEncontradaException
     */
    public TabCan obtenerPorId(Long paramLong)
            throws EntidadNoEncontradaException;

    /**
     *
     * @param can
     * @return
     */
    public List<TabCan> buscar(TabCan can);

    /**
     *
     * @param can
     * @throws EntidadNoGrabadaException
     */
    public void guardar(TabCan can)
            throws EntidadNoGrabadaException;

    /**
     *
     * @param can
     * @throws EntidadNoGrabadaException
     */
    public void actualizar(TabCan can)
            throws EntidadNoGrabadaException;

    /**
     *
     * @param can
     * @throws EntidadNoBorradaException
     * @throws EntidadNoEncontradaException
     */
    public void eliminar(TabCan can)
            throws EntidadNoBorradaException, EntidadNoEncontradaException;

    public void guardarCan(TabCan can, TabAnimal animal) throws EntidadNoGrabadaException, EntidadNoEncontradaException;

    public Long obtenerSecuencialFinal();

}
