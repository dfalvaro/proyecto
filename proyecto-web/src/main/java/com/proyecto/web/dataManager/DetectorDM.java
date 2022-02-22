package com.proyecto.web.dataManager;

import com.proyecto.web.model.TabCan;
import com.proyecto.web.model.TabEspecialidadSubtipo;
import com.proyecto.web.model.TabGuia;
import com.proyecto.web.model.TecnicaDetectores;
import com.proyecto.web.model.TecnicaExamen;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "detectorDM")
@ViewScoped
public class DetectorDM implements Serializable {

    private TecnicaExamen examen = new TecnicaExamen();
    private List<TecnicaDetectores> listaAreas = new ArrayList<>();
    private List<TabCan> listaCanes = new ArrayList<>();
    private List<TabEspecialidadSubtipo> listaEspecialidadSubtipo = new ArrayList<>();
    private List<TabGuia> listaGuias = new ArrayList<>();
    private TabCan canSeleccionado = new TabCan();
    private Long idCan;
    private Long idGuia;

    //Paneles 
    private Boolean showPanelTablaDetector = Boolean.FALSE;
    private Boolean showPanelCrudDetector = Boolean.FALSE;

    public DetectorDM() {
    }

    //Getters and Setters
    public TecnicaExamen getExamen() {
        return examen;
    }

    public void setExamen(TecnicaExamen examen) {
        this.examen = examen;
    }

    public List<TecnicaDetectores> getListaAreas() {
        return listaAreas;
    }

    public void setListaAreas(List<TecnicaDetectores> listaAreas) {
        this.listaAreas = listaAreas;
    }

    public Boolean getShowPanelTablaDetector() {
        return showPanelTablaDetector;
    }

    public void setShowPanelTablaDetector(Boolean showPanelTablaDetector) {
        this.showPanelTablaDetector = showPanelTablaDetector;
    }

    public Boolean getShowPanelCrudDetector() {
        return showPanelCrudDetector;
    }

    public void setShowPanelCrudDetector(Boolean showPanelCrudDetector) {
        this.showPanelCrudDetector = showPanelCrudDetector;
    }

    public List<TabCan> getListaCanes() {
        return listaCanes;
    }

    public void setListaCanes(List<TabCan> listaCanes) {
        this.listaCanes = listaCanes;
    }

    public List<TabEspecialidadSubtipo> getListaEspecialidadSubtipo() {
        return listaEspecialidadSubtipo;
    }

    public void setListaEspecialidadSubtipo(List<TabEspecialidadSubtipo> listaEspecialidadSubtipo) {
        this.listaEspecialidadSubtipo = listaEspecialidadSubtipo;
    }

    public List<TabGuia> getListaGuias() {
        return listaGuias;
    }

    public void setListaGuias(List<TabGuia> listaGuias) {
        this.listaGuias = listaGuias;
    }

    public Long getIdCan() {
        return idCan;
    }

    public void setIdCan(Long idCan) {
        this.idCan = idCan;
    }

    public Long getIdGuia() {
        return idGuia;
    }

    public void setIdGuia(Long idGuia) {
        this.idGuia = idGuia;
    }

    public TabCan getCanSeleccionado() {
        return canSeleccionado;
    }

    public void setCanSeleccionado(TabCan canSeleccionado) {
        this.canSeleccionado = canSeleccionado;
    }

    
    
}
