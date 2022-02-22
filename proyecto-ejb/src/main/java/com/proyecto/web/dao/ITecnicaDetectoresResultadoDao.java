package com.proyecto.web.dao;

import com.proyecto.web.model.TecnicaDetectoresResultado;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ITecnicaDetectoresResultadoDao
        extends IGenericDao<TecnicaDetectoresResultado, Long> {

    /**
     *
     * @param paramTabEntidad
     * @return
     */
    public List<TecnicaDetectoresResultado> buscar(TecnicaDetectoresResultado paramTabEntidad);
}
