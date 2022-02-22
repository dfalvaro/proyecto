package com.proyecto.web.dao;

import com.proyecto.web.model.TabUsuario;
import java.util.List;
import javax.ejb.Local;

@Local
public interface UsuarioDao
        extends IGenericDao<TabUsuario, Long> {

    /**
     *
     * @param paramTabUsuario
     * @return
     */
    public List<TabUsuario> buscar(TabUsuario paramTabUsuario);

}
