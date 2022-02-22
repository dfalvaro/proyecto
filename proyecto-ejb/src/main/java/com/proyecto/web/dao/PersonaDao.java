package com.proyecto.web.dao;

import com.proyecto.web.model.TabPersona;
import java.util.List;
import javax.ejb.Local;

@Local
public interface PersonaDao
        extends IGenericDao<TabPersona, Long> {
/**
 * 
 * @param paramTabEntidad
 * @return 
 */
    public List<TabPersona> buscar(TabPersona paramTabEntidad);
}
