package com.proyecto.web.controller;

import com.proyecto.web.service.UsuarioService;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import com.proyecto.web.exceptions.EntidadNoBorradaException;
import com.proyecto.web.exceptions.EntidadNoEncontradaException;
import com.proyecto.web.model.TabPerfil;
import com.proyecto.web.model.TabUsuario;
import com.proyecto.web.service.PerfilService;
import com.proyecto.web.util.Util;
import com.proyecto.web.dataManager.UsuarioDM;
import com.proyecto.web.enumeration.EstadoRegistroEnum;
import com.proyecto.web.enumeration.GeneroEnum;
import com.proyecto.web.enumeration.NacionalidadEnum;
import com.proyecto.web.enumeration.PaisesEnum;
import com.proyecto.web.exceptions.EntidadNoGrabadaException;
import com.proyecto.web.model.TabPersona;
import java.util.List;
import com.proyecto.web.service.PersonaService;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 *
 * @author @revision $Revision: $
 */
@ManagedBean(name = "usuarioController")
@ViewScoped
public class UsuarioController extends BaseController {

    /**
     *
     */
    @ManagedProperty(value = "#{usuarioDM}")
    public UsuarioDM usuarioDM;
    
    @EJB
    UsuarioService usuarioService;
    @EJB
    PerfilService rolService;
    
    @EJB
    PersonaService personaService;
   

    /**
     *
     */
    public void initForm() {
        usuarioDM.setListaUsuarios(usuarioService.buscar(new TabUsuario()));
        selectItemsDM.setListaUsuarios(usuarioService.buscar(new TabUsuario()));
        usuarioDM.setListaPaises(PaisesEnum.values());
        selectItemsDM.setListaPerfiles(rolService.buscar(new TabPerfil(accesoMenuDM.getDatosAuditoria())));
        usuarioDM.setShowPanelCrudUsuario(Boolean.FALSE);
        usuarioDM.setShowPanelTablaUsuario(Boolean.TRUE);
    }

    
   
    /**
     *
     */
    public void nuevo() {
        usuarioDM.setShowPanelCrudUsuario(Boolean.TRUE);
        usuarioDM.setShowPanelTablaUsuario(Boolean.FALSE);
        usuarioDM.setClaveObligatoria(Boolean.TRUE);
        usuarioDM.setUsuario(new TabUsuario());
        usuarioDM.getUsuario().setEdicionVerificacion("");
        usuarioDM.setIdPerfil(null);
        usuarioDM.getUsuario().setAdministrador(Boolean.FALSE);
        usuarioDM.getUsuario().setEdicionNombreUsuario("");
        usuarioDM.getUsuario().setEstado(EstadoRegistroEnum.ACTIVO.getTipo());
        usuarioDM.setEntidad(new TabPersona(accesoMenuDM.getDatosAuditoria()));
        usuarioDM.setIdUsuarioAprobador(null);
        usuarioDM.getEntidad().setNacionalidad(NacionalidadEnum.NACIONAL.getTipo());
        usuarioDM.getEntidad().setGenero(GeneroEnum.MASCULINO.getTipo());
        usuarioDM.getEntidad().setEdicionCorreo("");
        usuarioDM.getEntidad().setEdicionIdentificacion("");
        
    }
    
    public void eliminar() {
        try {
            usuarioService.eliminar(usuarioDM.getUsuario());
            addInfoMessage("Registro eliminado exitosamente");
            initForm();
        } catch (EntidadNoBorradaException | EntidadNoEncontradaException ex) {
            addErrorMessage(ex.getMessage());
        }
        
    }
    
    public void reenvioCorreo(TabUsuario usuario) {
        String urlEnlace = getServletRequest().getScheme() + "://" + getServletRequest().getServerName() + ":" + getServletRequest().getServerPort() + getServletRequest().getContextPath()
                + "/pages/secure/home.jsf";
        
        try {
            String asunto = "Datos de usuario";
            String clave = Util.getPassword(5);
            usuario.setClave(Util.SHA256(clave));
            usuarioService.actualizar(usuario);
            String cuerpo = "usuario: " + usuario.getNombre() + "\nClave:" + clave + "\nEnlace:" + urlEnlace;
            addInfoMessage("Correo enviado correctamente");
        } catch (EntidadNoGrabadaException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

    /**
     * metodo que permite guardar el usuario
     */
    public void guardarUsuario() {
        try {
              String urlEnlace = getServletRequest().getScheme() + "://" + getServletRequest().getServerName() + ":" + getServletRequest().getServerPort() + getServletRequest().getContextPath()
                + "/pages/secure/home.jsf";
            usuarioDM.getUsuario().setPerfil(rolService.obtenerPorId(usuarioDM.getIdPerfil()));
            usuarioDM.getUsuario().setUsuarioAprobador(usuarioService.obtenerPorId(usuarioDM.getIdUsuarioAprobador()));
            usuarioService.guardarUsuario(usuarioDM.getUsuario(), usuarioDM.getEntidad(),urlEnlace);
            addInfoMessage("Registro guardado correctamente ");
            
            initForm();
            
        } catch (EntidadNoEncontradaException ex) {
            addErrorMessage(ex.getMessage());
        } catch (Exception ex) {
            addErrorMessage(ex.getMessage());
        }
    }

    /**
     *
     */
    public void cancelar() {
        initForm();
    }
    
    public void seleccionarPerfil() {
        
        try {
            TabPerfil perfil = rolService.obtenerPorId(usuarioDM.getIdPerfil());
            if (perfil.getEstado().equals(EstadoRegistroEnum.INACTIVO.getTipo())) {
                addWarnMessage("Perfil seleccionado inactivo");
                usuarioDM.setIdPerfil(null);
            }
        } catch (EntidadNoEncontradaException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void validarRecuperarDatosIdentificacion() {
        if (usuarioDM.getEntidad().getNacionalidad().equals(NacionalidadEnum.NACIONAL.getTipo())) {
            if (!Util.validarCedula(usuarioDM.getEntidad().getIdentificacion())) {
                addErrorMessage("Número de identificación incorrecto");
            }
        }
        
        if (!usuarioDM.getEntidad().getEdicionIdentificacion().equals(usuarioDM.getEntidad().getIdentificacion())) {
            
            TabUsuario buscarUsuarioEntidad = new TabUsuario();
            buscarUsuarioEntidad.setValidacionIdentificacion(usuarioDM.getEntidad().getIdentificacion());
            List<TabUsuario> identificacionEmpleadoEncontrado = usuarioService.buscar(buscarUsuarioEntidad);
            if (!identificacionEmpleadoEncontrado.isEmpty()) {
                addErrorMessage("Ya existe un usuario con el numero de cédula ingresado");
            } else {
                TabPersona buscarEntidad = new TabPersona(accesoMenuDM.getDatosAuditoria());
                buscarEntidad.setIdentificacion(usuarioDM.getEntidad().getIdentificacion());
                List<TabPersona> entidadEncontrada = personaService.buscar(buscarEntidad);
                if (!entidadEncontrada.isEmpty()) {
                    usuarioDM.setEntidad(entidadEncontrada.get(0));
                    usuarioDM.getEntidad().setEdicionCorreo("");
                    usuarioDM.getEntidad().setEdicionIdentificacion("");
                    
                    addInfoMessage("Datos encontrados");
                    
                }
            }
            
        }
    }
    
    public void seleccionarEdicion(TabUsuario usuario) {
        seleccionarUsuario(usuario);
        usuarioDM.setClaveObligatoria(Boolean.FALSE);
        usuarioDM.setShowPanelCrudUsuario(Boolean.TRUE);
        usuarioDM.setShowPanelTablaUsuario(Boolean.FALSE);
    }
    
    public void seleccionarUsuario(TabUsuario usuario) {
        usuario.setDatosAuditoria(accesoMenuDM.getDatosAuditoria());
        usuarioDM.setIdPerfil(usuario.getPerfil().getId());
        usuarioDM.setIdUsuarioAprobador(usuario.getUsuarioAprobador().getId());
        usuarioDM.setUsuario(usuario);
        usuarioDM.getUsuario().setEdicionNombreUsuario(usuarioDM.getUsuario().getNombre());
        usuario.getPersona().setDatosAuditoria(accesoMenuDM.getDatosAuditoria());
        usuarioDM.setEntidad(usuario.getPersona());
        usuarioDM.getEntidad().setEdicionCorreo(usuario.getPersona().getCorreo());
        usuarioDM.getEntidad().setEdicionIdentificacion(usuario.getPersona().getIdentificacion());
    }

    /**
     *
     * @return
     */
    public UsuarioDM getUsuarioDM() {
        return usuarioDM;
    }
    
    public void setUsuarioDM(UsuarioDM usuarioDM) {
        this.usuarioDM = usuarioDM;
    }
    
}
