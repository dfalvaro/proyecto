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
@Table(name = "ficha_constante_fisiologica")
public class FichaConstanteFisiologica implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cof_id")
    private Long id;

    @Column(name = "cof_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @Column(name = "cof_temperatura")
    private BigDecimal temperatura;

    @Column(name = "cof_frecuencia_respiratoria")
    private BigDecimal frecuenciaRespiratoria;

    @Column(name = "cof_frecuencia_cardiaca")
    private BigDecimal frecuenciaCardiaca;

    @Column(name = "cof_ruido_capilar")
    private String ruidoCapilar;

    @Column(name = "cof_mucosa")
    private String mucosa;

    @Column(name = "cof_ganglios")
    private String ganglios;

    // bi-directional many-to-one association
    @ManyToOne
    @JoinColumn(name = "consulta", referencedColumnName = "con_id")
    private FichaConsulta consulta;

    public FichaConstanteFisiologica() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(BigDecimal temperatura) {
        this.temperatura = temperatura;
    }

    public BigDecimal getFrecuenciaRespiratoria() {
        return frecuenciaRespiratoria;
    }

    public void setFrecuenciaRespiratoria(BigDecimal frecuenciaRespiratoria) {
        this.frecuenciaRespiratoria = frecuenciaRespiratoria;
    }

    public BigDecimal getFrecuenciaCardiaca() {
        return frecuenciaCardiaca;
    }

    public void setFrecuenciaCardiaca(BigDecimal frecuenciaCardiaca) {
        this.frecuenciaCardiaca = frecuenciaCardiaca;
    }

    public String getRuidoCapilar() {
        return ruidoCapilar;
    }

    public void setRuidoCapilar(String ruidoCapilar) {
        this.ruidoCapilar = ruidoCapilar;
    }

    public String getGanglios() {
        return ganglios;
    }

    public void setGanglios(String ganglios) {
        this.ganglios = ganglios;
    }

    public FichaConsulta getConsulta() {
        return consulta;
    }

    public void setConsulta(FichaConsulta consulta) {
        this.consulta = consulta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMucosa() {
        return mucosa;
    }

    public void setMucosa(String mucosa) {
        this.mucosa = mucosa;
    }
    
    

}
