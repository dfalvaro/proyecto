package com.proyecto.web.service.impl;

import com.proyecto.web.dao.AuditoriaDao;
import com.proyecto.web.model.TabAuditoria;
import com.proyecto.web.service.AuditoriaService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AuditoriaServiceImpl
        implements AuditoriaService {

    @EJB
    AuditoriaDao auditoriaDao;
   

    @Override
    public List<TabAuditoria> obtenerTodos() {
        return auditoriaDao.obtenerTodos();
    }


    @Override
    public List<TabAuditoria> buscar(TabAuditoria auditoria) {
        return auditoriaDao.buscar(auditoria);
    }
}

