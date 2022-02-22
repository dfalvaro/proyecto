package com.proyecto.web.dataManager;


import com.proyecto.web.model.TabActividad;
import com.proyecto.web.model.TabPerfil;
import com.proyecto.web.model.TabUsuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Clase ...
 *
 * @author
 * @revision $Revision: 1.3 $
 */
@ManagedBean(name = "selectItemsDM")
@SessionScoped
public class SelectItemsDM implements Serializable {

    private List<TabPerfil> listaPerfiles = new ArrayList<>();

    private List<TabUsuario> listaUsuarios = new ArrayList<>();
 private List<TabActividad> listaActividades= new ArrayList<>();

    public List<TabActividad> getListaActividades() {
        return listaActividades;
    }

    public void setListaActividades(List<TabActividad> listaActividades) {
        this.listaActividades = listaActividades;
    }

   

    public List<TabPerfil> getListaPerfiles() {
        return listaPerfiles;
    }

    public void setListaPerfiles(List<TabPerfil> listaPerfiles) {
        this.listaPerfiles = listaPerfiles;
    }

    public List<TabUsuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<TabUsuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

  
  

}
