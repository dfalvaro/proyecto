package com.proyecto.web.dao;

import com.proyecto.web.model.FichaDiagnostico;
import java.util.List;
import javax.ejb.Local;

@Local
public interface IFichaDiagnosticoDao
        extends IGenericDao<FichaDiagnostico, Long> {
/**
 * 
 * @param paramTabEntidad
 * @return 
 */
    public List<FichaDiagnostico> buscar(FichaDiagnostico paramTabEntidad);
}
