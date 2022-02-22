package com.proyecto.web.service.impl;

import com.proyecto.web.dao.ITecnicaDetectoresResultadoDao;
import com.proyecto.web.exceptions.EntidadNoBorradaException;
import com.proyecto.web.exceptions.EntidadNoEncontradaException;
import com.proyecto.web.exceptions.EntidadNoGrabadaException;
import com.proyecto.web.model.TecnicaDetectoresResultado;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.proyecto.web.service.ITecnicaDetectoresResultadoService;

@Stateless
public class TecnicaDetectoresResultadoServiceImpl
        implements ITecnicaDetectoresResultadoService {

    @EJB
    ITecnicaDetectoresResultadoDao consultaDao;

    @Override
    public TecnicaDetectoresResultado obtenerPorId(Long id)
            throws EntidadNoEncontradaException {
        return consultaDao.recuperar(id);
    }

    @Override
    public List<TecnicaDetectoresResultado> buscar(TecnicaDetectoresResultado persona) {
        return consultaDao.buscar(persona);
    }

    @Override
    public List<TecnicaDetectoresResultado> obtenerTodos() {
        return consultaDao.obtenerTodos();
    }

    @Override
    public void guardar(TecnicaDetectoresResultado persona)
            throws EntidadNoGrabadaException {
        if (persona.getId() == null) {
            consultaDao.crear(persona);
        } else {
            consultaDao.actualizar(persona);
        }
    }

    @Override
    public void actualizar(TecnicaDetectoresResultado persona)
            throws EntidadNoGrabadaException {
        consultaDao.actualizar(persona);

    }

    /**
     *
     * @param persona
     * @throws EntidadNoBorradaException
     * @throws com.proyecto.web.exceptions.EntidadNoEncontradaException
     */
    @Override
    public void eliminar(TecnicaDetectoresResultado persona)
            throws EntidadNoBorradaException, EntidadNoEncontradaException {

        TecnicaDetectoresResultado personaBorrar = (TecnicaDetectoresResultado) consultaDao.recuperar(persona.getId());
        consultaDao.eliminar(personaBorrar);

    }

}
