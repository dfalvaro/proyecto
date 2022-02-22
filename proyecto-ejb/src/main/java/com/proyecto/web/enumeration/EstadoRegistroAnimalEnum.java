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
public enum EstadoRegistroAnimalEnum {

    ACTIVO("ACTIVO"),
    INACTIVO("INACTIVO");

    String tipo;

    private EstadoRegistroAnimalEnum(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return this.tipo;
    }
}
