package com.proyecto.web.controller;

import com.proyecto.web.dataManager.SelectItemsDM;
import com.proyecto.web.model.TabActividad;

import com.proyecto.web.model.TabPerfil;

import com.proyecto.web.model.TabUsuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

/**
 * Clase ...
 *
 * @author 
 * @revision $Revision: 1.4 $
 */
@ManagedBean(name = "selectItemsController")
@ViewScoped
public class SelectItemsController implements Serializable {

    @ManagedProperty(value = "#{selectItemsDM}")
    private SelectItemsDM selectItemsDM;

    List<SelectItem> itemsListaPerfiles = new ArrayList<>();
  
    List<SelectItem> itemsListaUsuarios = new ArrayList<>();
   List<SelectItem> itemsListaActividades = new ArrayList<>();

    public List<SelectItem> getItemsListaActividades() {
                itemsListaActividades = new ArrayList<>();
        if (selectItemsDM.getListaActividades() != null && !selectItemsDM.getListaActividades().isEmpty()) {
            for (TabActividad actividad : selectItemsDM.getListaActividades()) {
                itemsListaActividades.add(new SelectItem(actividad.getId(), actividad.getDescripcion()));
            }
        }
        return itemsListaActividades;
    }

    public void setItemsListaActividades(List<SelectItem> itemsListaActividades) {
        this.itemsListaActividades = itemsListaActividades;
    }
    

    

   

    public List<SelectItem> getItemsListaPerfiles() {
        itemsListaPerfiles = new ArrayList<>();
        if (selectItemsDM.getListaPerfiles() != null && !selectItemsDM.getListaPerfiles().isEmpty()) {
            for (TabPerfil perfil : selectItemsDM.getListaPerfiles()) {
                itemsListaPerfiles.add(new SelectItem(perfil.getId(), perfil.getNombre()));
            }
        }
        return itemsListaPerfiles;
    }

  

    public List<SelectItem> getItemsListaUsuarios() {
        itemsListaUsuarios = new ArrayList<>();
        if (selectItemsDM.getListaUsuarios() != null && !selectItemsDM.getListaUsuarios().isEmpty()) {
            for (TabUsuario items : selectItemsDM.getListaUsuarios()) {
                itemsListaUsuarios.add(new SelectItem(items.getId(), items.getPersona().getNombres() + " " + items.getPersona().getApellidos()));
            }
        }
        return itemsListaUsuarios;
    }

   

    

    

    public void setItemsListaUsuarios(List<SelectItem> itemsListaUsuarios) {
        this.itemsListaUsuarios = itemsListaUsuarios;
    }

  

    public void setItemsListaPerfiles(List<SelectItem> itemsListaPerfiles) {
        this.itemsListaPerfiles = itemsListaPerfiles;
    }

    public SelectItemsDM getSelectItemsDM() {
        return selectItemsDM;
    }

    public void setSelectItemsDM(SelectItemsDM selectItemsDM) {
        this.selectItemsDM = selectItemsDM;
    }

}
