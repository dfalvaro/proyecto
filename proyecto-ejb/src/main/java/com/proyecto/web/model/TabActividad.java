package com.proyecto.web.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;



/**
 * The actsistent class for the tab_act database table.
 *
 */
@Entity
@Table(name = "tab_actividad")
public class TabActividad implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "act_id")
    private Long id;

    @Column(name = "act_descripcion", nullable = false)
    private String descripcion;

    @Column(name = "act_estado", nullable = false)
    private String estado;
    
       @Transient
    private DatosAuditoria datosAuditoria;

    @Override
    public String toString() {
        return "TabActividad{" + "id=" + id + ", descripcion=" + descripcion + ", estado=" + estado + '}';
    }

    public TabActividad(DatosAuditoria datosAuditoria) {
        this.datosAuditoria = datosAuditoria;
    }

    public TabActividad() {
    }

    

  

 

    @Transient
    private String descripcioEdicion;

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

    public String getDescripcioEdicion() {
        return descripcioEdicion;
    }

    public void setDescripcioEdicion(String descripcioEdicion) {
        this.descripcioEdicion = descripcioEdicion;
    }

    public DatosAuditoria getDatosAuditoria() {
        return datosAuditoria;
    }

    public void setDatosAuditoria(DatosAuditoria datosAuditoria) {
        this.datosAuditoria = datosAuditoria;
    }



}
