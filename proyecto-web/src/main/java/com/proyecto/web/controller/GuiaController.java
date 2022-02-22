package com.proyecto.web.controller;

import com.proyecto.web.dataManager.GuiaDM;
import com.proyecto.web.enumeration.EstadoRegistroEnum;
import com.proyecto.web.enumeration.GradoGuiaEnum;
import com.proyecto.web.enumeration.TipoIdentificacionEnum;
import com.proyecto.web.exceptions.EntidadNoEncontradaException;
import com.proyecto.web.exceptions.EntidadNoGrabadaException;
import com.proyecto.web.model.TabGuia;
import com.proyecto.web.model.TabPersona;
import com.proyecto.web.service.IGuiaService;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "guiaController")
@ViewScoped
public class GuiaController
        extends BaseController {

    @ManagedProperty("#{guiaDM}")
    GuiaDM guiaDM;

    @EJB
    IGuiaService guiaService;

    public void initForm() {
        guiaDM.setEstadoRegistroEnums(EstadoRegistroEnum.values());
        guiaDM.setTipoIdentificacionEnums(TipoIdentificacionEnum.values());
        guiaDM.setGradoGuiaEnum(GradoGuiaEnum.values());
        listarGuias();
        guiaDM.setShowPanelCrudGuia(Boolean.FALSE);
        guiaDM.setShowPanelTablaGuia(Boolean.TRUE);

    }

    public void nuevoGuia() {
        guiaDM.setGuia(new TabGuia());
        guiaDM.setPersona(new TabPersona());
        guiaDM.setShowPanelCrudGuia(Boolean.TRUE);
        guiaDM.setShowPanelTablaGuia(Boolean.FALSE);
    }

    public void guardarGuia() {
        try {
            guiaService.guardarGuia(guiaDM.getGuia(), guiaDM.getPersona());
            initForm();
            guiaDM.setShowPanelCrudGuia(Boolean.FALSE);
            guiaDM.setShowPanelTablaGuia(Boolean.TRUE);
            addInfoMessage("Registro Guardado");
        } catch (EntidadNoGrabadaException | EntidadNoEncontradaException ex) {
            addErrorMessage(ex.getMessage());
        }

    }

    public void listarGuias() {
        guiaDM.setListaGuias(guiaService.buscar(new TabGuia()));

    }

    public void editarGuia(TabGuia guia) {
        guiaDM.setGuia(guia);
        guiaDM.setPersona(guia.getPersona());
        guiaDM.setShowPanelCrudGuia(Boolean.TRUE);
        guiaDM.setShowPanelTablaGuia(Boolean.FALSE);
    }

    public void eliminarGuia() {

    }

    public void cancelarGuia() {
        initForm();
    }

    //Getters and Setters
    public GuiaDM getGuiaDM() {
        return guiaDM;
    }

    public void setGuiaDM(GuiaDM guiaDM) {
        this.guiaDM = guiaDM;
    }

}
