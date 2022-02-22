package com.proyecto.web.service.impl;

import com.proyecto.web.dao.IAnimalDao;
import com.proyecto.web.enumeration.TipoImagenEnum;
import com.proyecto.web.exceptions.EntidadNoBorradaException;
import com.proyecto.web.exceptions.EntidadNoEncontradaException;
import com.proyecto.web.exceptions.EntidadNoGrabadaException;
import com.proyecto.web.model.TabAnimal;
import com.proyecto.web.service.IAnimalService;
import com.proyecto.web.util.Util;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AnimalServiceImpl
        implements IAnimalService {

    private static final Logger LOG = Logger.getLogger(AnimalServiceImpl.class.getName());

    @EJB
    IAnimalDao animalDao;

    @Override
    public TabAnimal obtenerPorId(Long id)
            throws EntidadNoEncontradaException {
        return animalDao.recuperar(id);
    }

    @Override
    public List<TabAnimal> buscar(TabAnimal animal) {
        return animalDao.buscar(animal);
    }

    @Override
    public void guardar(TabAnimal animal) {
        try {
            animalDao.crear(animal);
            subirImagenes(animal);
        } catch (EntidadNoGrabadaException ex) {
            Logger.getLogger(AnimalServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void subirImagenes(TabAnimal animal) throws EntidadNoGrabadaException {
        if (animal.getImagenBase64() != null) {
            String imagen = Util.subirImagenJpg(animal.getImagenBase64(), animal.getNombreImagen(), TipoImagenEnum.CAN.name());
            String imagenRedimencionada = Util.subirImagenJpgRedimencionada(animal.getImagenBase64(), animal.getNombreImagen(), TipoImagenEnum.CAN.name());
            animal.setImagen(imagen);
            animal.setImagenRedimencionada(imagenRedimencionada);
            actualizar(animal);
        }
    }

    @Override
    public void actualizar(TabAnimal animal)
            throws EntidadNoGrabadaException {
        animalDao.actualizar(animal);
    }

    @Override
    public void eliminar(TabAnimal animal) throws EntidadNoBorradaException, EntidadNoEncontradaException {

        TabAnimal animalBorrar = animalDao.recuperar(animal.getId());
        animalDao.eliminar(animalBorrar);

    }

    @Override
    public void guardarAnimal(TabAnimal animal) throws EntidadNoGrabadaException {
        if (animal.getId() == null) {
            animalDao.crear(animal);
        } else {
            animalDao.actualizar(animal);
        }
        subirImagenes(animal);

    }

}
