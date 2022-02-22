package com.proyecto.web.filter;

import com.proyecto.web.dataManager.MenuDM;
import com.proyecto.web.enumeration.EstadoRegistroEnum;
import com.proyecto.web.model.DatosAuditoria;
import com.proyecto.web.model.TabMenu;
import com.proyecto.web.model.TabPerfilMenu;
import com.proyecto.web.model.TabUsuario;
import com.proyecto.web.service.MenuService;
import com.proyecto.web.service.PerfilMenuService;
import com.proyecto.web.service.UsuarioService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.primefaces.model.menu.MenuModel;

/**
 * Clase ...
 *
 * @author
 * @revision $Revision: 1.1 $
 */
@WebFilter(filterName = "protectedFilter", urlPatterns = {"/pages/secure/*"})
@ManagedBean(name = "protectedFilter")
public class ProtectedFilter implements Filter {

    @EJB
    private UsuarioService usuarioService;
    @EJB
    private PerfilMenuService rolfunService;
    @EJB
    private MenuService menuService;

    @Inject
    private MenuDM accesoMenuDM;

    MenuModel menuBar;

    /**
     * @author Paul
     * @return Genera el componente de menu
     */
//    public MenuModel getMenuBar() {
//        return null;
//        menuBar = new DefaultMenuModel();
//        if (accesoMenuDM.getMenuList() == null) {
//            return menuBar;
//        }
//        if (accesoMenuDM.getMenuList().isEmpty()) {
//            return menuBar;
//        }
//        Integer cont = 1;
//        for (TabMenu tgenmenu : accesoMenuDM.getMenuList()) {
//            DefaultSubMenu padre = new DefaultSubMenu(tgenmenu.getNombre());
//
//            padre.setId(cont.toString());
//            List<TabMenu> hijos = tgenmenu.getMenuHijos();
//            cont++;
//            for (TabMenu menu : hijos) {
//                DefaultMenuItem item = new DefaultMenuItem(menu.getNombre());
//                item.setId(cont.toString());
//                 item.setIcon("fa fa-car");
//                item.setStyle("margin-left: 20px");
//                item.setTitle(menu.getNombre());
//                cont++;
//                item.setValue(menu.getNombre());
//                item.setUrl(url() + menu.getUrl());
//
//                padre.addElement(item);
//            }
//            if (!hijos.isEmpty()) {
//                menuBar.generateUniqueIds();
//                menuBar.addElement(padre);
//            }
//        }
//        return menuBar;
//    }
    protected String url() {
        Object request = FacesContext.getCurrentInstance().getExternalContext()
                .getRequest();
        String scheme = ((ServletRequest) request).getScheme();
        String serverName = ((ServletRequest) request).getServerName();
        String puertoPath = ":" + ((ServletRequest) request).getServerPort();
        String urlPath = scheme + "://" + serverName
                + puertoPath;

        return urlPath;
    }

    /**
     *
     * @param menuBar
     */
    public void setMenuBar(final MenuModel menuBar) {
        this.menuBar = menuBar;
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    /**
     * Setea los valores de los menus para el usuario
     *
     * @param req
     * @param resp
     * @param fchain
     * @throws java.io.IOException
     * @throws javax.servlet.ServletException
     */
    @Override
    public void doFilter(final ServletRequest req, final ServletResponse resp, final FilterChain fchain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String loggedUsername = getUsername(request);
        HttpSession sesion = request.getSession();
        if (loggedUsername != null && (accesoMenuDM.getMenuList() == null || accesoMenuDM.getMenuList().isEmpty())) {
            TabUsuario buscarUsuarioUsername = new TabUsuario();
            buscarUsuarioUsername.setNombre(loggedUsername);
            buscarUsuarioUsername.setEstado(EstadoRegistroEnum.ACTIVO.getTipo());
            List< TabUsuario> usuarioEncontrado = usuarioService.buscar(buscarUsuarioUsername);
            if (!usuarioEncontrado.isEmpty()) {
                accesoMenuDM.setUsuario(usuarioEncontrado.get(0));
                request.getSession().setAttribute(accesoMenuDM.getUsuario().getNombre(), accesoMenuDM.getUsuario());

                accesoMenuDM.setNombreUsuario(loggedUsername);
                accesoMenuDM.getMenuList().clear();
                accesoMenuDM.getMenuListHijos().clear();
                accesoMenuDM.setDatosAuditoria(new DatosAuditoria(accesoMenuDM.getUsuario().getNombre(), accesoMenuDM.getUsuario().getId(), ""));

                List<TabPerfilMenu> listaMenuAsignado = rolfunService.buscar(new TabPerfilMenu(accesoMenuDM.getUsuario().getPerfil()));
                accesoMenuDM.setListaPerfilMenu(listaMenuAsignado);
                for (TabPerfilMenu listaHijo : listaMenuAsignado) {
                    accesoMenuDM.getMenuList().add(listaHijo.getMenu());
                    accesoMenuDM.getListaMenus().add(listaHijo.getMenu().getUrl());
                    metodoRecursivoMenuPadres(listaHijo.getMenu());
                }

//                List<TabMenu> listaMenuPadre = menuService.buscarMenuPadre();
//                for (TabMenu tabMenuPadre : listaMenuPadre) {
//                    TabPerfilMenu buscarFuncionalidad = new TabPerfilMenu();
//
//                    buscarFuncionalidad.setPerfil(accesoMenuDM.getUsuario().getPerfil());
//                    buscarFuncionalidad.setMenuPadre(tabMenuPadre);
//                    List<TabPerfilMenu> listaMenuHijos = rolfunService.buscar(buscarFuncionalidad);
//                    tabMenuPadre.setMenuHijos(new ArrayList<TabMenu>());
//                    for (TabPerfilMenu tabMenuHijo : listaMenuHijos) {
//
//                        tabMenuPadre.getMenuHijos().add(tabMenuHijo.getMenu());
//                        accesoMenuDM.getMenuListHijos().add(tabMenuHijo.getMenu());
//                    }
//                    accesoMenuDM.getMenuList().add(tabMenuPadre);
//                }
            }

        }
        accesoMenuDM.setRequest(request);
        accesoMenuDM.setResponse(response);
        accesoMenuDM.setSesion(sesion);
        comprobarAccesoMenu(request, response);
        fchain.doFilter(request, response);

    }

    private void comprobarAccesoMenu(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + request.getServletPath();
        String urlLocal = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
        String funcionalidad = url.substring(34, url.length());
        if (!funcionalidad.equals("/pages/secure/home.jsf")) {
            TabPerfilMenu buscarPerfilMenu = new TabPerfilMenu();
            buscarPerfilMenu.setPerfil(accesoMenuDM.getUsuario().getPerfil());
            buscarPerfilMenu.setUrl(funcionalidad);
            List<TabPerfilMenu> perfilMenuEncontrado = rolfunService.buscar(buscarPerfilMenu);
            if (perfilMenuEncontrado.isEmpty()) {
                response.sendRedirect(urlLocal + "/proyecto-web/pages/secure/home.jsf");
            } else {
                accesoMenuDM.setFuncionalidad(perfilMenuEncontrado.get(0).getMenu());
                accesoMenuDM.setOperacionesAsignadas(perfilMenuEncontrado.get(0).getOperacionesAsignadas());
                accesoMenuDM.setNombreFuncionalidad(perfilMenuEncontrado.get(0).getMenu().getPadre().getNombre() + "/" + perfilMenuEncontrado.get(0).getMenu().getNombre());
                accesoMenuDM.getDatosAuditoria().setNombrefuncionalidad(accesoMenuDM.getNombreFuncionalidad());

            }

        }

    }

    private void metodoRecursivoMenuPadres(TabMenu tabMenuHijo) {
        if (tabMenuHijo.getPadre() == null) {
            accesoMenuDM.getListaModulos().add(tabMenuHijo.getUrl());
            return;
        }

        List<TabMenu> listaMenuPadre = menuService.buscar(new TabMenu(tabMenuHijo.getPadre().getId()));
        if (!listaMenuPadre.isEmpty()) {
            accesoMenuDM.getListaModulos().add(listaMenuPadre.get(0).getUrl());
            if (listaMenuPadre.get(0).getPadre() != null) {
                metodoRecursivoMenuPadres(listaMenuPadre.get(0).getPadre());
            }
        }

    }

    @Override
    public void init(final FilterConfig arg0) throws ServletException {

    }

    /**
     * @param request
     * @return
     */
    private String getUsername(final HttpServletRequest request) {
        return request.getRemoteUser();

    }

}
