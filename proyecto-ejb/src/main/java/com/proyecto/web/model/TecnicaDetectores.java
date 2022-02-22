package com.proyecto.web.model;

import com.proyecto.web.enumeration.TipoDetectoresExamen;
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
@Table(name = "tecnica_detectores")
public class TecnicaDetectores implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dec_id")
    private Long id;

    @Column(name = "dec_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @Column(name = "dec_sustancia")
    private String sustancia;

    @Column(name = "dec_observacion")
    private String observacion;

    @Column(name = "dec_area_busqueda")
    private TipoDetectoresExamen area_busqueda;

    @Column(name = "dec_indicacion")
    private BigDecimal indicacion;

    @Column(name = "dec_localizacion")
    private BigDecimal localizacion;

    @Column(name = "dec_guia")
    private BigDecimal guia;

    @Column(name = "dec_tipo_indicacion")
    private Boolean tip_indicacion;

    // bi-directional many-to-one association
    @ManyToOne
    @JoinColumn(name = "examen", referencedColumnName = "exa_id")
    private TecnicaExamen examen;

    public TecnicaDetectores() {
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

    public String getSustancia() {
        return sustancia;
    }

    public void setSustancia(String sustancia) {
        this.sustancia = sustancia;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public TipoDetectoresExamen getArea_busqueda() {
        return area_busqueda;
    }

    public void setArea_busqueda(TipoDetectoresExamen area_busqueda) {
        this.area_busqueda = area_busqueda;
    }

    public BigDecimal getIndicacion() {
        return indicacion;
    }

    public void setIndicacion(BigDecimal indicacion) {
        this.indicacion = indicacion;
    }

    public BigDecimal getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(BigDecimal localizacion) {
        this.localizacion = localizacion;
    }

    public BigDecimal getGuia() {
        return guia;
    }

    public void setGuia(BigDecimal guia) {
        this.guia = guia;
    }

    public Boolean getTip_indicacion() {
        return tip_indicacion;
    }

    public void setTip_indicacion(Boolean tip_indicacion) {
        this.tip_indicacion = tip_indicacion;
    }

    public TecnicaExamen getExamen() {
        return examen;
    }

    public void setExamen(TecnicaExamen examen) {
        this.examen = examen;
    }

}
