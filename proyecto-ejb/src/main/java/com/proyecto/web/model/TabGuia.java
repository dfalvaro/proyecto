package com.proyecto.web.model;

import com.proyecto.web.enumeration.GradoGuiaEnum;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "gen_guia")
public class TabGuia implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gui_id")
    private Long id;

    @Column(name = "gui_estado", nullable = false)
    private String estado;

    @Column(name = "gui_grado")
    @Enumerated(EnumType.STRING)
    private GradoGuiaEnum gradoGuiaEnum;

    @ManyToOne
    @JoinColumn(name = "persona", nullable = false, referencedColumnName = "per_id")
    private TabPersona persona;

    @OneToMany(mappedBy = "guia")
    private List<TabCan> listaCanes;

    @Transient
    private String correo;
    @Transient
    private String telefono;
    @Transient
    private String celular;

    public TabGuia(TabPersona persona) {
        this.persona = persona;
    }

    public TabGuia() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public TabPersona getPersona() {
        return persona;
    }

    public void setPersona(TabPersona persona) {
        this.persona = persona;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public List<TabCan> getListaCanes() {
        return listaCanes;
    }

    public void setListaCanes(List<TabCan> listaCanes) {
        this.listaCanes = listaCanes;
    }

    public GradoGuiaEnum getGradoGuiaEnum() {
        return gradoGuiaEnum;
    }

    public void setGradoGuiaEnum(GradoGuiaEnum gradoGuiaEnum) {
        this.gradoGuiaEnum = gradoGuiaEnum;
    }

}
