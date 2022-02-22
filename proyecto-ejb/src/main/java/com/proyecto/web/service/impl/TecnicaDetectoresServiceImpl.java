package com.proyecto.web.service.impl;

import com.proyecto.web.dao.ITecnicaDetectoresDao;
import com.proyecto.web.exceptions.EntidadNoBorradaException;
import com.proyecto.web.exceptions.EntidadNoEncontradaException;
import com.proyecto.web.exceptions.EntidadNoGrabadaException;
import com.proyecto.web.model.TecnicaDetectores;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.proyecto.web.service.ITecnicaDetectoresService;

@Stateless
public class TecnicaDetectoresServiceImpl
        implements ITecnicaDetectoresService {

    @EJB
    ITecnicaDetectoresDao tecnicaDetectorDao;
   

    @Override
    public TecnicaDetectores obtenerPorId(Long id)
            throws EntidadNoEncontradaException {
        return tecnicaDetectorDao.recuperar(id);
    }

    @Override
    public List<TecnicaDetectores> buscar(TecnicaDetectores persona) {
        return tecnicaDetectorDao.buscar(persona);
    }

    @Override
    public List<TecnicaDetectores> obtenerTodos() {
        return tecnicaDetectorDao.obtenerTodos();
    }

    @Override
    public void guardar(TecnicaDetectores persona)
            throws EntidadNoGrabadaException {
        if (persona.getId() == null) {
            tecnicaDetectorDao.crear(persona);
        } else {
            tecnicaDetectorDao.actualizar(persona);
        }
    }

    @Override
    public void actualizar(TecnicaDetectores persona)
            throws EntidadNoGrabadaException {
        tecnicaDetectorDao.actualizar(persona);

    }

    /**
     *
     * @param persona
     * @throws EntidadNoBorradaException
     * @throws com.proyecto.web.exceptions.EntidadNoEncontradaException
     */
    @Override
    public void eliminar(TecnicaDetectores persona)
            throws EntidadNoBorradaException, EntidadNoEncontradaException {

        TecnicaDetectores personaBorrar = (TecnicaDetectores) tecnicaDetectorDao.recuperar(persona.getId());
        tecnicaDetectorDao.eliminar(personaBorrar);

    }

}
