package com.proyecto.web.dao;

import com.proyecto.web.model.FichaEvacuaciones;
import java.util.List;
import javax.ejb.Local;

@Local
public interface IFichaEvacuacionesDao
        extends IGenericDao<FichaEvacuaciones, Long> {
/**
 * 
 * @param paramTabEntidad
 * @return 
 */
    public List<FichaEvacuaciones> buscar(FichaEvacuaciones paramTabEntidad);
}
