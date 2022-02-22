package com.proyecto.web.service.impl;

import com.proyecto.web.exceptions.EntidadNoBorradaException;
import com.proyecto.web.exceptions.EntidadNoEncontradaException;
import com.proyecto.web.exceptions.EntidadNoGrabadaException;
import com.proyecto.web.model.TabPersona;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.proyecto.web.dao.PersonaDao;
import com.proyecto.web.service.PersonaService;

@Stateless
public class PersonaServiceImpl
        implements PersonaService {

    @EJB
    PersonaDao personaDao;
 

    @Override
    public TabPersona obtenerPorId(Long id)
            throws EntidadNoEncontradaException {
        return personaDao.recuperar(id);
    }

    @Override
    public List<TabPersona> buscar(TabPersona persona) {
        return personaDao.buscar(persona);
    }

    @Override
    public List<TabPersona> obtenerTodos() {
        return personaDao.obtenerTodos();
    }

    @Override
    public void guardar(TabPersona persona)
            throws EntidadNoGrabadaException {
        personaDao.crear(persona);
    }
    
    
     @Override
    public void guardarPersonas(TabPersona persona)
            throws EntidadNoGrabadaException {
         if (persona.getId()==null) {
                personaDao.crear(persona); 
         }else{
             personaDao.actualizar(persona);
         }
    
    }
    

    @Override
    public void actualizar(TabPersona persona)
            throws EntidadNoGrabadaException {
        personaDao.actualizar(persona);

    }

    /**
     *
     * @param persona
     * @throws EntidadNoBorradaException
     * @throws com.proyecto.web.exceptions.EntidadNoEncontradaException
     */
    @Override
    public void eliminar(TabPersona persona)
            throws EntidadNoBorradaException,EntidadNoEncontradaException {
      
            TabPersona personaBorrar = (TabPersona) personaDao.recuperar(persona.getId());
            personaDao.eliminar(personaBorrar);
       
    }
}
