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
@Table(name = "ficha_evacuaciones")
public class FichaEvacuaciones implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eva_id")
    private Long id;

    @Column(name = "eva_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @Column(name = "eva_heces")
    private String heces;

    @Column(name = "eva_orina")
    private String orina;

    // bi-directional many-to-one association
    @ManyToOne
    @JoinColumn(name = "consulta", referencedColumnName = "con_id")
    private FichaConsulta consulta;

    public FichaEvacuaciones() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHeces() {
        return heces;
    }

    public void setHeces(String heces) {
        this.heces = heces;
    }

    public String getOrina() {
        return orina;
    }

    public void setOrina(String orina) {
        this.orina = orina;
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
    
    

}
