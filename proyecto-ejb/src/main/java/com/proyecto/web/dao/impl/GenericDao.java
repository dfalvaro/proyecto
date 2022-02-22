package com.proyecto.web.dao.impl;

import com.proyecto.web.dao.IGenericDao;
import com.proyecto.web.enumeration.OperacionesAuditoriaEnum;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

import com.proyecto.web.exceptions.EntidadNoBorradaException;
import com.proyecto.web.exceptions.EntidadNoEncontradaException;
import com.proyecto.web.exceptions.EntidadNoGrabadaException;
import com.proyecto.web.model.TabAuditoria;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.persistence.EntityExistsException;
import javax.servlet.http.HttpServletRequest;

/**
 * Class GenericDao.
 *
 * @param <T> the generic type
 * @param <PK> the generic id type
 * @revision $Revision: 1.1 $$
 */
@SuppressWarnings("unchecked")
public class GenericDao<T, PK extends Serializable> implements
        IGenericDao<T, PK> {

    private String valorAnteriorAuditoria = "";
    private String valorActualAuditoria = "";
    private Object idAnteriorAuditoria = null;
    private String usuario = "";
    private String funcionalidad = "";

    @PersistenceContext(unitName = "laboratorioDS")
    protected EntityManager em;

    private final Class<T> type;

    /**
     * Instancia un nuevo generic dao.
     *
     * @param type the type
     */
    public GenericDao(final Class<T> type) {
        this.type = type;
    }

    /**
     * @throws com.wanqara.seguridad.web.exceptions.EntidadNoGrabadaException
     */
    @Override
    public void crear(final T o) throws EntidadNoGrabadaException {
        try {
            em.persist(o);
            auditoriaValorActual(o);

            auditoriaCreacion();
        } catch (final PersistenceException e) {
            throw new EntidadNoGrabadaException("Error al grabar: ".concat(o
                    .toString()), e);
        } catch (IllegalArgumentException ex) {
            throw new EntityExistsException(ex.getMessage());
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchFieldException ex) {
            Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @throws com.wanqara.seguridad.web.exceptions.EntidadNoEncontradaException
     */
    @Override
    public T recuperar(final PK id) throws EntidadNoEncontradaException {

        final T entidad = em.find(type, id);

        if (entidad == null) {
            final StringBuffer msg = new StringBuffer();
            msg.append(type.getSimpleName());
            msg.append('[');
            msg.append(id.toString());
            msg.append("] no encontrada.");
            throw new EntidadNoEncontradaException(msg.toString());
        }

        return entidad;
    }

    /**
     * @throws com.wanqara.seguridad.web.exceptions.EntidadNoGrabadaException
     */
    @Override
    public void actualizar(final T o) throws EntidadNoGrabadaException {

        try {
            auditoriaValorActual(o);
            auditoriaValorAnterior();
            em.merge(o);
            auditoriaModificacion();
        } catch (IllegalArgumentException ex) {
            throw new EntityExistsException(ex.getMessage());
        } catch (IllegalAccessException | ParseException | NoSuchMethodException | InvocationTargetException | NoSuchFieldException ex) {
            Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @throws com.wanqara.seguridad.web.exceptions.EntidadNoBorradaException
     */
    @Override
    public void eliminar(final T o) throws EntidadNoBorradaException {

        try {
            auditoriaValorActual(o);
            em.merge(o);
            em.remove(o);
            auditoriaEliminacion();
        } catch (IllegalArgumentException ex) {
            throw new EntityExistsException(ex.getMessage());
        } catch (IllegalAccessException | ParseException | NoSuchMethodException | InvocationTargetException | NoSuchFieldException ex) {
            Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void auditoriaValorAnterior() throws IllegalArgumentException, IllegalAccessException, ParseException, NoSuchMethodException, InvocationTargetException {
        T claseRecuperada = em.find(type, this.getIdAnteriorAuditoria());
        if (claseRecuperada != null) {
            Class claseAnterior = claseRecuperada.getClass();
            Method metodo = claseAnterior.getMethod("toString", null);
            metodo.setAccessible(true);
            Object toStringAnterior = metodo.invoke(claseRecuperada, null);

            this.setValorAnteriorAuditoria(toStringAnterior.toString());
        }
    }

    private void auditoriaValorActual(final T o) throws IllegalArgumentException, IllegalAccessException, ParseException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {

        Class claseActual = o.getClass();
        Field[] atributosActual = claseActual.getDeclaredFields();

        Method metodo = claseActual.getMethod("toString", null);
        metodo.setAccessible(true);
        Object toStringActual = metodo.invoke(o, null);

        for (Field fielActual : atributosActual) {

            Annotation[] anotaciones = fielActual.getDeclaredAnnotations();
            fielActual.setAccessible(true);

            if (fielActual.getName().equals("datosAuditoria")) {
                if (fielActual.get(o) != null) {
                    Class userClass = fielActual.get(o).getClass();
                    Field[] atributosAuditoria = userClass.getDeclaredFields();
                    for (Field fielAuditoria : atributosAuditoria) {
                        fielAuditoria.setAccessible(true);
                        if (fielAuditoria.getName().equals("nombreUsuario")) {
                            usuario = fielAuditoria.get(fielActual.get(o)).toString();
                        }
                        
                        if (fielAuditoria.getName().equals("nombrefuncionalidad")) {
                            funcionalidad = fielAuditoria.get(fielActual.get(o)).toString();
                        }
                    }
                }
            }

            for (Annotation anotacion : anotaciones) {
                if (anotacion.toString().equals("@javax.persistence.Id()")) {
                    String stringActual = toStringActual.toString();
                    this.setValorActualAuditoria(stringActual);
                    this.setIdAnteriorAuditoria(fielActual.get(o));
                    break;
                }

            }
        }

    }

    private void auditoriaModificacion() {

        List<String> valorAnterior = new LinkedList<>(Arrays.asList(this.getValorAnteriorAuditoria().split(",")));
        List<String> campoModificado = new LinkedList<>(Arrays.asList(this.getValorAnteriorAuditoria().split(",")));
        List<String> valorActual = new LinkedList<>(Arrays.asList(this.getValorActualAuditoria().split(",")));
        campoModificado.removeAll(valorActual);

        if (!campoModificado.isEmpty()) {
            TabAuditoria auditoria = new TabAuditoria();
            auditoria.setFecha(new Date());
            auditoria.setOperacion(OperacionesAuditoriaEnum.ACTUALIZAR.name());
            auditoria.setUsuario(usuario);
            auditoria.setFuncionalidad(funcionalidad);
            auditoria.setValorAnterior(valorAnterior.toString());
            auditoria.setValorActual(valorActual.toString());
            auditoria.setCampoAfectado(campoModificado.toString());
            em.persist(auditoria);
        }

    }

    private void auditoriaCreacion() {

        List<String> valorActual = new LinkedList<>(Arrays.asList(this.getValorActualAuditoria().split(",")));

        TabAuditoria auditoria = new TabAuditoria();
        auditoria.setFecha(new Date());
        auditoria.setOperacion(OperacionesAuditoriaEnum.CREAR.name());
        auditoria.setUsuario(usuario);
        auditoria.setFuncionalidad(funcionalidad);
        auditoria.setValorAnterior(null);
        auditoria.setValorActual(valorActual.toString());
        auditoria.setCampoAfectado(null);
        em.persist(auditoria);

    }

    private void auditoriaEliminacion() {

        List<String> valorAnterior = new LinkedList<>(Arrays.asList(this.getValorActualAuditoria().split(",")));

        TabAuditoria auditoria = new TabAuditoria();
        auditoria.setFecha(new Date());
        auditoria.setOperacion(OperacionesAuditoriaEnum.ELIMINAR.name());
        auditoria.setUsuario(usuario);
        auditoria.setFuncionalidad(funcionalidad);
        auditoria.setValorAnterior(valorAnterior.toString());
        auditoria.setValorActual(null);
        auditoria.setCampoAfectado(null);
        em.persist(auditoria);

    }

    public String getValorAnteriorAuditoria() {
        return valorAnteriorAuditoria;
    }

    public void setValorAnteriorAuditoria(String valorAnteriorAuditoria) {
        this.valorAnteriorAuditoria = valorAnteriorAuditoria;
    }

    public String getValorActualAuditoria() {
        return valorActualAuditoria;
    }

    public void setValorActualAuditoria(String valorActualAuditoria) {
        this.valorActualAuditoria = valorActualAuditoria;
    }

    public Object getIdAnteriorAuditoria() {
        return idAnteriorAuditoria;
    }

    public void setIdAnteriorAuditoria(Object idAnteriorAuditoria) {
        this.idAnteriorAuditoria = idAnteriorAuditoria;
    }

    @Override
    public void refrescar(T o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<T> obtenerTodos() {
        final String className = type.getSimpleName();
        final StringBuffer sql = new StringBuffer();
        sql.append("from ").append(className);
        final Query query = em.createQuery(sql.toString());
        return query.getResultList();
    }

    @Override
    public Long contar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<T> encontrarPagina(Integer firstRow, Integer maxResults, String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<T> encontrarPorCriterios(List<Criterion> criterios) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<T> encontrarPorCriterios(List<Criterion> criterios, List<Order> orderFields) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<T> encontrarPorCriterios(List<Criterion> criterios, Order orderField) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<T> encontrarPorQuery(String sql, Map<String, Object> parametros) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer contarPorCriterios(List<Criterion> criterios) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<T> selectNativeQuery(String statement, Object[] parameters) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<T> selectNamedQuery(String namedQuery, Map<String, Object> parameters) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object selectNamedQuerySingle(String namedQuery, Map<String, Object> parameters) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
