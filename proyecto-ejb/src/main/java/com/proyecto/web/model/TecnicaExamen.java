package com.proyecto.web.model;

import com.proyecto.web.enumeration.TipoExamen;
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
@Table(name = "tecnica_examen")
public class TecnicaExamen implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exa_id")
    private Long id;

    @Column(name = "exa_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @Column(name = "exa_tipo")
    private TipoExamen tipoExamen;

    @Column(name = "exa_observacion")
    private String observacion;

    @Column(name = "exa_lugar")
    private String lugar;

    // bi-directional many-to-one association
    @ManyToOne
    @JoinColumn(name = "can", referencedColumnName = "can_id")
    private TabCan can;

    public TecnicaExamen() {
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

    public TipoExamen getTipoExamen() {
        return tipoExamen;
    }

    public void setTipoExamen(TipoExamen tipoExamen) {
        this.tipoExamen = tipoExamen;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public TabCan getCan() {
        return can;
    }

    public void setCan(TabCan can) {
        this.can = can;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

}
