package com.proyecto.web.service.impl;

import com.proyecto.web.dao.IFichaDiagnosticoDao;
import com.proyecto.web.exceptions.EntidadNoBorradaException;
import com.proyecto.web.exceptions.EntidadNoEncontradaException;
import com.proyecto.web.exceptions.EntidadNoGrabadaException;
import com.proyecto.web.model.FichaDiagnostico;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.proyecto.web.dao.PersonaDao;
import com.proyecto.web.service.IFichaDiagnosticoService;
import com.proyecto.web.service.PersonaService;

@Stateless
public class FichaDiagnosticoServiceImpl
        implements IFichaDiagnosticoService {

    @EJB
    IFichaDiagnosticoDao diagnosticoDao;

    @Override
    public FichaDiagnostico obtenerPorId(Long id)
            throws EntidadNoEncontradaException {
        return diagnosticoDao.recuperar(id);
    }

    @Override
    public List<FichaDiagnostico> buscar(FichaDiagnostico persona) {
        return diagnosticoDao.buscar(persona);
    }

    @Override
    public List<FichaDiagnostico> obtenerTodos() {
        return diagnosticoDao.obtenerTodos();
    }

    @Override
    public void guardar(FichaDiagnostico persona)
            throws EntidadNoGrabadaException {
        if (persona.getId() == null) {
            diagnosticoDao.crear(persona);
        } else {
            diagnosticoDao.actualizar(persona);
        }
    }

    @Override
    public void actualizar(FichaDiagnostico persona)
            throws EntidadNoGrabadaException {
        diagnosticoDao.actualizar(persona);

    }

    /**
     *
     * @param persona
     * @throws EntidadNoBorradaException
     * @throws com.proyecto.web.exceptions.EntidadNoEncontradaException
     */
    @Override
    public void eliminar(FichaDiagnostico persona)
            throws EntidadNoBorradaException, EntidadNoEncontradaException {

        FichaDiagnostico personaBorrar = (FichaDiagnostico) diagnosticoDao.recuperar(persona.getId());
        diagnosticoDao.eliminar(personaBorrar);

    }
}
