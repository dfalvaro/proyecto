package com.proyecto.web.dao;

import com.proyecto.web.model.FichaDesparacitacionExterna;
import java.util.List;
import javax.ejb.Local;

@Local
public interface IFichaDesparacitacionExternaDao
        extends IGenericDao<FichaDesparacitacionExterna, Long> {
/**
 * 
 * @param paramTabEntidad
 * @return 
 */
    public List<FichaDesparacitacionExterna> buscar(FichaDesparacitacionExterna paramTabEntidad);
}
