package com.proyecto.web.service.impl;

import com.proyecto.web.dao.IFichaFisicaVisualDao;
import com.proyecto.web.exceptions.EntidadNoBorradaException;
import com.proyecto.web.exceptions.EntidadNoEncontradaException;
import com.proyecto.web.exceptions.EntidadNoGrabadaException;
import com.proyecto.web.model.FichaFisicaVisual;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.proyecto.web.dao.PersonaDao;
import com.proyecto.web.service.IFichaFisicaVisualService;
import com.proyecto.web.service.PersonaService;

@Stateless
public class FichaFisicaVisualServiceImpl
        implements IFichaFisicaVisualService {

    @EJB
    IFichaFisicaVisualDao fisicaDao;

    @Override
    public FichaFisicaVisual obtenerPorId(Long id)
            throws EntidadNoEncontradaException {
        return fisicaDao.recuperar(id);
    }

    @Override
    public List<FichaFisicaVisual> buscar(FichaFisicaVisual persona) {
        return fisicaDao.buscar(persona);
    }

    @Override
    public List<FichaFisicaVisual> obtenerTodos() {
        return fisicaDao.obtenerTodos();
    }

    @Override
    public void guardar(FichaFisicaVisual persona)
            throws EntidadNoGrabadaException {
        if (persona.getId() == null) {
            fisicaDao.crear(persona);
        } else {
            fisicaDao.actualizar(persona);
        }
    }

    @Override
    public void actualizar(FichaFisicaVisual persona)
            throws EntidadNoGrabadaException {
        fisicaDao.actualizar(persona);

    }

    /**
     *
     * @param persona
     * @throws EntidadNoBorradaException
     * @throws com.proyecto.web.exceptions.EntidadNoEncontradaException
     */
    @Override
    public void eliminar(FichaFisicaVisual persona)
            throws EntidadNoBorradaException, EntidadNoEncontradaException {

        FichaFisicaVisual personaBorrar = (FichaFisicaVisual) fisicaDao.recuperar(persona.getId());
        fisicaDao.eliminar(personaBorrar);

    }
}
