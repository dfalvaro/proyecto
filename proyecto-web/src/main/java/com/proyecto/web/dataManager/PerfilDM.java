package com.proyecto.web.dataManager;

import com.proyecto.web.model.TabMenu;
import com.proyecto.web.model.TabPerfil;
import com.proyecto.web.model.TabPerfilMenu;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "perfilDM")
@SessionScoped
public class PerfilDM implements Serializable {

    private TabPerfil perfil = new TabPerfil();
    private List<TabMenu> listaFuncionalidades = new ArrayList();
    private List<TabMenu> listaFuncionalidadesSeleccionaldas = new ArrayList();
    private List<TabPerfilMenu> listaMenuPerfilEliminacion = new ArrayList();
    private List<TabPerfilMenu> listaMenuPerfilCreacion = new ArrayList();
    private List<TabPerfil> perfilList;
    private Boolean showPanelTablaPerfil = Boolean.FALSE;
    private Boolean showPanelCrudPerfil = Boolean.FALSE;

    public TabPerfil getPerfil() {
        return perfil;
    }

    public void setPerfil(TabPerfil perfil) {
        this.perfil = perfil;
    }

    public List<TabMenu> getListaFuncionalidades() {
        return listaFuncionalidades;
    }

    public void setListaFuncionalidades(List<TabMenu> listaFuncionalidades) {
        this.listaFuncionalidades = listaFuncionalidades;
    }

    public List<TabMenu> getListaFuncionalidadesSeleccionaldas() {
        return listaFuncionalidadesSeleccionaldas;
    }

    public void setListaFuncionalidadesSeleccionaldas(List<TabMenu> listaFuncionalidadesSeleccionaldas) {
        this.listaFuncionalidadesSeleccionaldas = listaFuncionalidadesSeleccionaldas;
    }

    public List<TabPerfilMenu> getListaMenuPerfilEliminacion() {
        return listaMenuPerfilEliminacion;
    }

    public void setListaMenuPerfilEliminacion(List<TabPerfilMenu> listaMenuPerfilEliminacion) {
        this.listaMenuPerfilEliminacion = listaMenuPerfilEliminacion;
    }

    public List<TabPerfilMenu> getListaMenuPerfilCreacion() {
        return listaMenuPerfilCreacion;
    }

    public void setListaMenuPerfilCreacion(List<TabPerfilMenu> listaMenuPerfilCreacion) {
        this.listaMenuPerfilCreacion = listaMenuPerfilCreacion;
    }

    public List<TabPerfil> getPerfilList() {
        return perfilList;
    }

    public void setPerfilList(List<TabPerfil> perfilList) {
        this.perfilList = perfilList;
    }

    public Boolean getShowPanelTablaPerfil() {
        return showPanelTablaPerfil;
    }

    public void setShowPanelTablaPerfil(Boolean showPanelTablaPerfil) {
        this.showPanelTablaPerfil = showPanelTablaPerfil;
    }

    public Boolean getShowPanelCrudPerfil() {
        return showPanelCrudPerfil;
    }

    public void setShowPanelCrudPerfil(Boolean showPanelCrudPerfil) {
        this.showPanelCrudPerfil = showPanelCrudPerfil;
    }

}
