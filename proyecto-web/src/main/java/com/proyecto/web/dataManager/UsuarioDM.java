package com.proyecto.web.dataManager;

import com.proyecto.web.enumeration.PaisesEnum;
import com.proyecto.web.model.TabPersona;
import com.proyecto.web.model.TabUsuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "usuarioDM")
@SessionScoped
public class UsuarioDM implements Serializable {

    private TabUsuario usuario = new TabUsuario();
    private List<TabUsuario> listaUsuarios = new ArrayList();
    private Boolean showPanelTablaUsuario = Boolean.FALSE;
    private Boolean showPanelCrudUsuario = Boolean.FALSE;
    private Boolean claveObligatoria = Boolean.FALSE;
    private Long idPerfil = null;
       private Long idUsuarioAprobador = null;
    private TabPersona entidad = new TabPersona();
   private PaisesEnum[] listaPaises;
    public TabUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(TabUsuario usuario) {
        this.usuario = usuario;
    }

    public List<TabUsuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<TabUsuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public Boolean getShowPanelTablaUsuario() {
        return showPanelTablaUsuario;
    }

    public void setShowPanelTablaUsuario(Boolean showPanelTablaUsuario) {
        this.showPanelTablaUsuario = showPanelTablaUsuario;
    }

    public Boolean getShowPanelCrudUsuario() {
        return showPanelCrudUsuario;
    }

    public void setShowPanelCrudUsuario(Boolean showPanelCrudUsuario) {
        this.showPanelCrudUsuario = showPanelCrudUsuario;
    }

    public Long getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Long idPerfil) {
        this.idPerfil = idPerfil;
    }

    public TabPersona getEntidad() {
        return entidad;
    }

    public void setEntidad(TabPersona entidad) {
        this.entidad = entidad;
    }

    public Boolean getClaveObligatoria() {
        return claveObligatoria;
    }

    public void setClaveObligatoria(Boolean claveObligatoria) {
        this.claveObligatoria = claveObligatoria;
    }

    public Long getIdUsuarioAprobador() {
        return idUsuarioAprobador;
    }

    public void setIdUsuarioAprobador(Long idUsuarioAprobador) {
        this.idUsuarioAprobador = idUsuarioAprobador;
    }

    public PaisesEnum[] getListaPaises() {
        return listaPaises;
    }

    public void setListaPaises(PaisesEnum[] listaPaises) {
        this.listaPaises = listaPaises;
    }


 

}
