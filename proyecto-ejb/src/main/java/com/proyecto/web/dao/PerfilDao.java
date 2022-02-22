package com.proyecto.web.dao;

import com.proyecto.web.model.TabPerfil;
import java.util.List;
import javax.ejb.Local;

@Local
public interface PerfilDao
        extends IGenericDao<TabPerfil, Long> {

    /**
     *
     * @param paramTabPerfil
     * @return
     */
    public List<TabPerfil> buscar(TabPerfil paramTabPerfil);
}
