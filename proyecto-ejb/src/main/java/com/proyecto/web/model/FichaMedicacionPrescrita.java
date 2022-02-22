package com.proyecto.web.model;

import java.io.Serializable;
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
@Table(name = "ficha_medicacion_prescrita")
public class FichaMedicacionPrescrita implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mep_id")
    private Long id;

    @Column(name = "mep_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @Column(name = "mep_medicamento")
    private String medicamento;

    @Column(name = "mep_dosis")
    private String dosis;

    @Column(name = "mep_via_administracion")
    private String via_administracion;

    @Column(name = "mep_duracion")
    private String duracion;

    @Column(name = "mep_fecha_alta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAlta;

    // bi-directional many-to-one association
    @ManyToOne
    @JoinColumn(name = "consulta", referencedColumnName = "con_id")
    private FichaConsulta consulta;

    public FichaMedicacionPrescrita() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public String getVia_administracion() {
        return via_administracion;
    }

    public void setVia_administracion(String via_administracion) {
        this.via_administracion = via_administracion;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public FichaConsulta getConsulta() {
        return consulta;
    }

    public void setConsulta(FichaConsulta consulta) {
        this.consulta = consulta;
    }
    
    

}
