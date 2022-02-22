package com.proyecto.web.service.impl;

import com.proyecto.web.dao.IFichaMedicacionPrescritaDao;
import com.proyecto.web.exceptions.EntidadNoBorradaException;
import com.proyecto.web.exceptions.EntidadNoEncontradaException;
import com.proyecto.web.exceptions.EntidadNoGrabadaException;
import com.proyecto.web.model.FichaMedicacionPrescrita;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.proyecto.web.dao.PersonaDao;
import com.proyecto.web.service.IFichaMedicacionPrescritaService;
import com.proyecto.web.service.PersonaService;

@Stateless
public class FichaMedicacionPrescritaServiceImpl
        implements IFichaMedicacionPrescritaService {

    @EJB
    IFichaMedicacionPrescritaDao medicacionDao;

    @Override
    public FichaMedicacionPrescrita obtenerPorId(Long id)
            throws EntidadNoEncontradaException {
        return medicacionDao.recuperar(id);
    }

    @Override
    public List<FichaMedicacionPrescrita> buscar(FichaMedicacionPrescrita persona) {
        return medicacionDao.buscar(persona);
    }

    @Override
    public List<FichaMedicacionPrescrita> obtenerTodos() {
        return medicacionDao.obtenerTodos();
    }

    @Override
    public void guardar(FichaMedicacionPrescrita persona)
            throws EntidadNoGrabadaException {
        if (persona.getId() == null) {
            medicacionDao.crear(persona);
        } else {
            medicacionDao.actualizar(persona);
        }
    }

    @Override
    public void actualizar(FichaMedicacionPrescrita persona)
            throws EntidadNoGrabadaException {
        medicacionDao.actualizar(persona);

    }

    /**
     *
     * @param persona
     * @throws EntidadNoBorradaException
     * @throws com.proyecto.web.exceptions.EntidadNoEncontradaException
     */
    @Override
    public void eliminar(FichaMedicacionPrescrita persona)
            throws EntidadNoBorradaException, EntidadNoEncontradaException {

        FichaMedicacionPrescrita personaBorrar = (FichaMedicacionPrescrita) medicacionDao.recuperar(persona.getId());
        medicacionDao.eliminar(personaBorrar);

    }
}
