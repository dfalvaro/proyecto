package com.proyecto.web.dao.impl;

import com.proyecto.web.dao.AuditoriaDao;
import com.proyecto.web.model.TabAuditoria;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Singleton;
import javax.persistence.Query;

@Singleton
public class AuditoriaDaoImpl extends GenericDao<TabAuditoria, Long>
        implements AuditoriaDao {

    public AuditoriaDaoImpl() {
        super(TabAuditoria.class);
    }

    @Override
    public List<TabAuditoria> buscar(TabAuditoria auditoria) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from TabAuditoria t where 1=1 ");
        if (auditoria.getFechaInicio() != null && auditoria.getFechaFin() != null) {
            sql.append(" and cast(fecha as date) between :fechaInicio and :fechaFin ");
            parametros.put("fechaInicio", auditoria.getFechaInicio());
            parametros.put("fechaFin", auditoria.getFechaFin());
        }
        Query q = this.em.createQuery(sql.toString());
        for (Object key : parametros.keySet()) {
            q.setParameter((String) key, parametros.get(key));
        }
        return q.getResultList();
    }

   
    
}
