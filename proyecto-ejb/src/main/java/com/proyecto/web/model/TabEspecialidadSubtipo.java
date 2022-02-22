package com.proyecto.web.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 */
@Entity
@Table(name = "gen_especialidad_subtipo")
public class TabEspecialidadSubtipo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ess_id")
    private Long id;

    @Column(name = "ess_nombre")
    private String nombre;

    // bi-directional many-to-one association
    @ManyToOne
    @JoinColumn(name = "especialidad", referencedColumnName = "esp_id")
    private TabEspecialidad especialidad;

    public TabEspecialidadSubtipo() {
    }

    public TabEspecialidadSubtipo(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public TabEspecialidadSubtipo(TabEspecialidad especialidad) {
        this.especialidad = especialidad;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TabEspecialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(TabEspecialidad especialidad) {
        this.especialidad = especialidad;
    }

}
