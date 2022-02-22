
package com.proyecto.web.dao;

import com.proyecto.web.exceptions.EntidadNoBorradaException;
import com.proyecto.web.exceptions.EntidadNoEncontradaException;
import com.proyecto.web.exceptions.EntidadNoGrabadaException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

/**
 * Interface IGenericDao.
 *
 * @param <T> the generic type
 * @param <PK> the generic id type
 * @author Eduardo Proano
 * @revision $Revision: 1.1 $$
 */
public interface IGenericDao<T, PK extends Serializable> {

    /**
     * Guardar un objeto en la base de datos.
     *
     * @param o the o
     *
     * @throws EntidadNoGrabadaException the entidad no grabada exception
     */
    void crear(T o) throws EntidadNoGrabadaException;

    /**
     * Obtener un objeto almacenado utilizando su llave primaria.
     *
     * @param id llave primaria.
     *
     * @return the T
     *
     * @throws EntidadNoEncontradaException the entidad no encontrada exception
     */
    T recuperar(PK id) throws EntidadNoEncontradaException;

    /**
     * Almacenar los cambios hechos a un objeto.
     *
     * @param o the o
     *
     * @throws EntidadNoGrabadaException the entidad no grabada exception
     */
    void actualizar(T o) throws EntidadNoGrabadaException;

    /**
     * Eliminar un objeto de la base de datos.
     *
     * @param o the o
     *
     * @throws EntidadNoBorradaException the entidad no borrada exception
     */
    void eliminar(T o) throws EntidadNoBorradaException;

    /**
     * Refresca un objeto de la base de datos.
     *
     * @param o the o
     */
    void refrescar(T o);

    /**
     * Obtiene todas las entidades.
     *
     * @return the list< t>
     */
    List<T> obtenerTodos();

    /**
     * Contar todas las entidades.
     *
     * @return the long
     */
    Long contar();

    /**
     * Encuentra una pagina de datos en la base.
     *
     * @param firstRow the first row
     * @param maxResults the max results
     * @param id
     *
     * @return the list< t>
     */
    List<T> encontrarPagina(final Integer firstRow, final Integer maxResults,
            final String id);

    /**
     * Busca por una lista de criterios.
     *
     * @param criterios the criterios
     *
     * @return the list< t>
     */
    List<T> encontrarPorCriterios(List<Criterion> criterios);

    /**
     * Busca por una lista de criterios ordenado de acuerdo a la lista recibida.
     *
     * @param criterios the criterios
     * @param orderFields the order fields
     *
     * @return the list< t>
     */
    List<T> encontrarPorCriterios(List<Criterion> criterios,
            List<Order> orderFields);

    /**
     * Busca por una lista de criterios y en un orden determinado.
     *
     * @param criterios the criterios
     * @param orderField the order field
     *
     * @return the list< t>
     */
    List<T> encontrarPorCriterios(List<Criterion> criterios, Order orderField);

    /**
     * Busca de acuerdo a una consulta y lista de parametros.
     *
     * @param sql the sql
     * @param parametros the parametros
     *
     * @return the list< t>
     */
    List<T> encontrarPorQuery(String sql, Map<String, Object> parametros);

    /**
     * Cuenta el numero de registros de acuerdo a los criterios recibidos.
     *
     * @param criterios the criterios
     *
     * @return the integer
     */
    Integer contarPorCriterios(List<Criterion> criterios);

    /**
     * Select native query.
     *
     * @param statement Consulta en lenguaje SQL
     * @param parameters Arreglo de parametros para la consulta
     *
     * @return Collection<T> Coleccion de Objectos encontrados
     *
     * Metodo para realizar consultas con lenguaje SQL
     */
    List<T> selectNativeQuery(String statement, Object[] parameters);

    /**
     * Select named query.
     *
     * @param namedQuery Nombre de la consulta
     * @param parameters Arreglo de parametros para la consulta
     *
     * @return Collection<T> Coleccion de Objectos encontrados
     *
     * Metodo para realizar consultas con lenguaje SQL
     */
    List<T> selectNamedQuery(String namedQuery, Map<String, Object> parameters);
    /**
     * 
     * @param namedQuery
     * @param parameters
     * @return 
     */
    Object selectNamedQuerySingle(String namedQuery, Map<String, Object> parameters);
}
