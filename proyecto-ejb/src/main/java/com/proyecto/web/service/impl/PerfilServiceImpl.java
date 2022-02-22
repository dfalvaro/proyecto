package com.proyecto.web.service.impl;

import com.proyecto.web.dao.PerfilDao;
import com.proyecto.web.dao.PerfilMenuDao;
import com.proyecto.web.dao.UsuarioDao;
import com.proyecto.web.enumeration.EstadoRegistroEnum;
import com.proyecto.web.exceptions.EntidadNoBorradaException;
import com.proyecto.web.exceptions.EntidadNoEncontradaException;
import com.proyecto.web.exceptions.EntidadNoGrabadaException;
import com.proyecto.web.model.TabPerfil;
import com.proyecto.web.model.TabPerfilMenu;
import com.proyecto.web.model.TabUsuario;
import com.proyecto.web.service.PerfilService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class PerfilServiceImpl
        implements PerfilService {

    @EJB
    PerfilDao perfilesDao;
    @EJB
    UsuarioDao usuarioDao;
    @EJB
    PerfilMenuDao perfilFunDao;

    @Override
    public TabPerfil obtenerPorId(Long id)
            throws EntidadNoEncontradaException {
        return perfilesDao.recuperar(id);
    }

    @Override
    public List<TabPerfil> buscar(TabPerfil perfil) {
        return perfilesDao.buscar(perfil);
    }

    @Override
    public List<TabPerfil> obtenerTodos() {
        return perfilesDao.obtenerTodos();
    }

    @Override
    public void creacionPerfil(TabPerfil perfil, List<TabPerfilMenu> listMenuCreacion, List<TabPerfilMenu> listMenuEliminacion)
            throws EntidadNoBorradaException, EntidadNoGrabadaException, EntidadNoEncontradaException {
        validacionGeneral(perfil, listMenuCreacion);
        if (perfil.getId() == null) {
            perfilesDao.crear(perfil);
        } else {
            perfilesDao.actualizar(perfil);
     
        }
        for (TabPerfilMenu listaEliminacion : listMenuEliminacion) {
            TabPerfilMenu perfilFunEliminar = perfilFunDao.recuperar(listaEliminacion.getId());
            perfilFunDao.eliminar(perfilFunEliminar);
        }
        for (TabPerfilMenu listaCreacion : listMenuCreacion) {
            listaCreacion.setPerfil(perfil);
            listaCreacion.setOperacionesAsignadas("");
            for (String operacionesSeleccionada : listaCreacion.getOperacionesSeleccionadas()) {
                listaCreacion.setOperacionesAsignadas(listaCreacion.getOperacionesAsignadas() + "" + operacionesSeleccionada + "-");
            }
            if (listaCreacion.getId() == null) {
                perfilFunDao.crear(listaCreacion);
            } else {
                perfilFunDao.actualizar(listaCreacion);
            }

        }

    }

    private void validacionGeneral(TabPerfil perfil, List<TabPerfilMenu> listMenuCreacion) throws EntidadNoGrabadaException {
        if (listMenuCreacion.isEmpty()) {
            throw new EntidadNoGrabadaException("Es necesario agregar funcionalidades");
        }
        if (perfil.getEstado().equals(EstadoRegistroEnum.INACTIVO.getTipo())) {
            TabUsuario buscarRolUsuario = new TabUsuario();
            buscarRolUsuario.setPerfil(perfil);
            List<TabUsuario> usuarioEncontrado = usuarioDao.buscar(buscarRolUsuario);
            if (!usuarioEncontrado.isEmpty()) {
                throw new EntidadNoGrabadaException("El perfil no se puede inactivar, esta siendo utilizado en otro proceso");

            }
        }

        if (!perfil.getNombreEdicion().equals(perfil.getNombre())) {
            TabPerfil buscarRol = new TabPerfil();
            buscarRol.setNombre(perfil.getNombre());
            List<TabPerfil> perfilEncontrado = perfilesDao.buscar(buscarRol);
            if (!perfilEncontrado.isEmpty()) {
                throw new EntidadNoGrabadaException("Nombre de perfil existente");
            }
        }
    }

    @Override
    public void actualizar(TabPerfil perfil)
            throws EntidadNoGrabadaException {
        perfilesDao.actualizar(perfil);
    }

    @Override
    public void eliminar(TabPerfil perfil)
            throws EntidadNoBorradaException {
        try {
            TabPerfil perfilBorrar = (TabPerfil) perfilesDao.recuperar(perfil.getId());
            perfilBorrar.getListaUsuarios().size();
            if ((!perfilBorrar.getListaUsuarios().isEmpty())
                    && (perfilBorrar.getListaUsuarios() != null)) {
                throw new EntidadNoBorradaException("tiene relacionado un registro ");
            }

            perfilesDao.eliminar(perfilBorrar);
        } catch (EntidadNoEncontradaException e) {
            e.printStackTrace();
            throw new EntidadNoBorradaException("No se encuentra el usuario");
        }

    }

    @Override
    public void eliminarPerfilFuncionalidad(TabPerfil perfil)
            throws EntidadNoBorradaException,EntidadNoEncontradaException {
       
            TabPerfil perfilBorrar = (TabPerfil) perfilesDao.recuperar(perfil.getId());
            perfilBorrar.getListaUsuarios().size();
            if ((!perfilBorrar.getListaUsuarios().isEmpty())
                    && (perfilBorrar.getListaUsuarios() != null)) {
                throw new EntidadNoBorradaException("tiene relacionado un registro ");
            }

            TabPerfilMenu buscarRolFun = new TabPerfilMenu();
            buscarRolFun.setPerfil(perfilBorrar);
            List<TabPerfilMenu> listaRolMenu = perfilFunDao.buscar(buscarRolFun);
            for (TabPerfilMenu listaEliminacion : listaRolMenu) {
                perfilFunDao.eliminar(listaEliminacion);
            }
            perfilesDao.eliminar(perfilBorrar);
      
    }
}
