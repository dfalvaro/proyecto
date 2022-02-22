package com.proyecto.web.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * The persistent class for the tab_per database table.
 *
 */
@Entity
@Table(name = "tab_perfil")
public class TabPerfil implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "per_id")
    private Long id;

    @Column(name = "per_descripcion", nullable = false)
    private String descripcion;

    @Column(name = "per_estado", nullable = false)
    private String estado;

    @Column(name = "per_nombre", nullable = false)
    private String nombre;


    @Transient
    private String nombreEdicion;

    @OneToMany(mappedBy = "perfil")
    private List<TabUsuario> listaUsuarios;
     @Transient
    private DatosAuditoria datosAuditoria;

    @Override
    public String toString() {
        return "TabPerfil{" + "id=" + id + ", descripcion=" + descripcion + ", estado=" + estado + ", nombre=" + nombre +'}';
    }

    public TabPerfil(DatosAuditoria datosAuditoria) {
        this.datosAuditoria = datosAuditoria;
    }

    public TabPerfil() {
    }


    
  

    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<TabUsuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<TabUsuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public String getNombreEdicion() {
        return nombreEdicion;
    }

    public DatosAuditoria getDatosAuditoria() {
        return datosAuditoria;
    }

    public void setDatosAuditoria(DatosAuditoria datosAuditoria) {
        this.datosAuditoria = datosAuditoria;
    }

   

    public void setNombreEdicion(String nombreEdicion) {
        this.nombreEdicion = nombreEdicion;
    }


}
