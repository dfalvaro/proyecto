package com.proyecto.web.dao;

import com.proyecto.web.model.TabCan;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ICanDao
        extends IGenericDao<TabCan, Long> {

    /**
     *
     * @param persona
     * @return
     */
    public List<TabCan> buscar(TabCan persona);

    public List<TabCan> redimencionarImagen();

    public Long obtenerSecuencialFinal();

}
