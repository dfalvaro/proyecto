package com.proyecto.web.dao;

import com.proyecto.web.model.TecnicaExamen;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ITecnicaExamenDao
        extends IGenericDao<TecnicaExamen, Long> {

    /**
     *
     * @param paramTabEntidad
     * @return
     */
    public List<TecnicaExamen> buscar(TecnicaExamen paramTabEntidad);
}
