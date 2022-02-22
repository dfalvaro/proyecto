package com.proyecto.web.service.impl;

import com.proyecto.web.dao.IFichaEvacuacionesDao;
import com.proyecto.web.exceptions.EntidadNoBorradaException;
import com.proyecto.web.exceptions.EntidadNoEncontradaException;
import com.proyecto.web.exceptions.EntidadNoGrabadaException;
import com.proyecto.web.model.FichaEvacuaciones;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.proyecto.web.dao.PersonaDao;
import com.proyecto.web.service.IFichaEvacuacionesService;
import com.proyecto.web.service.PersonaService;

@Stateless
public class FichaEvacuacionesServiceImpl
        implements IFichaEvacuacionesService {

    @EJB
    IFichaEvacuacionesDao evacuacionDao;

    @Override
    public FichaEvacuaciones obtenerPorId(Long id)
            throws EntidadNoEncontradaException {
        return evacuacionDao.recuperar(id);
    }

    @Override
    public List<FichaEvacuaciones> buscar(FichaEvacuaciones persona) {
        return evacuacionDao.buscar(persona);
    }

    @Override
    public List<FichaEvacuaciones> obtenerTodos() {
        return evacuacionDao.obtenerTodos();
    }

    @Override
    public void guardar(FichaEvacuaciones persona)
            throws EntidadNoGrabadaException {
        if (persona.getId() == null) {
            evacuacionDao.crear(persona);
        } else {
            evacuacionDao.actualizar(persona);
        }
    }

    @Override
    public void actualizar(FichaEvacuaciones persona)
            throws EntidadNoGrabadaException {
        evacuacionDao.actualizar(persona);

    }

    /**
     *
     * @param persona
     * @throws EntidadNoBorradaException
     * @throws com.proyecto.web.exceptions.EntidadNoEncontradaException
     */
    @Override
    public void eliminar(FichaEvacuaciones persona)
            throws EntidadNoBorradaException, EntidadNoEncontradaException {

        FichaEvacuaciones personaBorrar = (FichaEvacuaciones) evacuacionDao.recuperar(persona.getId());
        evacuacionDao.eliminar(personaBorrar);

    }
}
