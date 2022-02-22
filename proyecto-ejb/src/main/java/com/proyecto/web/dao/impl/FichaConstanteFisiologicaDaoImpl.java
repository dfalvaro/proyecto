package com.proyecto.web.dao.impl;

import com.proyecto.web.dao.IFichaConstanteFisiologicaDao;
import com.proyecto.web.model.FichaConstanteFisiologica;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Singleton;
import javax.persistence.Query;
import com.proyecto.web.dao.PersonaDao;

@Singleton
public class FichaConstanteFisiologicaDaoImpl
        extends GenericDao<FichaConstanteFisiologica, Long>
        implements IFichaConstanteFisiologicaDao {

    public FichaConstanteFisiologicaDaoImpl() {
        super(FichaConstanteFisiologica.class);
    }

    @Override
    public List<FichaConstanteFisiologica> buscar(FichaConstanteFisiologica entidad) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from FichaConstanteFisiologica t where 1=1 ");
        if (entidad.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", entidad.getId());
        }

        sql.append(" order by t.id  desc ");

        Query q = this.em.createQuery(sql.toString());
        for (Object key : parametros.keySet()) {
            q.setParameter((String) key, parametros.get(key));
        }
        return q.getResultList();
    }
}
