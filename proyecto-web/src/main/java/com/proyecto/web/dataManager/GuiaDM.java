package com.proyecto.web.dataManager;

import com.proyecto.web.enumeration.EstadoRegistroEnum;
import com.proyecto.web.enumeration.GradoGuiaEnum;
import com.proyecto.web.enumeration.TipoIdentificacionEnum;
import com.proyecto.web.model.TabGuia;
import com.proyecto.web.model.TabPersona;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "guiaDM")
@ViewScoped
public class GuiaDM implements Serializable {

    private TabGuia guia = new TabGuia();
    private TabPersona persona = new TabPersona();
    private List<TabGuia> listaGuias = new ArrayList<>();
    private EstadoRegistroEnum[] estadoRegistroEnums;
    private TipoIdentificacionEnum[] tipoIdentificacionEnums;
    private GradoGuiaEnum[] gradoGuiaEnum;

    //Paneles 
    private Boolean showPanelTablaGuia = Boolean.FALSE;
    private Boolean showPanelCrudGuia = Boolean.FALSE;

    public GuiaDM() {
    }

    //Getters and Setters
    public TabGuia getGuia() {
        return guia;
    }

    public void setGuia(TabGuia guia) {
        this.guia = guia;
    }

    public TabPersona getPersona() {
        return persona;
    }

    public void setPersona(TabPersona persona) {
        this.persona = persona;
    }

    public List<TabGuia> getListaGuias() {
        return listaGuias;
    }

    public void setListaGuias(List<TabGuia> listaGuias) {
        this.listaGuias = listaGuias;
    }

    public EstadoRegistroEnum[] getEstadoRegistroEnums() {
        return estadoRegistroEnums;
    }

    public void setEstadoRegistroEnums(EstadoRegistroEnum[] estadoRegistroEnums) {
        this.estadoRegistroEnums = estadoRegistroEnums;
    }

    public TipoIdentificacionEnum[] getTipoIdentificacionEnums() {
        return tipoIdentificacionEnums;
    }

    public void setTipoIdentificacionEnums(TipoIdentificacionEnum[] tipoIdentificacionEnums) {
        this.tipoIdentificacionEnums = tipoIdentificacionEnums;
    }

    public Boolean getShowPanelTablaGuia() {
        return showPanelTablaGuia;
    }

    public void setShowPanelTablaGuia(Boolean showPanelTablaGuia) {
        this.showPanelTablaGuia = showPanelTablaGuia;
    }

    public Boolean getShowPanelCrudGuia() {
        return showPanelCrudGuia;
    }

    public void setShowPanelCrudGuia(Boolean showPanelCrudGuia) {
        this.showPanelCrudGuia = showPanelCrudGuia;
    }

    public GradoGuiaEnum[] getGradoGuiaEnum() {
        return gradoGuiaEnum;
    }

    public void setGradoGuiaEnum(GradoGuiaEnum[] gradoGuiaEnum) {
        this.gradoGuiaEnum = gradoGuiaEnum;
    }

}
