package com.proyecto.web.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * The persistent class for the tab_auditoria database table.
 *
 */
@Entity
@Table(name = "tab_auditoria")
public class TabAuditoria implements Serializable {

  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aud_id")
    private Long id;

    @Column(name = "aud_usuario")
    private String usuario;

    @Column(name = "aud_valor_anterior", length = 2000)
    private String valorAnterior;

    @Column(name = "aud_campo_afectado", length = 1000)
    private String campoAfectado;

    @Column(name = "aud_operacion")
    private String operacion;

    @Column(name = "aud_valor_actual", length = 2000)
    private String valorActual;

    @Column(name = "aud_funcionalidad")
    private String funcionalidad;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "aud_fecha")
    private Date fecha;
    @Transient
    private Date fechaInicio;

    @Transient
    private Date fechaFin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

   
    public String getValorAnterior() {
        return valorAnterior;
    }

    public void setValorAnterior(String valorAnterior) {
        this.valorAnterior = valorAnterior;
    }

    public String getCampoAfectado() {
        return campoAfectado;
    }

    public void setCampoAfectado(String campoAfectado) {
        this.campoAfectado = campoAfectado;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getValorActual() {
        return valorActual;
    }

    public void setValorActual(String valorActual) {
        this.valorActual = valorActual;
    }

    public String getFuncionalidad() {
        return funcionalidad;
    }

    public void setFuncionalidad(String funcionalidad) {
        this.funcionalidad = funcionalidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

}
