package com.proyecto.web.dao;

import com.proyecto.web.model.FichaMedicacionPrescrita;
import java.util.List;
import javax.ejb.Local;

@Local
public interface IFichaMedicacionPrescritaDao
        extends IGenericDao<FichaMedicacionPrescrita, Long> {
/**
 * 
 * @param paramTabEntidad
 * @return 
 */
    public List<FichaMedicacionPrescrita> buscar(FichaMedicacionPrescrita paramTabEntidad);
}
