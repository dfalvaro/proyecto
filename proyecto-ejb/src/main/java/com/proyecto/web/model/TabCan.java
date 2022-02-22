package com.proyecto.web.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 */
@Entity
@Table(name = "gen_can")
public class TabCan implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "can_id")
    private Long id;

    @Column(name = "can_estado", nullable = false)
    private String estado;

    @Column(name = "can_codigo_interno")
    private String codigoInterno;

    @Column(name = "can_secuencia")
    private Long secuencial;

    @Column(name = "can_codigo_siipne")
    private String codigoSiipne;

    @Column(name = "can_codigo_esbye")
    private String codigoEsbye;

    @Column(name = "can_epecialidad_tipo")
    private Long especialidadTipo;

    @Column(name = "can_epecialidad_subtipo")
    private Long especialidadSubTipo;

    @Column(name = "can_epecialidad_dual")
    private String especialidadDual;

    @Column(name = "can_numero_chips")
    private String numeroChips;

    @Column(name = "can_observacion")
    private String observacion;

    @Column(name = "can_ficha_medica")
    private String fichaMedica;

    @ManyToOne
    @JoinColumn(name = "animal", nullable = false, referencedColumnName = "ani_id")
    private TabAnimal animal;

    // bi-directional many-to-one association
    @ManyToOne
    @JoinColumn(name = "guia", referencedColumnName = "gui_id")
    private TabGuia guia;

    @Transient
    private String correo;
    @Transient
    private String telefono;
    @Transient
    private String celular;

    @Transient
    private String codigoSiipneValidacion;
    @Transient
    private String codigoEsbyeValidacion;
    @Transient
    private String numeroChipsValidacion;

    public TabCan() {
    }

    public TabCan(String numeroChipsValidacion) {
        this.numeroChipsValidacion = numeroChipsValidacion;
    }

    

    public TabCan(String codigoSiipne, String codigoEsbye) {
        this.codigoSiipne = codigoSiipne;
        this.codigoEsbye = codigoEsbye;
    }

    public TabCan(Long especialidadTipo) {
        this.especialidadTipo = especialidadTipo;
    }

    public String getCodigoSiipne() {
        return codigoSiipne;
    }

    public void setCodigoSiipne(String codigoSiipne) {
        this.codigoSiipne = codigoSiipne;
    }

    public String getCodigoEsbye() {
        return codigoEsbye;
    }

    public void setCodigoEsbye(String codigoEsbye) {
        this.codigoEsbye = codigoEsbye;
    }

    public Long getEspecialidadTipo() {
        return especialidadTipo;
    }

    public void setEspecialidadTipo(Long especialidadTipo) {
        this.especialidadTipo = especialidadTipo;
    }

    public Long getEspecialidadSubTipo() {
        return especialidadSubTipo;
    }

    public void setEspecialidadSubTipo(Long especialidadSubTipo) {
        this.especialidadSubTipo = especialidadSubTipo;
    }

    public String getEspecialidadDual() {
        return especialidadDual;
    }

    public void setEspecialidadDual(String especialidadDual) {
        this.especialidadDual = especialidadDual;
    }

    public String getNumeroChips() {
        return numeroChips;
    }

    public void setNumeroChips(String numeroChips) {
        this.numeroChips = numeroChips;
    }

    public TabAnimal getAnimal() {
        return animal;
    }

    public void setAnimal(TabAnimal animal) {
        this.animal = animal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public TabGuia getGuia() {
        return guia;
    }

    public void setGuia(TabGuia guia) {
        this.guia = guia;
    }

    public String getFichaMedica() {
        return fichaMedica;
    }

    public void setFichaMedica(String fichaMedica) {
        this.fichaMedica = fichaMedica;
    }

    public String getCodigoInterno() {
        return codigoInterno;
    }

    public void setCodigoInterno(String codigoInterno) {
        this.codigoInterno = codigoInterno;
    }

    public Long getSecuencial() {
        return secuencial;
    }

    public void setSecuencial(Long secuencial) {
        this.secuencial = secuencial;
    }

    public String getCodigoSiipneValidacion() {
        return codigoSiipneValidacion;
    }

    public void setCodigoSiipneValidacion(String codigoSiipneValidacion) {
        this.codigoSiipneValidacion = codigoSiipneValidacion;
    }

    public String getCodigoEsbyeValidacion() {
        return codigoEsbyeValidacion;
    }

    public void setCodigoEsbyeValidacion(String codigoEsbyeValidacion) {
        this.codigoEsbyeValidacion = codigoEsbyeValidacion;
    }

    public String getNumeroChipsValidacion() {
        return numeroChipsValidacion;
    }

    public void setNumeroChipsValidacion(String numeroChipsValidacion) {
        this.numeroChipsValidacion = numeroChipsValidacion;
    }
    

}
