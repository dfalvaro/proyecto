package com.proyecto.web.service.impl;

import com.proyecto.web.dao.PerfilMenuDao;
import com.proyecto.web.exceptions.EntidadNoBorradaException;
import com.proyecto.web.exceptions.EntidadNoEncontradaException;
import com.proyecto.web.exceptions.EntidadNoGrabadaException;
import com.proyecto.web.model.TabPerfilMenu;
import com.proyecto.web.service.AuditoriaService;
import com.proyecto.web.service.PerfilMenuService;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Clase ...
 *
 * @author 
 * @revision $Revision: $
 */
@Stateless
public class PerfilMenuServiceImpl implements PerfilMenuService {
    
    @EJB
    PerfilMenuDao perfilFuncionalidadDao;
    

    /**
     *
     * @param id
     * @return
     * @throws EntidadNoEncontradaException
     */
    @Override
    public TabPerfilMenu obtenerPorId(final Integer id)
            throws EntidadNoEncontradaException {
        return perfilFuncionalidadDao.recuperar(id.longValue());
    }

    /**
     *
     * @param perfil
     * @return
     */
    @Override
    public List<TabPerfilMenu> buscar(final TabPerfilMenu perfil) {
        List<TabPerfilMenu> listaPerfilMenuEncontrada = perfilFuncionalidadDao.buscar(perfil);
        for (TabPerfilMenu perfilMenuList : listaPerfilMenuEncontrada) {
            String[] listaOperaciones = perfilMenuList.getMenu().getOperaciones().split("-");
            perfilMenuList.setListaOperaciones(new ArrayList<String>());
            for (String operacion : listaOperaciones) {
                perfilMenuList.getListaOperaciones().add(operacion);
            }
            String[] listaOperacionesSeleccionadas = perfilMenuList.getOperacionesAsignadas().split("-");
            perfilMenuList.setOperacionesSeleccionadas(listaOperacionesSeleccionadas);
            
        }
        
        return listaPerfilMenuEncontrada;
    }

    /**
     *
     * @return
     */
    @Override
    public List<TabPerfilMenu> obtenerTodos() {
        return perfilFuncionalidadDao.obtenerTodos();
    }

    /**
     *
     * @param perfil
     * @throws EntidadNoGrabadaException
     */
    @Override
    public void guardar(final TabPerfilMenu perfil) throws EntidadNoGrabadaException {
        perfilFuncionalidadDao.crear(perfil);
        
    }

    /**
     *
     * @param perfil
     * @throws EntidadNoGrabadaException
     */
    @Override
    public void actualizar(final TabPerfilMenu perfil) throws EntidadNoGrabadaException {
        perfilFuncionalidadDao.actualizar(perfil);
        
    }
    
    @Override
    public void eliminar(TabPerfilMenu perfilFuncionalidad) throws EntidadNoBorradaException {
        TabPerfilMenu perfilFunBorrar;
        try {
            perfilFunBorrar = perfilFuncionalidadDao.recuperar(perfilFuncionalidad.getId());
            perfilFuncionalidadDao.eliminar(perfilFunBorrar);
        } catch (EntidadNoEncontradaException e) {
            e.printStackTrace();
            throw new EntidadNoBorradaException("No se encuentra el usuario");
        }
    }
    
}
