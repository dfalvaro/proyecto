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
@Table(name = "ficha_fisica_visual")
public class FichaFisicaVisual implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fiv_id")
    private Long id;

    @Column(name = "fiv_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @Column(name = "fiv_oidos")
    private String oidos;

    @Column(name = "fiv_ojos")
    private String ojos;

    @Column(name = "fiv_trufa")
    private String trufa;

    @Column(name = "fiv_boca_dentadura")
    private String bocaDentadura;

    @Column(name = "fiv_piel_pelaje")
    private String pielPelaje;

    @Column(name = "fiv_region_craneal")
    private String regionCraneal;

    @Column(name = "fiv_region_ventral")
    private String regionVentral;

    @Column(name = "fiv_region_dorsal")
    private String regionDorsal;

    @Column(name = "fiv_region_caudal")
    private String regionCaudal;

    @Column(name = "fiv_miembors_anteriores")
    private String miembrosAnteriores;

    @Column(name = "fiv_miembors_posteriores")
    private String miembrosPosteriores;

    // bi-directional many-to-one association
    @ManyToOne
    @JoinColumn(name = "consulta", referencedColumnName = "con_id")
    private FichaConsulta consulta;

    public FichaFisicaVisual() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOidos() {
        return oidos;
    }

    public void setOidos(String oidos) {
        this.oidos = oidos;
    }

    public String getOjos() {
        return ojos;
    }

    public void setOjos(String ojos) {
        this.ojos = ojos;
    }

    public String getTrufa() {
        return trufa;
    }

    public void setTrufa(String trufa) {
        this.trufa = trufa;
    }

    public String getBocaDentadura() {
        return bocaDentadura;
    }

    public void setBocaDentadura(String bocaDentadura) {
        this.bocaDentadura = bocaDentadura;
    }

    public String getPielPelaje() {
        return pielPelaje;
    }

    public void setPielPelaje(String pielPelaje) {
        this.pielPelaje = pielPelaje;
    }

    public String getRegionCraneal() {
        return regionCraneal;
    }

    public void setRegionCraneal(String regionCraneal) {
        this.regionCraneal = regionCraneal;
    }

    public String getRegionVentral() {
        return regionVentral;
    }

    public void setRegionVentral(String regionVentral) {
        this.regionVentral = regionVentral;
    }

    public String getRegionDorsal() {
        return regionDorsal;
    }

    public void setRegionDorsal(String regionDorsal) {
        this.regionDorsal = regionDorsal;
    }

    public String getRegionCaudal() {
        return regionCaudal;
    }

    public void setRegionCaudal(String regionCaudal) {
        this.regionCaudal = regionCaudal;
    }

    public String getMiembrosAnteriores() {
        return miembrosAnteriores;
    }

    public void setMiembrosAnteriores(String miembrosAnteriores) {
        this.miembrosAnteriores = miembrosAnteriores;
    }

    public String getMiembrosPosteriores() {
        return miembrosPosteriores;
    }

    public void setMiembrosPosteriores(String miembrosPosteriores) {
        this.miembrosPosteriores = miembrosPosteriores;
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
