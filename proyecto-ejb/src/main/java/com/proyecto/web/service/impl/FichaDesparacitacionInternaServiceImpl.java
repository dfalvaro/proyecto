package com.proyecto.web.service.impl;

import com.proyecto.web.dao.IFichaDesparacitacionInternaDao;
import com.proyecto.web.exceptions.EntidadNoBorradaException;
import com.proyecto.web.exceptions.EntidadNoEncontradaException;
import com.proyecto.web.exceptions.EntidadNoGrabadaException;
import com.proyecto.web.model.FichaDesparacitacionInterna;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.proyecto.web.dao.PersonaDao;
import com.proyecto.web.service.IFichaDesparacitacionInternaService;
import com.proyecto.web.service.PersonaService;

@Stateless
public class FichaDesparacitacionInternaServiceImpl
        implements IFichaDesparacitacionInternaService {

    @EJB
    IFichaDesparacitacionInternaDao consultaInternaDao;

    @Override
    public FichaDesparacitacionInterna obtenerPorId(Long id)
            throws EntidadNoEncontradaException {
        return consultaInternaDao.recuperar(id);
    }

    @Override
    public List<FichaDesparacitacionInterna> buscar(FichaDesparacitacionInterna persona) {
        return consultaInternaDao.buscar(persona);
    }

    @Override
    public List<FichaDesparacitacionInterna> obtenerTodos() {
        return consultaInternaDao.obtenerTodos();
    }

    @Override
    public void guardar(FichaDesparacitacionInterna persona)
            throws EntidadNoGrabadaException {
        if (persona.getId() == null) {
            consultaInternaDao.crear(persona);
        } else {
            consultaInternaDao.actualizar(persona);
        }
    }

    @Override
    public void actualizar(FichaDesparacitacionInterna persona)
            throws EntidadNoGrabadaException {
        consultaInternaDao.actualizar(persona);

    }

    /**
     *
     * @param persona
     * @throws EntidadNoBorradaException
     * @throws com.proyecto.web.exceptions.EntidadNoEncontradaException
     */
    @Override
    public void eliminar(FichaDesparacitacionInterna persona)
            throws EntidadNoBorradaException, EntidadNoEncontradaException {

        FichaDesparacitacionInterna personaBorrar = (FichaDesparacitacionInterna) consultaInternaDao.recuperar(persona.getId());
        consultaInternaDao.eliminar(personaBorrar);

    }
}
