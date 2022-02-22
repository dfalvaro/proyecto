package com.proyecto.web.controller;

import com.proyecto.web.controllerReport.GeneralReportController;
import com.proyecto.web.dataManager.CanDM;
import com.proyecto.web.dataManager.ReporteDM;
import com.proyecto.web.exceptions.EntidadNoEncontradaException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.primefaces.PrimeFaces;

@ManagedBean(name = "consultaControllerReport")
@ViewScoped
public class ConsultaControllerReport
        extends BaseController {

    @ManagedProperty("#{canDM}")
    CanDM canDM;

   

    public void initForm() {

//        reporteDM.setDialogPDF(Boolean.FALSE);

    }

//    public void generarReporteClientes() throws JRException, Exception {
//
//        JasperPrint jasperPrint;
//        String descripcion = "Lista de Canes registrados. \n";
//        jasperPrint = generarReporteCanes("ddd",
//                descripcion);
//        generarExportReporte(jasperPrint);
//    }
//
//    public JasperPrint generarReporteCanes(
//            String nombreReporte,
//            String descripcion
//    ) throws JRException, EntidadNoEncontradaException, Exception {
//
//        Map<String, Object> parametros = construyeEncabezadoPDF(nombreReporte, descripcion);
//
//        try (Connection conexion = connectionWanqaraBD()) {
//            String reportPath = FacesContext.getCurrentInstance().getExternalContext()
//                    .getRealPath("pages/secure/jasper/general/reportCanes.jasper");
//            return JasperFillManager.fillReport(reportPath, parametros, conexion);
//        }
//
//    }
//
//    private Map<String, Object> construyeEncabezadoPDF(
//            String nombreReporte,
//            String descripcion
//    ) {
//        Map<String, Object> parametros = new HashMap<>();
//        parametros.put("nombreReporte", nombreReporte);
//        parametros.put("descripcion", descripcion);
//
//        parametros.put("REPORT_LOCALE", new Locale("es", "EC"));
//
//        parametros.put("usuario", "Diego");
//
//        return parametros;
//    }
//
//    ///////////////
//    private void generarExportReporte(JasperPrint jasperPrint) {
//
//        try {
//            mostrarReportePDF(jasperPrint);
//        } catch (JRException ex) {
//            Logger.getLogger(GeneralReportController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
//
//    private void mostrarReportePDF(JasperPrint jasperPrint) throws JRException {
//        reporteDM.setDialogPDF(Boolean.FALSE);
//        menuDM.setPdfArray(JasperExportManager.exportReportToPdf(jasperPrint));
//        PrimeFaces.current().executeScript("PF('dlgPdf').show();");
//    }

    //Getters and Setters
    public CanDM getCanDM() {
        return canDM;
    }

    public void setCanDM(CanDM canDM) {
        this.canDM = canDM;
    }

  

}
