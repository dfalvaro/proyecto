package com.proyecto.web.service.impl;

import com.proyecto.web.dao.IEspecialidadDao;
import com.proyecto.web.exceptions.EntidadNoBorradaException;
import com.proyecto.web.exceptions.EntidadNoEncontradaException;
import com.proyecto.web.exceptions.EntidadNoGrabadaException;
import com.proyecto.web.model.TabEspecialidad;
import com.proyecto.web.service.IAnimalService;
import com.proyecto.web.service.IEspecialidadService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class EspecialidadServiceImpl
        implements IEspecialidadService {

    private static final Logger LOG = Logger.getLogger(EspecialidadServiceImpl.class.getName());

    @EJB
    IEspecialidadDao especialidadDao;
    @EJB
    IAnimalService animalService;

    @Override
    public TabEspecialidad obtenerPorId(Long id)
            throws EntidadNoEncontradaException {
        return especialidadDao.recuperar(id);
    }

    @Override
    public List<TabEspecialidad> buscar(TabEspecialidad especialidad) {
        return especialidadDao.buscar(especialidad);
    }

    @Override
    public void guardar(TabEspecialidad especialidad) {
        try {
            especialidadDao.crear(especialidad);

        } catch (EntidadNoGrabadaException ex) {
            Logger.getLogger(EspecialidadServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void actualizar(TabEspecialidad especialidad)
            throws EntidadNoGrabadaException {
        especialidadDao.actualizar(especialidad);
    }

    @Override
    public void eliminar(TabEspecialidad especialidad) throws EntidadNoBorradaException, EntidadNoEncontradaException {

        TabEspecialidad especialidadBorrar = especialidadDao.recuperar(especialidad.getId());
        especialidadDao.eliminar(especialidadBorrar);

    }

}
