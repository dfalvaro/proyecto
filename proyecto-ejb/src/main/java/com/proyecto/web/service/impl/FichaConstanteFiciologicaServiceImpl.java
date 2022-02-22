package com.proyecto.web.service.impl;

import com.proyecto.web.dao.IFichaConstanteFisiologicaDao;
import com.proyecto.web.exceptions.EntidadNoBorradaException;
import com.proyecto.web.exceptions.EntidadNoEncontradaException;
import com.proyecto.web.exceptions.EntidadNoGrabadaException;
import com.proyecto.web.model.FichaConstanteFisiologica;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.proyecto.web.dao.PersonaDao;
import com.proyecto.web.service.IFichaConstanteFisiologicaService;
import com.proyecto.web.service.PersonaService;

@Stateless
public class FichaConstanteFiciologicaServiceImpl
        implements IFichaConstanteFisiologicaService {

    @EJB
    IFichaConstanteFisiologicaDao constanteDao;

    @Override
    public FichaConstanteFisiologica obtenerPorId(Long id)
            throws EntidadNoEncontradaException {
        return constanteDao.recuperar(id);
    }

    @Override
    public List<FichaConstanteFisiologica> buscar(FichaConstanteFisiologica persona) {
        return constanteDao.buscar(persona);
    }

    @Override
    public List<FichaConstanteFisiologica> obtenerTodos() {
        return constanteDao.obtenerTodos();
    }

    @Override
    public void guardar(FichaConstanteFisiologica persona)
            throws EntidadNoGrabadaException {
        if (persona.getId() == null) {
            constanteDao.crear(persona);
        } else {
            constanteDao.actualizar(persona);
        }
    }

    @Override
    public void actualizar(FichaConstanteFisiologica persona)
            throws EntidadNoGrabadaException {
        constanteDao.actualizar(persona);

    }

    /**
     *
     * @param persona
     * @throws EntidadNoBorradaException
     * @throws com.proyecto.web.exceptions.EntidadNoEncontradaException
     */
    @Override
    public void eliminar(FichaConstanteFisiologica persona)
            throws EntidadNoBorradaException, EntidadNoEncontradaException {

        FichaConstanteFisiologica personaBorrar = (FichaConstanteFisiologica) constanteDao.recuperar(persona.getId());
        constanteDao.eliminar(personaBorrar);

    }
}
