package com.proyecto.web.dataManager;

import com.proyecto.web.enumeration.EstadoRegistroAnimalEnum;
import com.proyecto.web.enumeration.EstadoReproductivoAnimalEnum;
import com.proyecto.web.enumeration.TipoSexoAnimalEnum;
import com.proyecto.web.model.TabAnimal;
import com.proyecto.web.model.TabCan;
import com.proyecto.web.model.TabEspecialidad;
import com.proyecto.web.model.TabEspecialidadSubtipo;
import com.proyecto.web.model.TabGuia;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "canDM")
@ViewScoped
public class CanDM implements Serializable {

    private TabAnimal animal = new TabAnimal();
    private TabCan can = new TabCan();
    private List<TabCan> listaCanes = new ArrayList<>();
    private TabEspecialidad especialidadSeleccionado = new TabEspecialidad();
    private List<TabEspecialidad> listaEspecialidad = new ArrayList<>();
    private List<TabEspecialidadSubtipo> listaEspecialidadSubtipo = new ArrayList<>();
    private TipoSexoAnimalEnum[] listaSexoAnimal;
    private EstadoRegistroAnimalEnum[] listaEstadoAnimal;
    private EstadoReproductivoAnimalEnum[] listaEstadoRepoductivoAnimal;
    private List<TabGuia> listaGuias = new ArrayList<>();
    private Long idGuia;
    //Paneles 
    private Boolean showPanelTablaCan = Boolean.FALSE;
    private Boolean showPanelCrudCan = Boolean.FALSE;

    private Boolean dialogPDF = false;

    public CanDM() {
    }

    //Getters and Setters
    public TabAnimal getAnimal() {
        return animal;
    }

    public void setAnimal(TabAnimal animal) {
        this.animal = animal;
    }

    public TabCan getCan() {
        return can;
    }

    public void setCan(TabCan can) {
        this.can = can;
    }

    public Boolean getShowPanelTablaCan() {
        return showPanelTablaCan;
    }

    public void setShowPanelTablaCan(Boolean showPanelTablaCan) {
        this.showPanelTablaCan = showPanelTablaCan;
    }

    public Boolean getShowPanelCrudCan() {
        return showPanelCrudCan;
    }

    public void setShowPanelCrudCan(Boolean showPanelCrudCan) {
        this.showPanelCrudCan = showPanelCrudCan;
    }

    public List<TabCan> getListaCanes() {
        return listaCanes;
    }

    public void setListaCanes(List<TabCan> listaCanes) {
        this.listaCanes = listaCanes;
    }

    public List<TabEspecialidad> getListaEspecialidad() {
        return listaEspecialidad;
    }

    public void setListaEspecialidad(List<TabEspecialidad> listaEspecialidad) {
        this.listaEspecialidad = listaEspecialidad;
    }

    public List<TabEspecialidadSubtipo> getListaEspecialidadSubtipo() {
        return listaEspecialidadSubtipo;
    }

    public void setListaEspecialidadSubtipo(List<TabEspecialidadSubtipo> listaEspecialidadSubtipo) {
        this.listaEspecialidadSubtipo = listaEspecialidadSubtipo;
    }

    public TipoSexoAnimalEnum[] getListaSexoAnimal() {
        return listaSexoAnimal;
    }

    public void setListaSexoAnimal(TipoSexoAnimalEnum[] listaSexoAnimal) {
        this.listaSexoAnimal = listaSexoAnimal;
    }

    public EstadoRegistroAnimalEnum[] getListaEstadoAnimal() {
        return listaEstadoAnimal;
    }

    public void setListaEstadoAnimal(EstadoRegistroAnimalEnum[] listaEstadoAnimal) {
        this.listaEstadoAnimal = listaEstadoAnimal;
    }

    public EstadoReproductivoAnimalEnum[] getListaEstadoRepoductivoAnimal() {
        return listaEstadoRepoductivoAnimal;
    }

    public void setListaEstadoRepoductivoAnimal(EstadoReproductivoAnimalEnum[] listaEstadoRepoductivoAnimal) {
        this.listaEstadoRepoductivoAnimal = listaEstadoRepoductivoAnimal;
    }

    public TabEspecialidad getEspecialidadSeleccionado() {
        return especialidadSeleccionado;
    }

    public void setEspecialidadSeleccionado(TabEspecialidad especialidadSeleccionado) {
        this.especialidadSeleccionado = especialidadSeleccionado;
    }

    public List<TabGuia> getListaGuias() {
        return listaGuias;
    }

    public void setListaGuias(List<TabGuia> listaGuias) {
        this.listaGuias = listaGuias;
    }

    public Long getIdGuia() {
        return idGuia;
    }

    public void setIdGuia(Long idGuia) {
        this.idGuia = idGuia;
    }

    public Boolean getDialogPDF() {
        return dialogPDF;
    }

    public void setDialogPDF(Boolean dialogPDF) {
        this.dialogPDF = dialogPDF;
    }
    
    

}
