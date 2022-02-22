package com.proyecto.web.service.impl;

import com.proyecto.web.dao.UsuarioDao;
import com.proyecto.web.enumeration.NacionalidadEnum;
import com.proyecto.web.exceptions.EntidadNoBorradaException;
import com.proyecto.web.exceptions.EntidadNoEncontradaException;
import com.proyecto.web.exceptions.EntidadNoGrabadaException;
import com.proyecto.web.model.TabPersona;
import com.proyecto.web.model.TabUsuario;
import com.proyecto.web.service.UsuarioService;
import com.proyecto.web.util.Util;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.proyecto.web.dao.PersonaDao;
import com.proyecto.web.enumeration.EstadoRegistroEnum;
import org.springframework.beans.factory.annotation.Autowired;

@Stateless
public class UsuarioServiceImpl
        implements UsuarioService {

    private static final Logger LOG = Logger.getLogger(UsuarioServiceImpl.class.getName());

    @EJB
    @Autowired
    UsuarioDao usuarioDao;
    @EJB
    PersonaDao entidadDao;

    @Override
    public TabUsuario obtenerPorId(Long id)
            throws EntidadNoEncontradaException {
        return usuarioDao.recuperar(id);
    }

    @Override
    public List<TabUsuario> buscar(TabUsuario usuario) {
        return usuarioDao.buscar(usuario);
    }

    @Override
    public List<TabUsuario> obtenerTodos() {
        List<TabUsuario> lista = usuarioDao.obtenerTodos();
        return lista;
    }

    @Override
    public void guardarUsuario(TabUsuario usuario, TabPersona persona, String enlace) throws EntidadNoGrabadaException, Exception {
        validacionesGenerales(usuario, persona);

        if (persona.getId() == null) {
            entidadDao.crear(persona);
        } else {
            entidadDao.actualizar(persona);
        }
        usuario.setPersona(persona);
        if (usuario.getId() == null) {
            String clave = Util.getPassword(5);
            usuario.setClave(Util.SHA256(clave));
            usuario.setGenerado(Boolean.FALSE);
            usuario.setAdministrador(Boolean.FALSE);
            usuarioDao.crear(usuario);
            String asunto = "Datos de usuario";
            String cuerpo = "usuario:" + usuario.getNombre() + "\nClave:" + clave
                    + "\nEnlace:" + enlace;
        } else {
            usuarioDao.actualizar(usuario);
        }

    }

    private void validacionesGenerales(TabUsuario usuario, TabPersona entidad) throws EntidadNoGrabadaException {
        if (usuario.getAdministrador() && usuario.getEstado().equals(EstadoRegistroEnum.INACTIVO.name())) {
            throw new EntidadNoGrabadaException("No puede ser inactivado el usuario administrador");
        }

        if (!usuario.getEdicionNombreUsuario().equals(usuario.getNombre())) {

            TabUsuario buscarUsuario = new TabUsuario();
            buscarUsuario.setNombre(usuario.getNombre());
            List<TabUsuario> usuarioEncontrado = usuarioDao.buscar(buscarUsuario);
            if (!usuarioEncontrado.isEmpty()) {
                throw new EntidadNoGrabadaException("Ya existe un usuario con ese nombre");
            }
        }

        if (!entidad.getEdicionIdentificacion().equals(entidad.getIdentificacion())) {

            TabUsuario buscarUsuarioEntidad = new TabUsuario();
            buscarUsuarioEntidad.setValidacionIdentificacion(entidad.getIdentificacion());
            List<TabUsuario> identificacionEmpleadoEncontrado = usuarioDao.buscar(buscarUsuarioEntidad);
            if (!identificacionEmpleadoEncontrado.isEmpty()) {
                throw new EntidadNoGrabadaException("Ya existe un usuario con el numero de cédula ingresado");
            }

        }
        if (entidad.getNacionalidad().equals(NacionalidadEnum.NACIONAL.getTipo())) {
            if (!Util.validarCedula(entidad.getIdentificacion())) {
                throw new EntidadNoGrabadaException("Número de identificación incorrecto");
            }
        }

    }

    @Override
    public void guardar(TabUsuario usuario) {
        try {
            usuarioDao.crear(usuario);
        } catch (EntidadNoGrabadaException ex) {
            Logger.getLogger(UsuarioServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void actualizar(TabUsuario usuario)
            throws EntidadNoGrabadaException {
        usuarioDao.actualizar(usuario);
    }

    @Override
    public void eliminar(TabUsuario usuario) throws EntidadNoBorradaException, EntidadNoEncontradaException {
        if (usuario.getAdministrador()) {
            throw new EntidadNoBorradaException("El usuario administrador no puede ser eliminado");
        }
        TabUsuario usuarioBorrar = (TabUsuario) usuarioDao.recuperar(usuario.getId());
        usuarioDao.eliminar(usuarioBorrar);

    }
}
