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

@ManagedBean(name = "canController")
@ViewScoped
public class CanController
        extends BaseController {
    
    @ManagedProperty("#{canDM}")
    CanDM canDM;
    
    @EJB
    ICanService canService;
    @EJB
    IEspecialidadService especialidadService;
    @EJB
    IEspecialidadSubtipoService especialidadSubtipoService;
    @EJB
    IGuiaService guiaService;
    
    public void initForm() {
        System.err.println("entra init form canes");
        canDM.setDialogPDF(Boolean.FALSE);
        
        buscarCan();
        listarGuias();
        canDM.setListaEstadoAnimal(EstadoRegistroAnimalEnum.values());
        canDM.setListaSexoAnimal(TipoSexoAnimalEnum.values());
        canDM.setListaEstadoRepoductivoAnimal(EstadoReproductivoAnimalEnum.values());
        canDM.setShowPanelCrudCan(Boolean.FALSE);
        canDM.setShowPanelTablaCan(Boolean.TRUE);
        
    }
    
    public void nuevoCan() {
        System.err.println("Entra a crea nuvo can");
        
        listarEspecialidades();
        canDM.setCan(new TabCan());
        canDM.getCan().setCodigoSiipneValidacion("");
        canDM.getCan().setCodigoEsbyeValidacion("");
        canDM.getCan().setNumeroChipsValidacion("");
        canDM.setAnimal(new TabAnimal());
        canDM.setIdGuia(null);
        generarSecuencial();
        canDM.setShowPanelCrudCan(Boolean.TRUE);
        canDM.setShowPanelTablaCan(Boolean.FALSE);
        
    }
    
    public void generarSecuencial() {
        Long secuencialEncontrado = 1L;
        String codigoAdicional = "PN-C-";
        
        Long secuencialFinal = canService.obtenerSecuencialFinal();
        if (secuencialFinal != null) {
            secuencialEncontrado = secuencialFinal + 1;
        }
        
        canDM.getCan().setCodigoInterno(codigoAdicional + Util.generarCerosSecuenciales(secuencialEncontrado, 3));
        canDM.getCan().setSecuencial(secuencialEncontrado);
        
    }
    
    public void guardarCan() {
        System.err.println("diego");
             
        try {
            System.err.println("Entra al guardar");
            
            if (canDM.getIdGuia() != null) {
                TabGuia guiaEncontrado = guiaService.obtenerPorId(canDM.getIdGuia());
                canDM.getCan().setGuia(guiaEncontrado);
            }
            canService.guardarCan(canDM.getCan(), canDM.getAnimal());
            initForm();
            addInfoMessage("Registro Guardado");
        } catch (EntidadNoGrabadaException | EntidadNoEncontradaException ex) {
            addErrorMessage(ex.getMessage());
        }
        
    }
    
    public void buscarCan() {
        canDM.setListaCanes(canService.buscar(new TabCan()));
        
    }
    
    public void listarEspecialidades() {
        canDM.setListaEspecialidad(especialidadService.buscar(new TabEspecialidad()));
    }
    
    public void listarEspecialidadSubtipo() {
        try {
            
            if (canDM.getCan().getEspecialidadTipo() != null) {
                canDM.setEspecialidadSeleccionado(especialidadService.obtenerPorId(canDM.getCan().getEspecialidadTipo()));
                canDM.setListaEspecialidadSubtipo(especialidadSubtipoService.buscar(new TabEspecialidadSubtipo(canDM.getEspecialidadSeleccionado())));
            }
            
        } catch (EntidadNoEncontradaException ex) {
            Logger.getLogger(CanController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void selecionarCan() {
        
    }
    
    public void editarCan(TabCan can) {
        listarEspecialidades();
        canDM.setCan(can);
        canDM.getCan().setCodigoSiipne(can.getCodigoSiipneValidacion());
        canDM.getCan().setCodigoEsbye(can.getCodigoEsbyeValidacion());
        canDM.getCan().setNumeroChipsValidacion(can.getNumeroChipsValidacion());
        canDM.setAnimal(can.getAnimal());
        if (can.getGuia() != null) {
            canDM.setIdGuia(can.getGuia().getId());
        }
        listarEspecialidadSubtipo();
        canDM.setShowPanelCrudCan(Boolean.TRUE);
        canDM.setShowPanelTablaCan(Boolean.FALSE);
        
    }
    
    public void cancelarCan() {
        initForm();
    }
    
    public void almacenarImagenCan(FileUploadEvent event) {
        
        try {
            canDM.getAnimal().setImagenBase64(UtilVista.convertirImagenBase64(event.getFile().getInputStream()));
            canDM.getAnimal().setNombreImagen(event.getFile().getFileName());
            
        } catch (IOException e) {
            System.err.println("" + e.getMessage());
        }
    }
    
    public void listarGuias() {
        System.err.println("entraaaaaaaaaaaaaaaa");
        canDM.setListaGuias(guiaService.buscar(new TabGuia()));
        System.err.println("lista de canes:" + canDM.getListaGuias());
    }

    /////////////////////////
    public void generarReporteClientes() throws JRException, Exception {
        
        JasperPrint jasperPrint;
        String descripcion = "Lista de Canes registrados. \n";
        jasperPrint = generarReporteCanes("ddd",
                descripcion);
        generarExportReporte(jasperPrint);
    }
    
    public JasperPrint generarReporteCanes(
            String nombreReporte,
            String descripcion
    ) throws JRException, EntidadNoEncontradaException, Exception {
        
        Map<String, Object> parametros = construyeEncabezadoPDF(nombreReporte, descripcion);
        
        try (Connection conexion = connectionWanqaraBD()) {
            String reportPath = FacesContext.getCurrentInstance().getExternalContext()
                    .getRealPath("pages/secure/jasper/general/reportCanes.jasper");
            return JasperFillManager.fillReport(reportPath, parametros, conexion);
        }
        
    }
    
    private Map<String, Object> construyeEncabezadoPDF(
            String nombreReporte,
            String descripcion
    ) {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("nombreReporte", nombreReporte);
        parametros.put("descripcion", descripcion);
        
        parametros.put("REPORT_LOCALE", new Locale("es", "EC"));
        
        parametros.put("usuario", "Diego");
        
        return parametros;
    }

    ///////////////
    private void generarExportReporte(JasperPrint jasperPrint) {
        
        try {
            mostrarReportePDF(jasperPrint);
        } catch (JRException ex) {
        }
        
    }
    
    private void mostrarReportePDF(JasperPrint jasperPrint) throws JRException {
        canDM.setDialogPDF(Boolean.FALSE);
        System.err.println("bytes:" + JasperExportManager.exportReportToPdf(jasperPrint).length);
        cabeceraDM.setPdfArray(JasperExportManager.exportReportToPdf(jasperPrint));
        cabeceraDM.setStreamPdf(new DefaultStreamedContent(new ByteArrayInputStream(cabeceraDM.getPdfArray())));
        
        PrimeFaces.current().executeScript("PF('dlgPdf').show();");
    }

    //Getters and Setters
    public CanDM getCanDM() {
        return canDM;
    }
    
    public void setCanDM(CanDM canDM) {
        this.canDM = canDM;
    }
    
}
