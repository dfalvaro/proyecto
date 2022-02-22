package com.proyecto.web.controller;

import com.proyecto.web.dataManager.CanDM;
import com.proyecto.web.enumeration.EstadoRegistroAnimalEnum;
import com.proyecto.web.enumeration.EstadoReproductivoAnimalEnum;
import com.proyecto.web.enumeration.TipoSexoAnimalEnum;
import com.proyecto.web.exceptions.EntidadNoEncontradaException;
import com.proyecto.web.exceptions.EntidadNoGrabadaException;
import com.proyecto.web.model.TabAnimal;
import com.proyecto.web.model.TabCan;
import com.proyecto.web.model.TabEspecialidad;
import com.proyecto.web.model.TabEspecialidadSubtipo;
import com.proyecto.web.model.TabGuia;
import com.proyecto.web.service.ICanService;
import com.proyecto.web.service.IEspecialidadService;
import com.proyecto.web.service.IEspecialidadSubtipoService;
import com.proyecto.web.service.IGuiaService;
import com.proyecto.web.util.Util;
import com.proyecto.web.util.UtilVista;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.primefaces.PrimeFaces;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;

@ManagedBean(name = "parametrosController")
@ViewScoped
public class ParametrosController
        extends BaseController {

//    @ManagedProperty("#{parametroDM}")
//    ParametroDM parametroDM;

    @EJB
    ICanService canService;
    @EJB
    IEspecialidadService especialidadService;
    @EJB
    IEspecialidadSubtipoService especialidadSubtipoService;
    @EJB
    IGuiaService guiaService;

    public void initForm() {
        System.err.println("entra init form parametros");

    }

    //Getters and Setters
//    public ParametroDM getParametroDM() {
//        return parametroDM;
//    }
//
//    public void setParametroDM(ParametroDM parametroDM) {
//        this.parametroDM = parametroDM;
//    }

}
