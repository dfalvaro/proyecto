package com.proyecto.web.dataManager;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "generalReportDM")
@ViewScoped
public class GeneralReportDM implements Serializable {
    
       private Boolean dialogPDF = false;
       
       
       
    //Getters and Setters
    public Boolean getDialogPDF() {
        return dialogPDF;
    }

    public void setDialogPDF(Boolean dialogPDF) {
        this.dialogPDF = dialogPDF;
    }

       
       
   
    
}
