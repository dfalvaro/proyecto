package com.proyecto.web.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 */
@Entity
@Table(name = "ficha_consulta")
public class FichaConsulta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "con_id")
    private Long id;

    @Column(name = "con_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @Column(name = "con_motivo_consulta")
    private String motivoConsulta;

    @Column(name = "con_unidad_procedencia")
    private String unidadProcedencia;

    @Column(name = "con_peso")
    private BigDecimal peso;

    @Column(name = "con_condicion_corporal")
    private String condicionCorporal;

    @Column(name = "con_estado_reproductivo")
    private String estadoReproductivo;

    // bi-directional many-to-one association
    @ManyToOne
    @JoinColumn(name = "animal", referencedColumnName = "ani_id")
    private TabAnimal animal;

    public FichaConsulta() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }

    public String getUnidadProcedencia() {
        return unidadProcedencia;
    }

    public void setUnidadProcedencia(String unidadProcedencia) {
        this.unidadProcedencia = unidadProcedencia;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public String getCondicionCorporal() {
        return condicionCorporal;
    }

    public void setCondicionCorporal(String condicionCorporal) {
        this.condicionCorporal = condicionCorporal;
    }

    public String getEstadoReproductivo() {
        return estadoReproductivo;
    }

    public void setEstadoReproductivo(String estadoReproductivo) {
        this.estadoReproductivo = estadoReproductivo;
    }

    public TabAnimal getAnimal() {
        return animal;
    }

    public void setAnimal(TabAnimal animal) {
        this.animal = animal;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    
    
}
