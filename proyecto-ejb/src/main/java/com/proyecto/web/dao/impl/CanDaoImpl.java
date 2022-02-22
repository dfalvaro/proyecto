package com.proyecto.web.dao.impl;

import com.proyecto.web.dao.ICanDao;
import com.proyecto.web.model.TabCan;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class CanDaoImpl
        extends GenericDao<TabCan, Long>
        implements ICanDao {

    public CanDaoImpl() {
        super(TabCan.class);
    }

    @Override
    public List<TabCan> buscar(TabCan can) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from TabCan t where 1=1");
        if (can.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", can.getId());
        }

        if (can.getEstado() != null) {
            sql.append(" and t.estado=:estado");
            parametros.put("estado", can.getEstado());
        }

        if (can.getEspecialidadTipo() != null) {
            sql.append(" and t.especialidadTipo=:especialidadTipo");
            parametros.put("especialidadTipo", can.getEspecialidadTipo());
        }

        if (can.getEspecialidadSubTipo() != null) {
            sql.append(" and t.especialidadSubTipo=:especialidadSubTipo");
            parametros.put("especialidadSubTipo", can.getEspecialidadSubTipo());
        }

        if (can.getCodigoInterno() != null) {
            sql.append(" and t.codigoInterno=:codigoInterno");
            parametros.put("codigoInterno", can.getCodigoInterno());
        }

        if (can.getCodigoSiipne() != null) {
            sql.append(" and t.codigoSiipne=:codigoSiipne");
            parametros.put("codigoSiipne", can.getCodigoSiipne());
        }

        if (can.getCodigoEsbye() != null) {
            sql.append(" and t.codigoEsbye=:codigoEsbye");
            parametros.put("codigoEsbye", can.getCodigoEsbye());
        }

        if (can.getNumeroChips() != null) {
            sql.append(" and t.numeroChips=:numeroChips");
            parametros.put("numeroChips", can.getNumeroChips());
        }

        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }

    @Override
    public List<TabCan> redimencionarImagen() {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from TabCan t where t.imagen  is not null   and trim(t.imagen) !=''and length(t.imagen) >:cien");
        parametros.put("cien", 100);

        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }

    @Override
    public Long obtenerSecuencialFinal() {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select MAX(t.secuencial) from TabCan t ");

        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (Long) q.getSingleResult();
    }
}
