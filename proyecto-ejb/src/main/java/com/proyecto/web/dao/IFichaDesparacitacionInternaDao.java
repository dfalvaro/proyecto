package com.proyecto.web.dao;

import com.proyecto.web.model.FichaDesparacitacionInterna;
import java.util.List;
import javax.ejb.Local;

@Local
public interface IFichaDesparacitacionInternaDao
        extends IGenericDao<FichaDesparacitacionInterna, Long> {
/**
 * 
 * @param paramTabEntidad
 * @return 
 */
    public List<FichaDesparacitacionInterna> buscar(FichaDesparacitacionInterna paramTabEntidad);
}
