package com.proyecto.web.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * The persistent class for the tab_usuario database table.
 *
 */
@Entity
@Table(name = "tab_usuario")
public class TabUsuario implements Serializable, HttpSessionBindingListener {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usu_id")
    private Long id;

    @Column(name = "usu_clave", nullable = false)
    private String clave;

    @Column(name = "usu_nombre", nullable = false)
    private String nombre;

    @Column(name = "usu_estado", nullable = false)
    private String estado;

    @Column(name = "usu_administrador")
    private Boolean administrador;

    // bi-directional many-to-one association to TabPerfil
    @ManyToOne
    @JoinColumn(name = "perfil", nullable = false, referencedColumnName = "per_id")
    private TabPerfil perfil;

    // bi-directional many-to-one association to TabPersona
    @ManyToOne
    @JoinColumn(name = "persona", referencedColumnName = "per_id")
    private TabPersona persona;

    @ManyToOne
    @JoinColumn(name = "usuario_aprobador", referencedColumnName = "usu_id")
    private TabUsuario usuarioAprobador;

    @Column(name = "usu_generado", nullable = true)
    private Boolean generado;

    @Column(name = "usu_costo_hora")
    private BigDecimal costoHora;

    

    @Transient
    private String edicionNombreUsuario;
    @Transient
    private String validacionIdentificacion;

    @Transient
    private String recuperacionCorreo;
    @Transient
    private String recuperacionIdentificacion;
    @Transient
    private String edicionVerificacion;
    @Transient
    private DatosAuditoria datosAuditoria;
    @Transient
    private final Map<TabUsuario, HttpSession> logins = new ConcurrentHashMap<TabUsuario, HttpSession>();

    @Override
    public boolean equals(Object other) {
        return (other instanceof TabUsuario) && (id != null) ? id.equals(((TabUsuario) other).id) : (other == this);
    }

    @Override
    public int hashCode() {
        return (id != null) ? (this.getClass().hashCode() + id.hashCode()) : super.hashCode();
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.err.println("LOGIN " + event.getSession().getId());
        HttpSession session = logins.remove(this);
        if (session != null) {
            session.invalidate();
        }
        logins.put(this, event.getSession());
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.err.println("Logout " + event.getSession().getId());
        logins.remove(this);
    }

    @Override
    public String toString() {
        return "TabUsuario{" + "id=" + id + ", clave=" + clave + ", nombre=" + nombre + ", estado=" + estado + ", administrador=" + administrador + ", perfil=" + perfil + ", persona=" + persona + ", generado=" + generado + ", costoHora=" + costoHora + '}';
    }

    public TabUsuario(DatosAuditoria datosAuditoria) {
        this.datosAuditoria = datosAuditoria;
    }

    public TabUsuario() {
    }

    public TabUsuario(TabPersona persona) {
        this.persona = persona;
    }

    public TabUsuario(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public TabPerfil getPerfil() {
        return perfil;
    }

    public void setPerfil(TabPerfil perfil) {
        this.perfil = perfil;
    }

    public TabPersona getPersona() {
        return persona;
    }

    public void setPersona(TabPersona persona) {
        this.persona = persona;
    }

    public String getEdicionNombreUsuario() {
        return edicionNombreUsuario;
    }

    public void setEdicionNombreUsuario(String edicionNombreUsuario) {
        this.edicionNombreUsuario = edicionNombreUsuario;
    }

    public String getValidacionIdentificacion() {
        return validacionIdentificacion;
    }

    public void setValidacionIdentificacion(String validacionIdentificacion) {
        this.validacionIdentificacion = validacionIdentificacion;
    }

    public Boolean getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Boolean administrador) {
        this.administrador = administrador;
    }

    public String getEdicionVerificacion() {
        return edicionVerificacion;
    }

    public void setEdicionVerificacion(String edicionVerificacion) {
        this.edicionVerificacion = edicionVerificacion;
    }

    public Boolean getGenerado() {
        return generado;
    }

    public void setGenerado(Boolean generado) {
        this.generado = generado;
    }

    public String getRecuperacionCorreo() {
        return recuperacionCorreo;
    }

    public void setRecuperacionCorreo(String recuperacionCorreo) {
        this.recuperacionCorreo = recuperacionCorreo;
    }

    public String getRecuperacionIdentificacion() {
        return recuperacionIdentificacion;
    }

    public void setRecuperacionIdentificacion(String recuperacionIdentificacion) {
        this.recuperacionIdentificacion = recuperacionIdentificacion;
    }

    public TabUsuario getUsuarioAprobador() {
        return usuarioAprobador;
    }

    public void setUsuarioAprobador(TabUsuario usuarioAprobador) {
        this.usuarioAprobador = usuarioAprobador;
    }

    public BigDecimal getCostoHora() {
        return costoHora;
    }

    public void setCostoHora(BigDecimal costoHora) {
        this.costoHora = costoHora;
    }

    public DatosAuditoria getDatosAuditoria() {
        return datosAuditoria;
    }

    public void setDatosAuditoria(DatosAuditoria datosAuditoria) {
        this.datosAuditoria = datosAuditoria;
    }


}
