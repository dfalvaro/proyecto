package com.proyecto.web.dao;

import com.proyecto.web.model.FichaConsulta;
import java.util.List;
import javax.ejb.Local;

@Local
public interface IFichaConsultaDao
        extends IGenericDao<FichaConsulta, Long> {
/**
 * 
 * @param paramTabEntidad
 * @return 
 */
    public List<FichaConsulta> buscar(FichaConsulta paramTabEntidad);
}
