package com.proyecto.web.controller;

import com.proyecto.web.dataManager.DetectorDM;
import com.proyecto.web.exceptions.EntidadNoEncontradaException;
import com.proyecto.web.model.TabCan;
import com.proyecto.web.model.TabEspecialidad;
import com.proyecto.web.model.TabEspecialidadSubtipo;
import com.proyecto.web.model.TabGuia;
import com.proyecto.web.model.TecnicaExamen;
import com.proyecto.web.service.ICanService;
import com.proyecto.web.service.IEspecialidadSubtipoService;
import com.proyecto.web.service.IGuiaService;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "detectorController")
@ViewScoped
public class DetectorController
        extends BaseController {

    @ManagedProperty("#{detectorDM}")
    DetectorDM detectorDM;

    @EJB
    ICanService canService;
    @EJB
    IEspecialidadSubtipoService especialidadSubtipoService;
    @EJB
    IGuiaService guiaService;

    public void initForm() {
        nuevoExamen();
        
        listarCanesDetectores();
        listarEspecialidadSubtipo();
        listarGuias();

    }

    public void nuevoExamen() {
        detectorDM.setExamen(new TecnicaExamen());
        detectorDM.getExamen().setFecha(new Date());

    }

    public void listarCanesDetectores() {
        detectorDM.setListaCanes(canService.buscar(new TabCan(1L)));

    }

    public void listarGuias() {
        detectorDM.setListaGuias(guiaService.buscar(new TabGuia()));

    }
    
    public void listarEspecialidadSubtipo(){
        detectorDM.setListaEspecialidadSubtipo(especialidadSubtipoService.buscar(new TabEspecialidadSubtipo(new TabEspecialidad(1L))));
    }

    public void obtenerDatosCan() {
        try {

            if (detectorDM.getIdCan() != null) {
                detectorDM.setCanSeleccionado(canService.obtenerPorId(detectorDM.getIdCan()));
            }
        } catch (EntidadNoEncontradaException ex) {
            addErrorMessage(ex.getMessage());
        }
    }

    //Getters and Setters
    public DetectorDM getDetectorDM() {
        return detectorDM;
    }

    public void setDetectorDM(DetectorDM detectorDM) {
        this.detectorDM = detectorDM;
    }

}
