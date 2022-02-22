package com.proyecto.web.service.impl;

import com.proyecto.web.dao.ICanDao;
import com.proyecto.web.dao.IEspecialidadSubtipoDao;
import com.proyecto.web.enumeration.EstadoRegistroEnum;
import com.proyecto.web.exceptions.EntidadNoBorradaException;
import com.proyecto.web.exceptions.EntidadNoEncontradaException;
import com.proyecto.web.exceptions.EntidadNoGrabadaException;
import com.proyecto.web.model.TabAnimal;
import com.proyecto.web.model.TabEspecialidadSubtipo;
import com.proyecto.web.service.IAnimalService;
import com.proyecto.web.service.ICanService;
import com.proyecto.web.service.IEspecialidadSubtipoService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class EspecialidadSubtipoServiceImpl
        implements IEspecialidadSubtipoService {

    private static final Logger LOG = Logger.getLogger(EspecialidadSubtipoServiceImpl.class.getName());

    @EJB
    IEspecialidadSubtipoDao especialidadSubtipoDao;
 
    @Override
    public TabEspecialidadSubtipo obtenerPorId(Long id)
            throws EntidadNoEncontradaException {
        return especialidadSubtipoDao.recuperar(id);
    }

    @Override
    public List<TabEspecialidadSubtipo> buscar(TabEspecialidadSubtipo especialidad) {
        return especialidadSubtipoDao.buscar(especialidad);
    }

  
    @Override
    public void guardar(TabEspecialidadSubtipo especialidad) {
        try {
            especialidadSubtipoDao.crear(especialidad);

        } catch (EntidadNoGrabadaException ex) {
            Logger.getLogger(EspecialidadSubtipoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void actualizar(TabEspecialidadSubtipo especialidad)
            throws EntidadNoGrabadaException {
        especialidadSubtipoDao.actualizar(especialidad);
    }

    @Override
    public void eliminar(TabEspecialidadSubtipo especialidad) throws EntidadNoBorradaException, EntidadNoEncontradaException {

        TabEspecialidadSubtipo especialidadBorrar = especialidadSubtipoDao.recuperar(especialidad.getId());
        especialidadSubtipoDao.eliminar(especialidadBorrar);

    }

}
