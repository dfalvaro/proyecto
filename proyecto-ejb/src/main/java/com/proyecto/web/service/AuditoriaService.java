package com.proyecto.web.service;

import com.proyecto.web.model.TabAuditoria;
import java.util.List;
import javax.ejb.Local;

@Local
public  interface AuditoriaService
{
  /**
   * 
   * @return 
   */
  public  List<TabAuditoria> obtenerTodos();
  /**
   * 
   * @param auditoria
   * @return 
   */
  public  List<TabAuditoria> buscar(TabAuditoria auditoria);
  
}

