package com.proyecto.web.service.impl;

import com.proyecto.web.dao.MenuDao;
import com.proyecto.web.dao.PerfilMenuDao;
import com.proyecto.web.exceptions.EntidadNoEncontradaException;
import com.proyecto.web.model.TabMenu;
import com.proyecto.web.service.AuditoriaService;
import com.proyecto.web.service.MenuService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class MenuServiceImpl
        implements MenuService {

    @EJB
    MenuDao funcionalidadRolDao;
    @EJB
    PerfilMenuDao rolFunDao;


    @Override
    public List<TabMenu> buscar(TabMenu funcionalidad) {
        return funcionalidadRolDao.buscar(funcionalidad);
    }
    
      @Override
    public List<TabMenu> buscarMenuHijos() {
        return funcionalidadRolDao.buscarMenuHijos();
    }

    
       @Override
    public List<TabMenu> buscarMenuPadre() {
        return funcionalidadRolDao.buscarMenuPadre();
    }

    
    
    @Override
    public List<TabMenu> obtenerTodos() {
        return funcionalidadRolDao.obtenerTodos();
    }

    @Override
    public TabMenu obtenerPorId(Long funcionalidad)
            throws EntidadNoEncontradaException {
        return funcionalidadRolDao.recuperar(funcionalidad);
    }
}
