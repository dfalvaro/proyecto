package com.proyecto.web.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 */
@Entity
@Table(name = "gen_especialidad")
public class TabEspecialidad implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "esp_id")
    private Long id;

    @Column(name = "esp_nombre")
    private String nombre;

    @OneToMany(mappedBy = "especialidad")
    private List<TabEspecialidadSubtipo> listaEspecialidadSubtipo;

    public TabEspecialidad() {
    }

    public TabEspecialidad(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    

    public TabEspecialidad(Long id) {
        this.id = id;
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

    public List<TabEspecialidadSubtipo> getListaEspecialidadSubtipo() {
        return listaEspecialidadSubtipo;
    }

    public void setListaEspecialidadSubtipo(List<TabEspecialidadSubtipo> listaEspecialidadSubtipo) {
        this.listaEspecialidadSubtipo = listaEspecialidadSubtipo;
    }

}
