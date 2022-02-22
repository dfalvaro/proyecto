package com.proyecto.web.dao;

import com.proyecto.web.model.TabEspecialidad;
import java.util.List;
import javax.ejb.Local;

@Local
public interface IEspecialidadDao
        extends IGenericDao<TabEspecialidad, Long> {

    /**
     *
     * @param especialidad
     * @return
     */
    public List<TabEspecialidad> buscar(TabEspecialidad especialidad);


}
