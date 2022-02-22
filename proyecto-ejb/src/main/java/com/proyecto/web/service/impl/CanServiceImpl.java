package com.proyecto.web.service.impl;

import com.proyecto.web.dao.ICanDao;
import com.proyecto.web.enumeration.EstadoRegistroEnum;
import com.proyecto.web.exceptions.EntidadNoBorradaException;
import com.proyecto.web.exceptions.EntidadNoEncontradaException;
import com.proyecto.web.exceptions.EntidadNoGrabadaException;
import com.proyecto.web.model.TabAnimal;
import com.proyecto.web.model.TabCan;
import com.proyecto.web.service.IAnimalService;
import com.proyecto.web.service.ICanService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class CanServiceImpl
        implements ICanService {

    private static final Logger LOG = Logger.getLogger(CanServiceImpl.class.getName());

    @EJB
    ICanDao canDao;
    @EJB
    IAnimalService animalService;

    @Override
    public TabCan obtenerPorId(Long id)
            throws EntidadNoEncontradaException {
        return canDao.recuperar(id);
    }

    @Override
    public List<TabCan> buscar(TabCan can) {
        return canDao.buscar(can);
    }

    @Override
    public void guardarCan(TabCan can, TabAnimal animal) throws EntidadNoGrabadaException, EntidadNoEncontradaException {
        System.err.println("111111111111");
//        validarCan(can);
        System.err.println("222222222222");

        animalService.guardarAnimal(animal);
        can.setAnimal(animal);
        if (can.getId() == null) {
            can.setEstado(EstadoRegistroEnum.ACTIVO.name());
            canDao.crear(can);
        } else {
            canDao.actualizar(can);
        }

    }

    private void validarCan(TabCan can) throws EntidadNoGrabadaException {
        if (can.getCodigoSiipne().length() < 18) {
            throw new EntidadNoGrabadaException("El Código Siipne II debe tener 18 digitos");
        }
        if (!can.getCodigoSiipne().equals(can.getCodigoSiipneValidacion())) {
            List<TabCan> codigoEncontrado = canDao.buscar(new TabCan(can.getCodigoSiipne(), null));
            if (!codigoEncontrado.isEmpty()) {
                throw new EntidadNoGrabadaException("El Código Siipne II a ingresar ya existe");
            }
        }
        if (can.getCodigoEsbye() != null) {
            if (can.getCodigoEsbye().length() < 7) {
                throw new EntidadNoGrabadaException("El Código Esbye deber tener 7 digitos");
            }

            if (!can.getCodigoEsbye().equals(can.getCodigoEsbye())) {
                List<TabCan> codigoEncontrado = canDao.buscar(new TabCan(null, can.getCodigoEsbye()));
                if (!codigoEncontrado.isEmpty()) {
                    throw new EntidadNoGrabadaException("El Código Esbye a ingresar ya existe");
                }
            }
        }
        if (!can.getNumeroChips().equals(can.getNumeroChipsValidacion())) {
            List<TabCan> codigoEncontrado = canDao.buscar(new TabCan(can.getNumeroChips()));
            if (!codigoEncontrado.isEmpty()) {
                throw new EntidadNoGrabadaException("El número de chip a ingresar ya existe");
            }
        }

    }

    @Override
    public void guardar(TabCan can) {
        try {
            canDao.crear(can);

        } catch (EntidadNoGrabadaException ex) {
            Logger.getLogger(CanServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void actualizar(TabCan can)
            throws EntidadNoGrabadaException {
        canDao.actualizar(can);
    }

    @Override
    public void eliminar(TabCan can) throws EntidadNoBorradaException, EntidadNoEncontradaException {

        TabCan canBorrar = canDao.recuperar(can.getId());
        canDao.eliminar(canBorrar);

    }

    @Override
    public Long obtenerSecuencialFinal() {
        return canDao.obtenerSecuencialFinal();

    }

}
