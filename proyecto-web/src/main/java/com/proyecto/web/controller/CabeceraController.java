package com.proyecto.web.controller;

import com.proyecto.web.enumeration.EstadoActividadEnum;
import com.proyecto.web.exceptions.EntidadNoGrabadaException;
import com.proyecto.web.model.TabActividadUsuario;
import com.proyecto.web.model.TabUsuario;
import com.proyecto.web.service.UsuarioService;
import com.proyecto.web.util.Util;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.PrimeFaces;

/**
 * Clase ...
 *
 * @author
 * @revision $Revision: $
 */
@ManagedBean(name = "cabeceraController")
@ViewScoped
public class CabeceraController extends BaseController {

    @EJB
    UsuarioService servicioUsuario;

    public void redireccionLogin() {
        try {
            HttpServletRequest request = (HttpServletRequest) FacesContext
                    .getCurrentInstance()
                    .getExternalContext()
                    .getRequest();
            Util.redirectLogin(request);
        } catch (IOException ex) {
            Logger.getLogger(CabeceraController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void intiForm() {
        if (cabeceraDM.getRespLogin() != null) {
            addErrorMessage("Login incorrecto, acceso denegado");
            cabeceraDM.setRespLogin(null);
        }
    }

    public void mostarNotificacion() {
        PrimeFaces.current().executeScript("PF('bar').hide();");
        TabActividadUsuario buscarPendientes = new TabActividadUsuario(accesoMenuDM.getDatosAuditoria());
        buscarPendientes.setAprobador(accesoMenuDM.getUsuario());
        buscarPendientes.setEstado(EstadoActividadEnum.REGISTRADO);

    }

    public void ejecutarScript() {
        PrimeFaces.current().executeScript("onYouTubeIframeAPIReady('" + cabeceraDM.getVideos() + "');");
    }

    public void video2() {
        cabeceraDM.setVideos("taJ60kskkns,Lw3kf4uDZYQ");
        PrimeFaces.current().executeScript("onYouTubeIframeAPIReady('" + cabeceraDM.getVideos() + "');");

    }

    public void video3() {
        cabeceraDM.setVideos("taJ60kskkns,Lw3kf4uDZYQ,FG0fTKAqZ5g,p7u5_eOmyX4");
        PrimeFaces.current().executeScript("onYouTubeIframeAPIReady('" + cabeceraDM.getVideos() + "');");

    }

    public void actualizarClaveUsuario() {
        try {
            if (!cabeceraDM.getClaveUsuario().equals(cabeceraDM.getVerificacionClaveUsuario())) {
                addErrorMessage("La datos de verificacion son incorrectos");
                return;
            }
            accesoMenuDM.getUsuario().setClave(Util.SHA256(cabeceraDM.getClaveUsuario()));
            accesoMenuDM.getUsuario().setGenerado(Boolean.FALSE);
            servicioUsuario.actualizar(accesoMenuDM.getUsuario());
            salir();
        } catch (Exception ex) {
            Logger.getLogger(CabeceraController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void mostrarDialogActualizacion() {
        accesoMenuDM.getUsuario().setGenerado(Boolean.TRUE);
    }

    public void recuperarDatosUsuario() {
        try {
            TabUsuario usuario = new TabUsuario();
            usuario.setNombre(cabeceraDM.getCorreoRecuperacion());
            List<TabUsuario> usuarioEncontrado = servicioUsuario.buscar(usuario);
            if (!usuarioEncontrado.isEmpty()) {
                String clave = Util.getPassword(5);
                usuarioEncontrado.get(0).setClave(Util.SHA256(clave));
                usuarioEncontrado.get(0).setGenerado(Boolean.TRUE);
                servicioUsuario.actualizar(usuarioEncontrado.get(0));
                Util.EnvioCorreo(cabeceraDM.getCorreoRecuperacion(), "Recuperación de correo", "Usuario:" + usuarioEncontrado.get(0).getNombre() + "\nClave: " + clave);
                addInfoMessage("Los datos del usuario fueron enviados al correo registrado");
            } else {

                addErrorMessage("Datos de usuario no encontrado");
            }
        } catch (Exception ex) {
            Logger.getLogger(CabeceraController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deshabilitarBotonesSeleccion() {
        cabeceraDM.setHabilitarBotonesSeleccion(Boolean.TRUE);
    }

    public Boolean validarModulos(String modulo) {
        return accesoMenuDM.getListaModulos().contains(modulo);
    }

    public Boolean validarFuncionalidad(String funcionalidadPadre) {
        return accesoMenuDM.getListaMenus().contains(funcionalidadPadre);
    }

    public String obtenerUrl(String urlDestino) throws IOException, EntidadNoGrabadaException {
        String urlFinal = urlBase()
                + urlDestino;
        return urlFinal;

    }

    public String urlBase() {
        String serverName = accesoMenuDM.getRequest().getServerName();
        String contexto = accesoMenuDM.getRequest().getContextPath();
        String scheme = accesoMenuDM.getRequest().getHeader("X-Forwarded-Proto");
        if (scheme == null) {
            scheme = accesoMenuDM.getRequest().getScheme();
            int serverPort = accesoMenuDM.getRequest().getServerPort();
            return scheme + "://" + serverName + ":" + serverPort
                    + contexto;
        }
        return scheme + "://" + serverName + contexto;
    }

    /**
     * @param operacion
     * @return
     */
    public Boolean habilitarOperaciones(String operacion) {
        return accesoMenuDM.getOperacionesAsignadas().contains(operacion);
    }

    /**
     *
     * @throws IOException
     */
    public void salir() throws IOException {
        accesoMenuDM.getSesion().invalidate();
        Util.redirectLogin(accesoMenuDM.getRequest());
    }

}
