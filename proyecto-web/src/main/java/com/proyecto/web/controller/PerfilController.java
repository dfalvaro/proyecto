package com.proyecto.web.controller;

import com.proyecto.web.dataManager.PerfilDM;
import com.proyecto.web.enumeration.EstadoRegistroEnum;
import com.proyecto.web.exceptions.EntidadNoBorradaException;
import com.proyecto.web.exceptions.EntidadNoEncontradaException;
import com.proyecto.web.exceptions.EntidadNoGrabadaException;
import com.proyecto.web.model.TabMenu;
import com.proyecto.web.model.TabPerfil;
import com.proyecto.web.model.TabPerfilMenu;
import com.proyecto.web.service.MenuService;
import com.proyecto.web.service.PerfilMenuService;
import com.proyecto.web.service.PerfilService;
import com.proyecto.web.service.UsuarioService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@ManagedBean(name = "perfilController")
@ViewScoped
public class PerfilController
        extends BaseController {

    @ManagedProperty("#{perfilDM}")
    public PerfilDM perfilDM;
    @EJB
    UsuarioService usuarioService;
    @EJB
    private PerfilMenuService perfilfunService;
    @EJB
    private MenuService funcionalidadService;
    @EJB
    PerfilService perfilService;

   
   
   
    public void initForm() {
        perfilDM.setPerfilList(perfilService.buscar(new TabPerfil(accesoMenuDM.getDatosAuditoria())));
        perfilDM.setShowPanelCrudPerfil(Boolean.FALSE);
        perfilDM.setShowPanelTablaPerfil(Boolean.TRUE);
    }
    
     
    

    public void nuevo()
            throws EntidadNoEncontradaException {
        perfilDM.setPerfil(new TabPerfil(accesoMenuDM.getDatosAuditoria()));
        perfilDM.getPerfil().setNombreEdicion("");
        perfilDM.getPerfil().setEstado(EstadoRegistroEnum.ACTIVO.getTipo());
        perfilDM.getListaMenuPerfilCreacion().clear();
        perfilDM.getListaMenuPerfilEliminacion().clear();
        perfilDM.setShowPanelCrudPerfil(Boolean.TRUE);
        perfilDM.setShowPanelTablaPerfil(Boolean.FALSE);
    }

    public void eliminar() {
        try {
            TabPerfil perfiles = perfilDM.getPerfil();
            perfilService.eliminarPerfilFuncionalidad(perfiles);
            addInfoMessage("Rol eliminado exitosamente");
            initForm();
        } catch (EntidadNoBorradaException e) {
            addErrorMessage(e.getMessage());
        } catch (EntidadNoEncontradaException ex) {
            Logger.getLogger(PerfilController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void seleccionarEdicion(TabPerfil perfil) {
        seleccionarPerfil(perfil);
        perfilDM.setShowPanelCrudPerfil(Boolean.TRUE);
        perfilDM.setShowPanelTablaPerfil(Boolean.FALSE);

    }
    
     public void seleccionarPerfil(TabPerfil perfil) {
        perfilDM.getListaMenuPerfilCreacion().clear();
        perfilDM.getListaMenuPerfilEliminacion().clear();
        perfilDM.setPerfil(perfil);
        perfilDM.getPerfil().setNombreEdicion(perfil.getNombre());
        TabPerfilMenu buscarFuncionalidad = new TabPerfilMenu(accesoMenuDM.getDatosAuditoria());
        buscarFuncionalidad.setPerfil(perfil);
        perfilDM.setListaMenuPerfilCreacion(perfilfunService.buscar(buscarFuncionalidad));
 
    }

    public void guardar() {
        try {
            perfilDM.getPerfil().setNombre(perfilDM.getPerfil().getNombre().toUpperCase());
            perfilDM.getPerfil().setDescripcion(perfilDM.getPerfil().getDescripcion().toUpperCase());
            perfilService.creacionPerfil(perfilDM.getPerfil(), perfilDM.getListaMenuPerfilCreacion(), perfilDM.getListaMenuPerfilEliminacion());
            addInfoMessage("Registro Correctamente");
               initForm();
        } catch (EntidadNoBorradaException | EntidadNoGrabadaException | EntidadNoEncontradaException ex) {
            addErrorMessage(ex.getMessage());
        }
     

    }

    public void cancelar() {
        initForm();
    }

    public void seleccionarFuncionalidades() {
        Integer cont = 0;
        for (TabMenu listaFuncionalidadesSeleccionadas : perfilDM.getListaFuncionalidadesSeleccionaldas()) {
            for (TabPerfilMenu listaFuncionalidades : perfilDM.getListaMenuPerfilCreacion()) {
                if (listaFuncionalidadesSeleccionadas.getId().equals(listaFuncionalidades.getMenu().getId())) {

                    addErrorMessage("Menú " + listaFuncionalidades.getMenu().getNombre() + " ya seleccionado para este perfil");
                    cont++;
                    break;
                }
            }
        }
        if (cont == 0) {
            for (TabMenu listaFuncionalidadesSeleccionadas : perfilDM.getListaFuncionalidadesSeleccionaldas()) {
                TabPerfilMenu nuevoPerfilFuncionalidad = new TabPerfilMenu(accesoMenuDM.getDatosAuditoria());
                nuevoPerfilFuncionalidad.setMenu(listaFuncionalidadesSeleccionadas);
                String[] listaOperaciones = listaFuncionalidadesSeleccionadas.getOperaciones().split("-");
                nuevoPerfilFuncionalidad.setListaOperaciones(new ArrayList<String>());
                nuevoPerfilFuncionalidad.getListaOperaciones().addAll(Arrays.asList(listaOperaciones));
                nuevoPerfilFuncionalidad.setOperacionesSeleccionadas(listaOperaciones);
  
                perfilDM.getListaMenuPerfilCreacion().add(nuevoPerfilFuncionalidad);
            }

        }
    }

    public void eliminarFuncionalidaes(TabPerfilMenu perfilMenu) {
        perfilDM.getListaMenuPerfilCreacion().remove(perfilMenu);
        if (perfilMenu.getId() != null) {
            perfilDM.getListaMenuPerfilEliminacion().add(perfilMenu);

        }

    }

    public void listaMenu() {

        perfilDM.setListaFuncionalidades(funcionalidadService.buscarMenuHijos());
        perfilDM.setListaFuncionalidadesSeleccionaldas(new ArrayList());
    }

    public PerfilDM getPerfilDM() {
        return perfilDM;
    }

    public void setPerfilDM(PerfilDM perfilDM) {
        this.perfilDM = perfilDM;
    }

}
