package com.proyecto.web.service;

import com.proyecto.web.exceptions.EntidadNoBorradaException;
import com.proyecto.web.exceptions.EntidadNoEncontradaException;
import com.proyecto.web.exceptions.EntidadNoGrabadaException;
import com.proyecto.web.model.TabAnimal;
import java.util.List;
import javax.ejb.Local;

@Local
public interface IAnimalService {

    /**
     * *
     *
     * @param paramLong
     * @return
     * @throws EntidadNoEncontradaException
     */
    public TabAnimal obtenerPorId(Long paramLong)
            throws EntidadNoEncontradaException;

    /**
     *
     * @param animal
     * @return
     */
    public List<TabAnimal> buscar(TabAnimal animal);

    /**
     *
     * @param animal
     * @throws EntidadNoGrabadaException
     */
    public void guardar(TabAnimal animal)
            throws EntidadNoGrabadaException;

    /**
     *
     * @param animal
     * @throws EntidadNoGrabadaException
     */
    public void actualizar(TabAnimal animal)
            throws EntidadNoGrabadaException;

    /**
     *
     * @param animal
     * @throws EntidadNoBorradaException
     * @throws EntidadNoEncontradaException
     */
    public void eliminar(TabAnimal animal)
            throws EntidadNoBorradaException, EntidadNoEncontradaException;

    public void guardarAnimal(TabAnimal animal)
            throws EntidadNoGrabadaException;

}
