package com.proyecto.web.dao;

import com.proyecto.web.model.TabAuditoria;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 * Clase ...
 *
 * @author 
 * @revision $Revision: 1.1 $
 */
@Local
public interface AuditoriaDao extends IGenericDao<TabAuditoria, Long> {

    /**
     *
     * @param auditoria
     * @return
     */
    List<TabAuditoria> buscar(TabAuditoria auditoria);


}
