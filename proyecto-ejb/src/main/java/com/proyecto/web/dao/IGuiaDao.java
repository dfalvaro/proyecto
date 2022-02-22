package com.proyecto.web.dao;

import com.proyecto.web.model.TabGuia;
import java.util.List;
import javax.ejb.Local;

@Local
public interface IGuiaDao
        extends IGenericDao<TabGuia, Long> {

    /**
     *
     * @param persona
     * @return
     */
    public List<TabGuia> buscar(TabGuia persona);

    public List<TabGuia> redimencionarImagen();

}
