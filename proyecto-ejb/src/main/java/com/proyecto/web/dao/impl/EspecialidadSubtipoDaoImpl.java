package com.proyecto.web.dao.impl;

import com.proyecto.web.dao.ICanDao;
import com.proyecto.web.dao.IEspecialidadSubtipoDao;
import com.proyecto.web.model.TabEspecialidadSubtipo;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class EspecialidadSubtipoDaoImpl
        extends GenericDao<TabEspecialidadSubtipo, Long>
        implements IEspecialidadSubtipoDao {

    public EspecialidadSubtipoDaoImpl() {
        super(TabEspecialidadSubtipo.class);
    }

    @Override
    public List<TabEspecialidadSubtipo> buscar(TabEspecialidadSubtipo especialidad) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from TabEspecialidadSubtipo t where 1=1");
        if (especialidad.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", especialidad.getId());
        }

        if (especialidad.getNombre() != null) {
            sql.append(" and t.nombre=:nombre");
            parametros.put("nombre", especialidad.getNombre());
        }
        if (especialidad.getEspecialidad() != null) {
            sql.append(" and t.especialidad=:especialidad");
            parametros.put("especialidad", especialidad.getEspecialidad());
        }

        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }

    
}
