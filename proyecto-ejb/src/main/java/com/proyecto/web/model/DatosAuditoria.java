/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.web.model;

import java.io.Serializable;

/**
 *
 * @author TPV
 */
public class DatosAuditoria implements Serializable {

    private String nombreUsuario;
    private Long idUsuario;
    private Long idEmpresa;
    private String nombrefuncionalidad;

    @Override
    public String toString() {
        return "DatosAuditoria{" + "nombreUsuario=" + nombreUsuario + ", idUsuario=" + idUsuario + ", idEmpresa=" + idEmpresa + ", nombrefuncionalidad=" + nombrefuncionalidad + '}';
    }

    public DatosAuditoria(String nombreUsuario, Long idUsuario, String nombrefuncionalidad) {
        this.nombreUsuario = nombreUsuario;
        this.idUsuario = idUsuario;
        this.nombrefuncionalidad = nombrefuncionalidad;
    }

    public DatosAuditoria() {
    }

    public DatosAuditoria(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombrefuncionalidad() {
        return nombrefuncionalidad;
    }

    public void setNombrefuncionalidad(String nombrefuncionalidad) {
        this.nombrefuncionalidad = nombrefuncionalidad;
    }

}
