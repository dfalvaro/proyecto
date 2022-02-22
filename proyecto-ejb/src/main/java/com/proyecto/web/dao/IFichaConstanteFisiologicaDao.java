package com.proyecto.web.dao;

import com.proyecto.web.model.FichaConstanteFisiologica;
import java.util.List;
import javax.ejb.Local;

@Local
public interface IFichaConstanteFisiologicaDao
        extends IGenericDao<FichaConstanteFisiologica, Long> {
/**
 * 
 * @param paramTabEntidad
 * @return 
 */
    public List<FichaConstanteFisiologica> buscar(FichaConstanteFisiologica paramTabEntidad);
}
