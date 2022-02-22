package com.proyecto.web.dao;

import com.proyecto.web.model.TabAnimal;
import java.util.List;
import javax.ejb.Local;

@Local
public interface IAnimalDao
        extends IGenericDao<TabAnimal, Long> {

    /**
     *
     * @param animal
     * @return
     */
    public List<TabAnimal> buscar(TabAnimal animal);
    
        public List<TabAnimal> redimencionarImagen();
    
}
