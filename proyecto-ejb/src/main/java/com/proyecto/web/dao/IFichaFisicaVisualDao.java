package com.proyecto.web.dao;

import com.proyecto.web.model.FichaFisicaVisual;
import java.util.List;
import javax.ejb.Local;

@Local
public interface IFichaFisicaVisualDao
        extends IGenericDao<FichaFisicaVisual, Long> {
/**
 * 
 * @param paramTabEntidad
 * @return 
 */
    public List<FichaFisicaVisual> buscar(FichaFisicaVisual paramTabEntidad);
}
