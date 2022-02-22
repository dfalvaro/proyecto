package com.proyecto.web.service.impl;

import com.proyecto.web.dao.IFichaDesparacitacionExternaDao;
import com.proyecto.web.exceptions.EntidadNoBorradaException;
import com.proyecto.web.exceptions.EntidadNoEncontradaException;
import com.proyecto.web.exceptions.EntidadNoGrabadaException;
import com.proyecto.web.model.FichaDesparacitacionExterna;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.proyecto.web.dao.PersonaDao;
import com.proyecto.web.service.IFichaDesparacitacionExternaService;
import com.proyecto.web.service.PersonaService;

@Stateless
public class FichaDesparacitacionExternaServiceImpl
        implements IFichaDesparacitacionExternaService {

    @EJB
    IFichaDesparacitacionExternaDao consultaExternaDao;

    @Override
    public FichaDesparacitacionExterna obtenerPorId(Long id)
            throws EntidadNoEncontradaException {
        return consultaExternaDao.recuperar(id);
    }

    @Override
    public List<FichaDesparacitacionExterna> buscar(FichaDesparacitacionExterna persona) {
        return consultaExternaDao.buscar(persona);
    }

    @Override
    public List<FichaDesparacitacionExterna> obtenerTodos() {
        return consultaExternaDao.obtenerTodos();
    }

    @Override
    public void guardar(FichaDesparacitacionExterna persona)
            throws EntidadNoGrabadaException {
        if (persona.getId() == null) {
            consultaExternaDao.crear(persona);
        } else {
            consultaExternaDao.actualizar(persona);
        }
    }

    @Override
    public void actualizar(FichaDesparacitacionExterna persona)
            throws EntidadNoGrabadaException {
        consultaExternaDao.actualizar(persona);

    }

    /**
     *
     * @param persona
     * @throws EntidadNoBorradaException
     * @throws com.proyecto.web.exceptions.EntidadNoEncontradaException
     */
    @Override
    public void eliminar(FichaDesparacitacionExterna persona)
            throws EntidadNoBorradaException, EntidadNoEncontradaException {

        FichaDesparacitacionExterna personaBorrar = (FichaDesparacitacionExterna) consultaExternaDao.recuperar(persona.getId());
        consultaExternaDao.eliminar(personaBorrar);

    }
}
