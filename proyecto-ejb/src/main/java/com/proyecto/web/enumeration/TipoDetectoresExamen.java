/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.web.enumeration;

/**
 *
 * @author usuario
 */
public enum TipoDetectoresExamen {

    VEHICULO("VEHICULO"),
    PERSONAS("PERSONAS"),
    CAMPO_ABIERTO("CAMPO ABIERTO"),
    EQUIPAJE_ACCESORIOS("EQUIPAJE Y ACCESORIOS"),
    CARGA("CARGA"),
    HABITACIONES_BODEGAS("HABITACIONES Y BODEGAS"),
    OTROS("OTROS");

    private String nombre;

    private TipoDetectoresExamen(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
