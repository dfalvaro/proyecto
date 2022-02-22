package com.proyecto.web.service.impl;

import com.proyecto.web.dao.ITecnicaExamenDao;
import com.proyecto.web.exceptions.EntidadNoBorradaException;
import com.proyecto.web.exceptions.EntidadNoEncontradaException;
import com.proyecto.web.exceptions.EntidadNoGrabadaException;
import com.proyecto.web.model.TecnicaExamen;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.proyecto.web.model.FichaConstanteFisiologica;
import com.proyecto.web.model.FichaDiagnostico;
import com.proyecto.web.model.FichaEvacuaciones;
import com.proyecto.web.model.FichaFisicaVisual;
import com.proyecto.web.model.FichaMedicacionPrescrita;
import com.proyecto.web.service.ITecnicaExamenService;

@Stateless
public class TecnicaExamenServiceImpl
        implements ITecnicaExamenService {

    @EJB
    ITecnicaExamenDao tecnicaExamenDao;

    @Override
    public TecnicaExamen obtenerPorId(Long id)
            throws EntidadNoEncontradaException {
        return tecnicaExamenDao.recuperar(id);
    }

    @Override
    public List<TecnicaExamen> buscar(TecnicaExamen persona) {
        return tecnicaExamenDao.buscar(persona);
    }

    @Override
    public List<TecnicaExamen> obtenerTodos() {
        return tecnicaExamenDao.obtenerTodos();
    }

    @Override
    public void guardar(TecnicaExamen persona)
            throws EntidadNoGrabadaException {
        if (persona.getId() == null) {
            tecnicaExamenDao.crear(persona);
        } else {
            tecnicaExamenDao.actualizar(persona);
        }
    }

    @Override
    public void actualizar(TecnicaExamen persona)
            throws EntidadNoGrabadaException {
        tecnicaExamenDao.actualizar(persona);

    }

    /**
     *
     * @param persona
     * @throws EntidadNoBorradaException
     * @throws com.proyecto.web.exceptions.EntidadNoEncontradaException
     */
    @Override
    public void eliminar(TecnicaExamen persona)
            throws EntidadNoBorradaException, EntidadNoEncontradaException {

        TecnicaExamen personaBorrar = (TecnicaExamen) tecnicaExamenDao.recuperar(persona.getId());
        tecnicaExamenDao.eliminar(personaBorrar);

    }

}
