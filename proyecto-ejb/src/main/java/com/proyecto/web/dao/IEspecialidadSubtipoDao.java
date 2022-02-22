package com.proyecto.web.dao;

import com.proyecto.web.model.TabEspecialidadSubtipo;
import java.util.List;
import javax.ejb.Local;

@Local
public interface IEspecialidadSubtipoDao
        extends IGenericDao<TabEspecialidadSubtipo, Long> {

    /**
     *
     * @param espcecialidad
     * @return
     */
    public List<TabEspecialidadSubtipo> buscar(TabEspecialidadSubtipo espcecialidad);


}
