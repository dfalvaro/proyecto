package com.proyecto.web.dao;

import com.proyecto.web.model.TecnicaDetectores;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ITecnicaDetectoresDao
        extends IGenericDao<TecnicaDetectores, Long> {
/**
 * 
 * @param paramTabEntidad
 * @return 
 */
    public List<TecnicaDetectores> buscar(TecnicaDetectores paramTabEntidad);
}
