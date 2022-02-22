package com.proyecto.web.dao.impl;

import com.proyecto.web.dao.UsuarioDao;
import com.proyecto.web.model.TabUsuario;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Singleton;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

@Singleton
@Repository
public class UsuarioDaoImpl
        extends GenericDao<TabUsuario, Long>
        implements UsuarioDao {

    public UsuarioDaoImpl() {
        super(TabUsuario.class);
    }

    @Override
    public List<TabUsuario> buscar(TabUsuario usuario) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from TabUsuario t where 1=1");
        if (usuario.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", usuario.getId());
        }


        if (usuario.getPerfil() != null) {
            sql.append(" and t.perfil =:perfil");
            parametros.put("perfil", usuario.getPerfil());
        }
        
         if (usuario.getEstado() != null) {
            sql.append(" and t.estado =:estado");
            parametros.put("estado", usuario.getEstado());
        }
         
         if (usuario.getPersona() != null) {
            sql.append(" and t.persona =:persona");
            parametros.put("persona", usuario.getPersona());
        }

        if ((usuario.getNombre() != null) && (!usuario.getNombre().isEmpty())) {
            sql.append(" and t.nombre =:nombre");
            parametros.put("nombre", usuario.getNombre());
        }
        
          if (usuario.getValidacionIdentificacion() != null) {
            sql.append(" and t.persona.identificacion =:identificacion");
            parametros.put("identificacion", usuario.getValidacionIdentificacion());
        }

        sql.append(" order by t.id  desc ");

        Query q = this.em.createQuery(sql.toString());
       for (Object key : parametros.keySet()) {
            q.setParameter((String) key, parametros.get(key));
        }
        return q.getResultList();
    }

 
}
