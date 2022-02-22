package com.proyecto.web.dataManager;

import com.proyecto.web.model.FichaConstanteFisiologica;
import com.proyecto.web.model.FichaConsulta;
import com.proyecto.web.model.FichaDesparacitacionExterna;
import com.proyecto.web.model.FichaDesparacitacionInterna;
import com.proyecto.web.model.FichaDiagnostico;
import com.proyecto.web.model.FichaEvacuaciones;
import com.proyecto.web.model.FichaFisicaVisual;
import com.proyecto.web.model.FichaMedicacionPrescrita;
import com.proyecto.web.model.FichaVacunacion;
import com.proyecto.web.model.TabCan;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "historiaDM")
@ViewScoped
public class HistoriaDM implements Serializable {
    
    private FichaConsulta consulta = new FichaConsulta();
    private FichaConstanteFisiologica constanteFisiologica = new FichaConstanteFisiologica();
    private FichaFisicaVisual fisicaVisual = new FichaFisicaVisual();
    private FichaEvacuaciones evacuaciones = new FichaEvacuaciones();
    private FichaDiagnostico diagnostico = new FichaDiagnostico();
    private FichaMedicacionPrescrita medicacionPrescrita = new FichaMedicacionPrescrita();
    private FichaVacunacion vacunacion = new FichaVacunacion();
    private FichaDesparacitacionInterna desparacitacionInterna = new FichaDesparacitacionInterna();
    private FichaDesparacitacionExterna desparacitacionExterna = new FichaDesparacitacionExterna();
    
    //
    private TabCan canSeleccionado = new TabCan();
    private List<TabCan> listaCanes = new ArrayList<>();
    private Long idCan;
    
    //Paneles 
    private Boolean showPanelTablaHistoria = Boolean.FALSE;
    private Boolean showPanelCrudHistoria = Boolean.FALSE;

    public HistoriaDM() {
    }

    //Getters and Setters

    public Boolean getShowPanelTablaHistoria() {
        return showPanelTablaHistoria;
    }

    public void setShowPanelTablaHistoria(Boolean showPanelTablaHistoria) {
        this.showPanelTablaHistoria = showPanelTablaHistoria;
    }

    public Boolean getShowPanelCrudHistoria() {
        return showPanelCrudHistoria;
    }

    public void setShowPanelCrudHistoria(Boolean showPanelCrudHistoria) {
        this.showPanelCrudHistoria = showPanelCrudHistoria;
    }

    public FichaConsulta getConsulta() {
        return consulta;
    }

    public void setConsulta(FichaConsulta consulta) {
        this.consulta = consulta;
    }

    public FichaConstanteFisiologica getConstanteFisiologica() {
        return constanteFisiologica;
    }

    public void setConstanteFisiologica(FichaConstanteFisiologica constanteFisiologica) {
        this.constanteFisiologica = constanteFisiologica;
    }

    public FichaFisicaVisual getFisicaVisual() {
        return fisicaVisual;
    }

    public void setFisicaVisual(FichaFisicaVisual fisicaVisual) {
        this.fisicaVisual = fisicaVisual;
    }

    public FichaEvacuaciones getEvacuaciones() {
        return evacuaciones;
    }

    public void setEvacuaciones(FichaEvacuaciones evacuaciones) {
        this.evacuaciones = evacuaciones;
    }

    public FichaDiagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(FichaDiagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }

    public FichaMedicacionPrescrita getMedicacionPrescrita() {
        return medicacionPrescrita;
    }

    public void setMedicacionPrescrita(FichaMedicacionPrescrita medicacionPrescrita) {
        this.medicacionPrescrita = medicacionPrescrita;
    }

    public FichaVacunacion getVacunacion() {
        return vacunacion;
    }

    public void setVacunacion(FichaVacunacion vacunacion) {
        this.vacunacion = vacunacion;
    }

    public FichaDesparacitacionInterna getDesparacitacionInterna() {
        return desparacitacionInterna;
    }

    public void setDesparacitacionInterna(FichaDesparacitacionInterna desparacitacionInterna) {
        this.desparacitacionInterna = desparacitacionInterna;
    }

    public FichaDesparacitacionExterna getDesparacitacionExterna() {
        return desparacitacionExterna;
    }

    public void setDesparacitacionExterna(FichaDesparacitacionExterna desparacitacionExterna) {
        this.desparacitacionExterna = desparacitacionExterna;
    }

    public List<TabCan> getListaCanes() {
        return listaCanes;
    }

    public void setListaCanes(List<TabCan> listaCanes) {
        this.listaCanes = listaCanes;
    }

    public Long getIdCan() {
        return idCan;
    }

    public void setIdCan(Long idCan) {
        this.idCan = idCan;
    }

    public TabCan getCanSeleccionado() {
        return canSeleccionado;
    }

    public void setCanSeleccionado(TabCan canSeleccionado) {
        this.canSeleccionado = canSeleccionado;
    }
   

}
