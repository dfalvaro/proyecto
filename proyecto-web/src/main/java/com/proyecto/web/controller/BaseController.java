/**
 * BaseController
 *
 */
package com.proyecto.web.controller;

import com.proyecto.web.dataManager.CabeceraDM;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.proyecto.web.dataManager.GenericDM;
import com.proyecto.web.dataManager.MenuDM;
import com.proyecto.web.dataManager.SelectItemsDM;
import com.proyecto.web.enumeration.TipoImagenEnum;
import com.proyecto.web.util.UtilVista;
import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Base64;
import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 * @author
 *
 */
@ManagedBean(name = "base")
@ViewScoped
public abstract class BaseController implements Serializable {

    @ManagedProperty(value = "#{selectItemsDM}")
    protected SelectItemsDM selectItemsDM;

    @ManagedProperty(value = "#{genericDM}")
    protected GenericDM genericDM;
    @ManagedProperty(value = "#{cabeceraDM}")
    protected CabeceraDM cabeceraDM;

    @Inject
    protected MenuDM accesoMenuDM;
    @Inject
    protected MenuDM menuDM;

    /**
     *
     * @return
     */
    public GenericDM getabericDM() {
        return genericDM;
    }

    /**
     * @param resumen
     */
    protected void addErrorMessage(final String resumen) {
        FacesMessage message = new FacesMessage(resumen);
        message.setSeverity(FacesMessage.SEVERITY_ERROR);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * @param resumen
     * @param detalle
     */
    protected void addErrorMessage(final String resumen, final String detalle) {
        FacesMessage message = new FacesMessage(resumen, detalle);
        message.setSeverity(FacesMessage.SEVERITY_ERROR);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * @param resumen
     */
    protected void addInfoMessage(final String resumen) {
        FacesMessage message = new FacesMessage(resumen);
        message.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * @param resumen
     * @param detalle
     */
    protected void addInfoMessage(final String resumen, final String detalle) {
        FacesMessage message = new FacesMessage(resumen, detalle);
        message.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * @param resumen
     */
    protected void addWarnMessage(final String resumen) {
        FacesMessage message = new FacesMessage(resumen);
        message.setSeverity(FacesMessage.SEVERITY_WARN);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * @param resumen
     * @param detalle
     */
    protected void addWarnMessage(final String resumen, final String detalle) {
        FacesMessage message = new FacesMessage(resumen, detalle);
        message.setSeverity(FacesMessage.SEVERITY_WARN);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * @return
     */
    public boolean isExistErrors() {
        Severity maximunSeverity = getFacesContext().getMaximumSeverity();
        if (FacesMessage.SEVERITY_ERROR.equals(maximunSeverity)) {
            return true;
        }
        return false;

    }

    public UIComponent getCurrentComponent() {
        FacesContext context = getFacesContext();
        return UIComponent.getCurrentComponent(context);
    }

    /**
     * @return
     */
    protected static FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }

    /**
     * @param parameterName
     * @return
     */
    protected Object getRequestParameter(final String parameterName) {
        return getFacesContext().getExternalContext().getRequestParameterMap().get(parameterName);
    }

    /**
     * @return
     */
    protected String getRemoteUser() {
        String username = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
        return username;
    }

    /**
     * @return
     */
    protected HttpSession getSession() {
        return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    }

    /**
     * @return
     */
    protected ServletContext getServletContext() {
        return (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();

    }

    /**
     * @return
     */
    protected HttpServletResponse getServletResponse() {
        return (HttpServletResponse) getFacesContext().getExternalContext().getResponse();
    }

    /**
     * @return
     */
    protected HttpServletRequest getServletRequest() {
        return (HttpServletRequest) getFacesContext().getExternalContext().getRequest();
    }

    /**
     * @return
     */
    protected Map<String, Object> getSessionMap() {
        return getFacesContext().getExternalContext().getSessionMap();
    }

    /**
     * @return
     */
    public Locale getCurrentLocale() {
        return getFacesContext().getViewRoot().getLocale();
    }

    /**
     * @return
     */
    public String getStringLocale() {
        return getCurrentLocale().getLanguage();
    }

    /**
     * @param c
     * @param id
     * @return
     */
    public UIComponent findComponent(final UIComponent c, final String id) {
        if (id.equals(c.getId())) {
            return c;
        }
        Iterator<UIComponent> kids = c.getFacetsAndChildren();
        while (kids.hasNext()) {
            UIComponent found = findComponent(kids.next(), id);
            if (found != null) {
                return found;
            }
        }
        return null;
    }

    /**
     * @param date
     * @param format
     * @return
     */
    protected String dateFormat(final Date date, final String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * @return
     */
    public String getViewId() {
        return FacesContext.getCurrentInstance().getViewRoot().getViewId();
    }

    /**
     * @return
     */
    public String getCurrentPage() {
        String currentPage = getServletContext().getContextPath() + getViewId();
        return currentPage.replace("xhtml", "jsf");
    }

    public StreamedContent mostrarImagenCanBase(String imagen) {
        return UtilVista.mostrarImagenBase(imagen, TipoImagenEnum.CAN.name());
    }

    public StreamedContent mostrarImagenTemporal(String base64) {
        try {
            base64 = base64.replaceAll("\n", "");
            return new DefaultStreamedContent(new ByteArrayInputStream(Base64.getDecoder().decode(base64.getBytes())));
        } catch (Exception e) {
            return null;
        }

    }

    public Connection connectionWanqaraBD() {
        System.err.println("sssss");
        try {
                    System.err.println("aaaa");

            InitialContext cxt = new InitialContext();
            DataSource ds = (DataSource) cxt.lookup("java:jboss/laboratorioDS");
            System.err.println("ds"+ds.getConnection());
                  
            return ds.getConnection();
        } catch (NamingException | SQLException ex) {
            return null;
        }

    }

    public GenericDM getGenericDM() {
        return genericDM;
    }

    public void setGenericDM(GenericDM genericDM) {
        this.genericDM = genericDM;
    }

    public MenuDM getAccesoMenuDM() {
        return accesoMenuDM;
    }

    public void setAccesoMenuDM(MenuDM accesoMenuDM) {
        this.accesoMenuDM = accesoMenuDM;
    }

    public SelectItemsDM getSelectItemsDM() {
        return selectItemsDM;
    }

    public void setSelectItemsDM(final SelectItemsDM selectItemsDM) {
        this.selectItemsDM = selectItemsDM;
    }

    public CabeceraDM getCabeceraDM() {
        return cabeceraDM;
    }

    public void setCabeceraDM(CabeceraDM cabeceraDM) {
        this.cabeceraDM = cabeceraDM;
    }

    public MenuDM getMenuDM() {
        return menuDM;
    }

    public void setMenuDM(MenuDM menuDM) {
        this.menuDM = menuDM;
    }
    
    

}
