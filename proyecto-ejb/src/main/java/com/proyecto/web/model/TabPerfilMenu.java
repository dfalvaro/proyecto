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
 * The persistent class for the tab_usuario database table.
 *
 */
@Entity
@Table(name = "tab_perfil_menu")
public class TabPerfilMenu implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pme_id")
    private Long id;

    // bi-directional many-to-one association to TabPerfil
    @ManyToOne
    @JoinColumn(name = "perfil", nullable = false)
    private TabPerfil perfil;

    // bi-directional many-to-one association to TabMenu
    @ManyToOne
    @JoinColumn(name = "menu", nullable = false, referencedColumnName = "men_id")
    private TabMenu menu;

    @Column(name = "pme_operaciones_asignadas")
    private String operacionesAsignadas;

    @Transient
    private String[] operacionesSeleccionadas;
    @Transient
    private List<String> listaOperaciones;
    @Transient
    private TabMenu menuPadre;
    @Transient
    private String url;
    @Transient
    private DatosAuditoria datosAuditoria;

    @Override
    public String toString() {
        return "TabPerfilMenu{" + "id=" + id + ", perfil=" + perfil + ", menu=" + menu + ", operacionesAsignadas=" + operacionesAsignadas + '}';
    }

    public TabPerfilMenu(DatosAuditoria datosAuditoria) {
        this.datosAuditoria = datosAuditoria;
    }

    public TabPerfilMenu() {
    }

    public TabPerfilMenu(TabPerfil perfil) {
        this.perfil = perfil;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TabPerfil getPerfil() {
        return perfil;
    }

    public void setPerfil(TabPerfil perfil) {
        this.perfil = perfil;
    }

    public TabMenu getMenu() {
        return menu;
    }

    public void setMenu(TabMenu menu) {
        this.menu = menu;
    }

    public TabMenu getMenuPadre() {
        return menuPadre;
    }

    public void setMenuPadre(TabMenu menuPadre) {
        this.menuPadre = menuPadre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOperacionesAsignadas() {
        return operacionesAsignadas;
    }

    public void setOperacionesAsignadas(String operacionesAsignadas) {
        this.operacionesAsignadas = operacionesAsignadas;
    }

    public String[] getOperacionesSeleccionadas() {
        return operacionesSeleccionadas;
    }

    public void setOperacionesSeleccionadas(String[] operacionesSeleccionadas) {
        this.operacionesSeleccionadas = operacionesSeleccionadas;
    }

    public List<String> getListaOperaciones() {
        return listaOperaciones;
    }

    public void setListaOperaciones(List<String> listaOperaciones) {
        this.listaOperaciones = listaOperaciones;
    }

    public DatosAuditoria getDatosAuditoria() {
        return datosAuditoria;
    }

    public void setDatosAuditoria(DatosAuditoria datosAuditoria) {
        this.datosAuditoria = datosAuditoria;
    }

}
