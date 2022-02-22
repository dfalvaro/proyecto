package com.proyecto.web.model;

import java.io.Serializable;
import java.util.List;
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
 * The persistent class for the tabMenu database table.
 *
 */
@Entity
@Table(name = "tab_Menu")
public class TabMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "men_id")
    private Long id;

    @Column(name = "men_url")
    private String url;

    @Column(name = "men_nombre", nullable = false)
    private String nombre;

    @Column(name = "men_orden")
    private Integer orden;
    @Column(name = "men_operaciones")
    private String operaciones;
    @ManyToOne
    @JoinColumn(name = "men_padre")
    private TabMenu padre;
    @Transient
    private List<TabMenu> menuHijos;
     @Transient
    private DatosAuditoria datosAuditoria;
    @Override
    public String toString() {
        return "Menu{" + "Id=" + id + ", Url=" + url + ", Nombre=" + nombre + '}';
    }

    public TabMenu() {
    }
    

    public TabMenu(Long id) {
        this.id = id;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOperaciones() {
        return operaciones;
    }

    public void setOperaciones(String operaciones) {
        this.operaciones = operaciones;
    }

    public TabMenu getPadre() {
        return padre;
    }

    public void setPadre(TabMenu padre) {
        this.padre = padre;
    }

    public List<TabMenu> getMenuHijos() {
        return menuHijos;
    }

    public void setMenuHijos(List<TabMenu> menuHijos) {
        this.menuHijos = menuHijos;
    }

    public Integer getOrden() {
        return orden;
    }

    public DatosAuditoria getDatosAuditoria() {
        return datosAuditoria;
    }

    public void setDatosAuditoria(DatosAuditoria datosAuditoria) {
        this.datosAuditoria = datosAuditoria;
    }

  

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

}
