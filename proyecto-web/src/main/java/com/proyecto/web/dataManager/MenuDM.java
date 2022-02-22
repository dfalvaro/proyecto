package com.proyecto.web.dataManager;

import com.proyecto.web.model.DatosAuditoria;
import com.proyecto.web.model.TabMenu;
import com.proyecto.web.model.TabPerfilMenu;
import com.proyecto.web.model.TabUsuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*prueba*/
@SessionScoped
@Named
public class MenuDM implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<TabMenu> menuList = new ArrayList();
    private List<TabMenu> menuListHijos = new ArrayList();
    private List<String> lista = new ArrayList();
    private List<TabMenu> padres;
    HttpServletRequest request;
    HttpServletResponse response;
    private DatosAuditoria datosAuditoria = new DatosAuditoria();
    HttpSession sesion;
    private Date fecha = new Date();
    private TabUsuario usuario = null;
    private List<String> listaModulos = new ArrayList();
    private List<String> listaMenus = new ArrayList();
    private String operacionesAsignadas = "";
    private List<TabMenu> menuUsuarioSeg = new ArrayList<TabMenu>();
    private TabMenu funcionalidad = new TabMenu();
    private String valorAnteriorAuditoria = "";
    private String valorActualAuditoria = "";
    private Object idAnteriorAuditoria = null;
    private String nombreUsuario = "";
    private String nombreFuncionalidad = "";
    private List<TabPerfilMenu> listaPerfilMenu = new ArrayList();
    private byte[] pdfArray;

    public List<TabMenu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<TabMenu> menuList) {
        this.menuList = menuList;
    }

    public List<String> getLista() {
        return lista;
    }

    public void setLista(List<String> lista) {
        this.lista = lista;
    }

    public List<TabMenu> getPadres() {
        return padres;
    }

    public void setPadres(List<TabMenu> padres) {
        this.padres = padres;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public TabUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(TabUsuario usuario) {
        this.usuario = usuario;
    }

    public List<TabMenu> getMenuUsuarioSeg() {
        return menuUsuarioSeg;
    }

    public void setMenuUsuarioSeg(List<TabMenu> menuUsuarioSeg) {
        this.menuUsuarioSeg = menuUsuarioSeg;
    }

    public TabMenu getFuncionalidad() {
        return funcionalidad;
    }

    public void setFuncionalidad(TabMenu funcionalidad) {
        this.funcionalidad = funcionalidad;
    }

    public List<TabMenu> getMenuListHijos() {
        return menuListHijos;
    }

    public void setMenuListHijos(List<TabMenu> menuListHijos) {
        this.menuListHijos = menuListHijos;
    }

    public String getOperacionesAsignadas() {
        return operacionesAsignadas;
    }

    public void setOperacionesAsignadas(String operacionesAsignadas) {
        this.operacionesAsignadas = operacionesAsignadas;
    }

    public String getValorAnteriorAuditoria() {
        return valorAnteriorAuditoria;
    }

    public void setValorAnteriorAuditoria(String valorAnteriorAuditoria) {
        this.valorAnteriorAuditoria = valorAnteriorAuditoria;
    }

    public String getValorActualAuditoria() {
        return valorActualAuditoria;
    }

    public void setValorActualAuditoria(String valorActualAuditoria) {
        this.valorActualAuditoria = valorActualAuditoria;
    }

    public Object getIdAnteriorAuditoria() {
        return idAnteriorAuditoria;
    }

    public void setIdAnteriorAuditoria(Object idAnteriorAuditoria) {
        this.idAnteriorAuditoria = idAnteriorAuditoria;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreFuncionalidad() {
        return nombreFuncionalidad;
    }

    public void setNombreFuncionalidad(String nombreFuncionalidad) {
        this.nombreFuncionalidad = nombreFuncionalidad;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public HttpSession getSesion() {
        return sesion;
    }

    public void setSesion(HttpSession sesion) {
        this.sesion = sesion;
    }

    public DatosAuditoria getDatosAuditoria() {
        return datosAuditoria;
    }

    public void setDatosAuditoria(DatosAuditoria datosAuditoria) {
        this.datosAuditoria = datosAuditoria;
    }

    public List<String> getListaModulos() {
        return listaModulos;
    }

    public void setListaModulos(List<String> listaModulos) {
        this.listaModulos = listaModulos;
    }

    public List<String> getListaMenus() {
        return listaMenus;
    }

    public void setListaMenus(List<String> listaMenus) {
        this.listaMenus = listaMenus;
    }

    public List<TabPerfilMenu> getListaPerfilMenu() {
        return listaPerfilMenu;
    }

    public void setListaPerfilMenu(List<TabPerfilMenu> listaPerfilMenu) {
        this.listaPerfilMenu = listaPerfilMenu;
    }

    public byte[] getPdfArray() {
        return pdfArray;
    }

    public void setPdfArray(byte[] pdfArray) {
        this.pdfArray = pdfArray;
    }
    
    

}
