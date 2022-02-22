package com.proyecto.web.controller;

import com.proyecto.web.dataManager.GuiaDM;
import com.proyecto.web.dataManager.HistoriaDM;
import com.proyecto.web.exceptions.EntidadNoEncontradaException;
import com.proyecto.web.exceptions.EntidadNoGrabadaException;
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
import com.proyecto.web.model.TabGuia;
import com.proyecto.web.model.TabPersona;
import com.proyecto.web.service.ICanService;
import com.proyecto.web.service.IFichaConsultaService;
import com.proyecto.web.service.IGuiaService;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "historiaController")
@ViewScoped
public class HistoriaController
        extends BaseController {

    @ManagedProperty("#{historiaDM}")
    HistoriaDM historiaDM;

    @EJB
    ICanService canService;
    @EJB
    IFichaConsultaService consultaService;

    public void initForm() {
        buscarCanes();
        nuevaConsulta();
        historiaDM.setShowPanelCrudHistoria(Boolean.FALSE);
        historiaDM.setShowPanelTablaHistoria(Boolean.TRUE);

    }

    public void buscarCanes() {
        historiaDM.setListaCanes(canService.buscar(new TabCan()));
    }

    public void nuevaConsulta() {
        historiaDM.setConsulta(new FichaConsulta());
        historiaDM.getConsulta().setFecha(new Date());
        historiaDM.setCanSeleccionado(new TabCan());
        historiaDM.setIdCan(null);
    }

    public void seleccionarCan() {
        try {
            if (historiaDM.getIdCan() != null) {
                historiaDM.setCanSeleccionado(canService.obtenerPorId(historiaDM.getIdCan()));
            }
        } catch (EntidadNoEncontradaException ex) {
            addErrorMessage(ex.getMessage());
        }
    }

    public void pasarConsulta() {
        historiaDM.setConstanteFisiologica(new FichaConstanteFisiologica());
        historiaDM.getConstanteFisiologica().setFecha(new Date());
        historiaDM.setFisicaVisual(new FichaFisicaVisual());
        historiaDM.getFisicaVisual().setFecha(new Date());
        historiaDM.setEvacuaciones(new FichaEvacuaciones());
        historiaDM.getEvacuaciones().setFecha(new Date());
        historiaDM.setMedicacionPrescrita(new FichaMedicacionPrescrita());
        historiaDM.getMedicacionPrescrita().setFecha(new Date());
        historiaDM.setDiagnostico(new FichaDiagnostico());
        historiaDM.getDiagnostico().setFecha(new Date());
        historiaDM.setVacunacion(new FichaVacunacion());
        historiaDM.getVacunacion().setFecha(new Date());
        historiaDM.setDesparacitacionInterna(new FichaDesparacitacionInterna());
        historiaDM.getDesparacitacionInterna().setFecha(new Date());
        historiaDM.setDesparacitacionExterna(new FichaDesparacitacionExterna());
        historiaDM.getDesparacitacionExterna().setFecha(new Date());
        historiaDM.setShowPanelCrudHistoria(Boolean.TRUE);
        historiaDM.setShowPanelTablaHistoria(Boolean.FALSE);
    }

    public void guardarHistoria() {
        try {
            historiaDM.getConsulta().setAnimal(historiaDM.getCanSeleccionado().getAnimal());
            consultaService.guardarHistoria(historiaDM.getConsulta(), historiaDM.getConstanteFisiologica(), historiaDM.getFisicaVisual(),historiaDM.getEvacuaciones(), historiaDM.getDiagnostico(), historiaDM.getMedicacionPrescrita());
            historiaDM.setShowPanelCrudHistoria(Boolean.FALSE);
            historiaDM.setShowPanelTablaHistoria(Boolean.TRUE);
            initForm();
            addInfoMessage("Registro Guardado Exitosamente");
        } catch (EntidadNoGrabadaException ex) {
            addErrorMessage(ex.getMessage());
        }
    }

    //Getters and Setters
    public HistoriaDM getHistoriaDM() {
        return historiaDM;
    }

    public void setHistoriaDM(HistoriaDM historiaDM) {
        this.historiaDM = historiaDM;
    }

}
