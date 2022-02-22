package com.proyecto.web.service.impl;

import com.proyecto.web.dao.IFichaVacunacionDao;
import com.proyecto.web.exceptions.EntidadNoBorradaException;
import com.proyecto.web.exceptions.EntidadNoEncontradaException;
import com.proyecto.web.exceptions.EntidadNoGrabadaException;
import com.proyecto.web.model.FichaVacunacion;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.proyecto.web.dao.PersonaDao;
import com.proyecto.web.service.IFichaVacunacionService;
import com.proyecto.web.service.PersonaService;

@Stateless
public class FichaVacunacionServiceImpl
        implements IFichaVacunacionService {

    @EJB
    IFichaVacunacionDao vacunacionDao;

    @Override
    public FichaVacunacion obtenerPorId(Long id)
            throws EntidadNoEncontradaException {
        return vacunacionDao.recuperar(id);
    }

    @Override
    public List<FichaVacunacion> buscar(FichaVacunacion persona) {
        return vacunacionDao.buscar(persona);
    }

    @Override
    public List<FichaVacunacion> obtenerTodos() {
        return vacunacionDao.obtenerTodos();
    }

    @Override
    public void guardar(FichaVacunacion persona)
            throws EntidadNoGrabadaException {
        if (persona.getId() == null) {
            vacunacionDao.crear(persona);
        } else {
            vacunacionDao.actualizar(persona);
        }
    }

    @Override
    public void actualizar(FichaVacunacion persona)
            throws EntidadNoGrabadaException {
        vacunacionDao.actualizar(persona);

    }

    /**
     *
     * @param persona
     * @throws EntidadNoBorradaException
     * @throws com.proyecto.web.exceptions.EntidadNoEncontradaException
     */
    @Override
    public void eliminar(FichaVacunacion persona)
            throws EntidadNoBorradaException, EntidadNoEncontradaException {

        FichaVacunacion personaBorrar = (FichaVacunacion) vacunacionDao.recuperar(persona.getId());
        vacunacionDao.eliminar(personaBorrar);

    }
}
