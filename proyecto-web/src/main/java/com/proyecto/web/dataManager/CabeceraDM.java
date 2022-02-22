package com.proyecto.web.dataManager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author
 */
@ManagedBean(name = "cabeceraDM")
@SessionScoped
public class CabeceraDM implements Serializable {

    private String username;
    private String password;
    private String videos = "taJ60kskkns";
    private String nombreVideo;

    private String identificacionRecuperacion = null;
    private String correoRecuperacion = null;
    private String claveUsuario = null;
    private String mostarCancelarRestauracionClave = null;
    private Boolean habilitarBotonesSeleccion = Boolean.TRUE;
    private String respLogin = null;

    private byte[] pdfArray;
    private StreamedContent streamPdf;

    public String getClaveUsuario() {
        return claveUsuario;
    }

    public void setClaveUsuario(String claveUsuario) {
        this.claveUsuario = claveUsuario;
    }

    public String getVerificacionClaveUsuario() {
        return verificacionClaveUsuario;
    }

    public void setVerificacionClaveUsuario(String verificacionClaveUsuario) {
        this.verificacionClaveUsuario = verificacionClaveUsuario;
    }
    private String verificacionClaveUsuario = null;

    public String getIdentificacionRecuperacion() {
        return identificacionRecuperacion;
    }

    public void setIdentificacionRecuperacion(String identificacionRecuperacion) {
        this.identificacionRecuperacion = identificacionRecuperacion;
    }

    public String getCorreoRecuperacion() {
        return correoRecuperacion;
    }

    public void setCorreoRecuperacion(String correoRecuperacion) {
        this.correoRecuperacion = correoRecuperacion;
    }

    public String getMostarCancelarRestauracionClave() {
        return mostarCancelarRestauracionClave;
    }

    public Boolean getHabilitarBotonesSeleccion() {
        return habilitarBotonesSeleccion;
    }

    public void setHabilitarBotonesSeleccion(Boolean habilitarBotonesSeleccion) {
        this.habilitarBotonesSeleccion = habilitarBotonesSeleccion;
    }

    public void setMostarCancelarRestauracionClave(String mostarCancelarRestauracionClave) {
        this.mostarCancelarRestauracionClave = mostarCancelarRestauracionClave;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRespLogin() {
        return respLogin;
    }

    public void setRespLogin(String respLogin) {
        this.respLogin = respLogin;
    }

    public String getVideos() {
        return videos;
    }

    public void setVideos(String videos) {
        this.videos = videos;
    }

    public String getNombreVideo() {
        return nombreVideo;
    }

    public void setNombreVideo(String nombreVideo) {
        this.nombreVideo = nombreVideo;
    }

    public byte[] getPdfArray() {
        return pdfArray;
    }

    public void setPdfArray(byte[] pdfArray) {
        this.pdfArray = pdfArray;
    }

    public StreamedContent getStreamPdf() {
        return streamPdf;
    }

    public void setStreamPdf(StreamedContent streamPdf) {
        this.streamPdf = streamPdf;
    }
    
    

}
