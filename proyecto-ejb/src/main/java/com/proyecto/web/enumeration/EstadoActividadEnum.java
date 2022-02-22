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
public enum EstadoActividadEnum {

    REGISTRADO("REGISTRADO"),
    RECHAZADO("RECHAZADO"),
    APROBADO("APROBADO");
    private String nombre;

    private EstadoActividadEnum(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
