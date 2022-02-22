package com.proyecto.web.service.impl;

import com.proyecto.web.dao.IFichaConsultaDao;
import com.proyecto.web.exceptions.EntidadNoBorradaException;
import com.proyecto.web.exceptions.EntidadNoEncontradaException;
import com.proyecto.web.exceptions.EntidadNoGrabadaException;
import com.proyecto.web.model.FichaConsulta;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.proyecto.web.dao.PersonaDao;
import com.proyecto.web.model.FichaConstanteFisiologica;
import com.proyecto.web.model.FichaDiagnostico;
import com.proyecto.web.model.FichaEvacuaciones;
import com.proyecto.web.model.FichaFisicaVisual;
import com.proyecto.web.model.FichaMedicacionPrescrita;
import com.proyecto.web.service.IFichaConstanteFisiologicaService;
import com.proyecto.web.service.IFichaConsultaService;
import com.proyecto.web.service.IFichaDiagnosticoService;
import com.proyecto.web.service.IFichaEvacuacionesService;
import com.proyecto.web.service.IFichaFisicaVisualService;
import com.proyecto.web.service.IFichaMedicacionPrescritaService;
import com.proyecto.web.service.PersonaService;

@Stateless
public class FichaConsultaServiceImpl
        implements IFichaConsultaService {

    @EJB
    IFichaConsultaDao consultaDao;
    @EJB
    IFichaConstanteFisiologicaService constanteFisiologicaService;
    @EJB
    IFichaFisicaVisualService fisicaVisualService;
    @EJB
    IFichaEvacuacionesService evacuacionesService;
    @EJB
    IFichaDiagnosticoService diagnosticoService;
    @EJB
    IFichaMedicacionPrescritaService medicacionPrescritaService;

    @Override
    public FichaConsulta obtenerPorId(Long id)
            throws EntidadNoEncontradaException {
        return consultaDao.recuperar(id);
    }

    @Override
    public List<FichaConsulta> buscar(FichaConsulta persona) {
        return consultaDao.buscar(persona);
    }

    @Override
    public List<FichaConsulta> obtenerTodos() {
        return consultaDao.obtenerTodos();
    }

    @Override
    public void guardar(FichaConsulta persona)
            throws EntidadNoGrabadaException {
        if (persona.getId() == null) {
            consultaDao.crear(persona);
        } else {
            consultaDao.actualizar(persona);
        }
    }

    @Override
    public void actualizar(FichaConsulta persona)
            throws EntidadNoGrabadaException {
        consultaDao.actualizar(persona);

    }

    /**
     *
     * @param persona
     * @throws EntidadNoBorradaException
     * @throws com.proyecto.web.exceptions.EntidadNoEncontradaException
     */
    @Override
    public void eliminar(FichaConsulta persona)
            throws EntidadNoBorradaException, EntidadNoEncontradaException {

        FichaConsulta personaBorrar = (FichaConsulta) consultaDao.recuperar(persona.getId());
        consultaDao.eliminar(personaBorrar);

    }

    @Override
    public void guardarHistoria(FichaConsulta consulta, FichaConstanteFisiologica constanteFisiologica, FichaFisicaVisual fichaFisicaVisual ,FichaEvacuaciones evacuaciones, FichaDiagnostico diagnostico, FichaMedicacionPrescrita medicacionPrescrita) throws EntidadNoGrabadaException {
        guardar(consulta);
        constanteFisiologica.setConsulta(consulta);
        fichaFisicaVisual.setConsulta(consulta);
        evacuaciones.setConsulta(consulta);
        diagnostico.setConsulta(consulta);
        medicacionPrescrita.setConsulta(consulta);
        constanteFisiologicaService.guardar(constanteFisiologica);
        fisicaVisualService.guardar(fichaFisicaVisual);
        evacuacionesService.guardar(evacuaciones);
        diagnosticoService.guardar(diagnostico);
        medicacionPrescritaService.guardar(medicacionPrescrita);
        
    }
}
