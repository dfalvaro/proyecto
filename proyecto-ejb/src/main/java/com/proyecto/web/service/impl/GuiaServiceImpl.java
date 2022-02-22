package com.proyecto.web.service.impl;


import com.proyecto.web.dao.IGuiaDao;
import com.proyecto.web.enumeration.EstadoRegistroEnum;
import com.proyecto.web.enumeration.TipoIdentificacionEnum;
import com.proyecto.web.exceptions.EntidadNoBorradaException;
import com.proyecto.web.exceptions.EntidadNoEncontradaException;
import com.proyecto.web.exceptions.EntidadNoGrabadaException;
import com.proyecto.web.model.TabGuia;
import com.proyecto.web.model.TabPersona;
import com.proyecto.web.service.IGuiaService;
import com.proyecto.web.service.PersonaService;
import com.proyecto.web.util.Util;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class GuiaServiceImpl
        implements IGuiaService {

    private static final Logger LOG = Logger.getLogger(GuiaServiceImpl.class.getName());

    @EJB
    IGuiaDao guiaDao;
    @EJB
    PersonaService personaService;

    @Override
    public TabGuia obtenerPorId(Long id)
            throws EntidadNoEncontradaException {
        return guiaDao.recuperar(id);
    }

    @Override
    public List<TabGuia> buscar(TabGuia guia) {
        return guiaDao.buscar(guia);
    }

    

    @Override
    public void guardarGuia(TabGuia guia, TabPersona persona) throws EntidadNoGrabadaException, EntidadNoEncontradaException {
        validarGuia(persona);
        personaService.guardarPersonas(persona);
        guia.setPersona(persona);
        if (guia.getId() == null) {
            guia.setEstado(EstadoRegistroEnum.ACTIVO.name());
            guiaDao.crear(guia);
        } else {
            guiaDao.actualizar(guia);
        }

    }

    private void validarGuia(TabPersona persona) throws EntidadNoGrabadaException {
        if (persona.getTipoIdentificacion().equals(TipoIdentificacionEnum.CEDULA)) {
            if (!Util.validarCedula(persona.getIdentificacion())) {
                throw new EntidadNoGrabadaException("Número de cédula incorrecto");
            }

        }

//        if (persona.getTipoIdentificacion().equals(TipoIdentificacionEnum.RUC)) {
//
//            if (!Util.esNumeroDecimal(persona.getIdentificacion())) {
//                throw new EntidadNoGrabadaException("El ruc debe estar conformado solo de números");
//            }
//            if (persona.getIdentificacion().length() != 13) {
//                throw new EntidadNoGrabadaException("El ruc debe poseer 13 dijitos");
//            }
//        }
    }

    @Override
    public void guardar(TabGuia guia) {
        try {
            guiaDao.crear(guia);

        } catch (EntidadNoGrabadaException ex) {
            Logger.getLogger(GuiaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void actualizar(TabGuia guia)
            throws EntidadNoGrabadaException {
        guiaDao.actualizar(guia);
    }

    @Override
    public void eliminar(TabGuia guia) throws EntidadNoBorradaException, EntidadNoEncontradaException {

        TabGuia guiaBorrar = guiaDao.recuperar(guia.getId());
        guiaDao.eliminar(guiaBorrar);

    }

   
}
