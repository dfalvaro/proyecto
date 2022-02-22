/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.web.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
 *
 * @author usuario
 */
@Entity
@Table(name = "gen_animal")
public class TabAnimal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ani_id")
    private Long id;
    @Column(name = "ani_nombres")
    private String nombres;
    @Column(name = "ani_estado")
    private String estado;
    @Column(name = "ani_nacionalidad")
    private String nacionalidad;
    @Column(name = "ani_especie")
    private String especie;
    @Column(name = "ani_raza")
    private String raza;
    @Column(name = "ani_sexo")
    private String sexo;
    @Column(name = "ani_estado_reproductivo")
    private String estadoReproductivo;
    @Temporal(TemporalType.DATE)
    @Column(name = "ani_fecha_nacimiento")
    private Date fechaNacimiento;
    @Column(name = "ani_color")
    private String color;
    @Column(name = "ani_pelo")
    private String pelo;
    @Column(name = "ani_caracter")
    private String caracter;
    @Temporal(TemporalType.DATE)
    @Column(name = "ani_fecha_ingreso")
    private Date fechaIngreso;
    @Column(name = "ani_procedencia")
    private String procedencia;
    @Column(name = "per_imagen")
    private String imagen;
    @Column(name = "per_imagen_redimencionada")
    private String imagenRedimencionada;

    @Transient
    private String imagenBase64;
    @Transient
    private String nombreImagen;
    @Transient
    private String direccion;
    @Transient
    private String ciudad;

    public TabAnimal() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

   

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getImagenRedimencionada() {
        return imagenRedimencionada;
    }

    public void setImagenRedimencionada(String imagenRedimencionada) {
        this.imagenRedimencionada = imagenRedimencionada;
    }

    public String getImagenBase64() {
        return imagenBase64;
    }

    public void setImagenBase64(String imagenBase64) {
        this.imagenBase64 = imagenBase64;
    }

    public String getNombreImagen() {
        return nombreImagen;
    }

    public void setNombreImagen(String nombreImagen) {
        this.nombreImagen = nombreImagen;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getEstadoReproductivo() {
        return estadoReproductivo;
    }

    public void setEstadoReproductivo(String estadoReproductivo) {
        this.estadoReproductivo = estadoReproductivo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPelo() {
        return pelo;
    }

    public void setPelo(String pelo) {
        this.pelo = pelo;
    }

    public String getCaracter() {
        return caracter;
    }

    public void setCaracter(String caracter) {
        this.caracter = caracter;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }
    
    

}
