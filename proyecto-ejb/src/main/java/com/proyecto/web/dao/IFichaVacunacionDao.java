package com.proyecto.web.dao;

import com.proyecto.web.model.FichaVacunacion;
import java.util.List;
import javax.ejb.Local;

@Local
public interface IFichaVacunacionDao
        extends IGenericDao<FichaVacunacion, Long> {
/**
 * 
 * @param paramTabEntidad
 * @return 
 */
    public List<FichaVacunacion> buscar(FichaVacunacion paramTabEntidad);
}
