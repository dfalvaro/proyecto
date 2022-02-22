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
@Table(name = "ficha_desparacitacion_interna")
public class FichaDesparacitacionInterna implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dei_id")
    private Long id;

    @Column(name = "dei_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @Column(name = "dei_peso")
    private BigDecimal peso;

    @Column(name = "dei_producto")
    private String producto;

    @Column(name = "dei_fecha_proxima")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaProxima;

    // bi-directional many-to-one association
    @ManyToOne
    @JoinColumn(name = "consulta", referencedColumnName = "con_id")
    private FichaConsulta consulta;

    public FichaDesparacitacionInterna() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Date getFechaProxima() {
        return fechaProxima;
    }

    public void setFechaProxima(Date fechaProxima) {
        this.fechaProxima = fechaProxima;
    }

}
