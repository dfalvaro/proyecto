package com.proyecto.web.model;

import com.proyecto.web.enumeration.EstadoEvaluacion;
import com.proyecto.web.enumeration.TipoDetectoresExamen;
import com.proyecto.web.enumeration.TipoEvaluacion;
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
@Table(name = "tecnica_detectores_resultado")
public class TecnicaDetectoresResultado implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "der_id")
    private Long id;

    @Column(name = "der_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @Column(name = "der_total_indicacion")
    private BigDecimal totalIndicacion;

    @Column(name = "der_total_localizacion")
    private BigDecimal totalLocalizacion;

    @Column(name = "der_total_guia")
    private BigDecimal totalguia;

    @Column(name = "der_total_d")
    private BigDecimal totalD;

    @Column(name = "der_total_e")
    private BigDecimal totalE;

    @Column(name = "der_total_f")
    private BigDecimal totalF;

    @Column(name = "der_total_g")
    private BigDecimal totalG;

    @Column(name = "der_total_h")
    private BigDecimal totalH;

    @Column(name = "der_total_i")
    private BigDecimal totalI;

    @Column(name = "der_total_j")
    private BigDecimal totalJ;

    @Column(name = "der_total_k")
    private BigDecimal totalK;

    @Column(name = "der_tipo_evaluacion")
    private TipoEvaluacion tipoEvaluacion;

    @Column(name = "der_estado_evaluacion")
    private EstadoEvaluacion estadoEvaluacion;

    // bi-directional many-to-one association
    @ManyToOne
    @JoinColumn(name = "examen", referencedColumnName = "exa_id")
    private TecnicaExamen examen;

    public TecnicaDetectoresResultado() {
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

    public BigDecimal getTotalIndicacion() {
        return totalIndicacion;
    }

    public void setTotalIndicacion(BigDecimal totalIndicacion) {
        this.totalIndicacion = totalIndicacion;
    }

    public BigDecimal getTotalLocalizacion() {
        return totalLocalizacion;
    }

    public void setTotalLocalizacion(BigDecimal totalLocalizacion) {
        this.totalLocalizacion = totalLocalizacion;
    }

    public BigDecimal getTotalguia() {
        return totalguia;
    }

    public void setTotalguia(BigDecimal totalguia) {
        this.totalguia = totalguia;
    }

    public BigDecimal getTotalD() {
        return totalD;
    }

    public void setTotalD(BigDecimal totalD) {
        this.totalD = totalD;
    }

    public BigDecimal getTotalE() {
        return totalE;
    }

    public void setTotalE(BigDecimal totalE) {
        this.totalE = totalE;
    }

    public BigDecimal getTotalF() {
        return totalF;
    }

    public void setTotalF(BigDecimal totalF) {
        this.totalF = totalF;
    }

    public BigDecimal getTotalG() {
        return totalG;
    }

    public void setTotalG(BigDecimal totalG) {
        this.totalG = totalG;
    }

    public BigDecimal getTotalH() {
        return totalH;
    }

    public void setTotalH(BigDecimal totalH) {
        this.totalH = totalH;
    }

    public BigDecimal getTotalI() {
        return totalI;
    }

    public void setTotalI(BigDecimal totalI) {
        this.totalI = totalI;
    }

    public BigDecimal getTotalJ() {
        return totalJ;
    }

    public void setTotalJ(BigDecimal totalJ) {
        this.totalJ = totalJ;
    }

    public BigDecimal getTotalK() {
        return totalK;
    }

    public void setTotalK(BigDecimal totalK) {
        this.totalK = totalK;
    }

    public TecnicaExamen getExamen() {
        return examen;
    }

    public void setExamen(TecnicaExamen examen) {
        this.examen = examen;
    }

    public TipoEvaluacion getTipoEvaluacion() {
        return tipoEvaluacion;
    }

    public void setTipoEvaluacion(TipoEvaluacion tipoEvaluacion) {
        this.tipoEvaluacion = tipoEvaluacion;
    }

    public EstadoEvaluacion getEstadoEvaluacion() {
        return estadoEvaluacion;
    }

    public void setEstadoEvaluacion(EstadoEvaluacion estadoEvaluacion) {
        this.estadoEvaluacion = estadoEvaluacion;
    }

}
