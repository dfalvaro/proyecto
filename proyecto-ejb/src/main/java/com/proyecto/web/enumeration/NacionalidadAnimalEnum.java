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
public enum NacionalidadAnimalEnum {

    NACIONAL("NACIONAL"),
    EXTRANJERO("EXTRANJERO");

    private String nombre;

    private NacionalidadAnimalEnum(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
