package com.proyecto.web.model;

import com.proyecto.web.enumeration.EstadoActividadEnum;
import com.proyecto.web.enumeration.PaisesEnum;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * The actsistent class for the tab_act database table.
 *
 */
@Entity
@Table(name = "tab_actividad_usuario")
public class TabActividadUsuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aus_id")
    private Long id;

    //d actividad;  bi-directional many-to-one association to TabPersona
    @ManyToOne
    @JoinColumn(name = "actividad", referencedColumnName = "act_id")
    private TabActividad actividad;

    //d actividad;  bi-directional many-to-one association to TabPersona
    @ManyToOne
    @JoinColumn(name = "usuario", referencedColumnName = "usu_id")
    private TabUsuario usuario;

    //d actividad;  bi-directional many-to-one association to TabPersona
    @ManyToOne
    @JoinColumn(name = "aprobador", referencedColumnName = "usu_id")
    private TabUsuario aprobador;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "aus_fecha_registro")
    private Date fechaRegistro;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "aus_fecha_aprobacion")
    private Date fechaAprobacion;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "aus_fecha_rechazo")
    private Date fechaRechazado;
    
      @Column(name = "aus_codigo")
    private String codigo;
      

    @Column(name = "aus_descripcion")
    private String descripcion;

    @Column(name = "aus_descripcion_aprobacion")
    private String descripcionAprobacion;

    @Column(name = "aus_descripcion_rechazo")
    private String descripcionRechazo;

    @Column(name = "aus_hora_empleado")
    private BigDecimal horaEmpleada;

    @Column(name = "aus_costo")
    private BigDecimal costo;

    @Column(name = "aus_total")
    private BigDecimal total;

    @Column(name = "aus_pais")
    @Enumerated(EnumType.STRING)
    private PaisesEnum Pais;

    @Column(name = "aus_estado")
    @Enumerated(EnumType.STRING)
    private EstadoActividadEnum estado;

      @Transient
    private DatosAuditoria datosAuditoria;
   @Transient
    private Date fechaInicio;

    @Transient
    private Date fechaFin;
    @Override
    public String toString() {
        return "TabActividadUsuario{" + "id=" + id + ", actividad=" + actividad.getDescripcion() + ", usuario=" + usuario.getPersona().getApellidos() +" "+usuario.getPersona().getNombres() + ", aprobador=" +  aprobador.getPersona().getApellidos() +" "+aprobador.getPersona().getNombres()  + ", fechaRegistro=" + fechaRegistro + ", fechaAprobacion=" + fechaAprobacion + ", fechaRechazado=" + fechaRechazado + ", codigo=" + codigo + ", descripcion=" + descripcion + ", descripcionAprobacion=" + descripcionAprobacion + ", descripcionRechazo=" + descripcionRechazo + ", horaEmpleada=" + horaEmpleada + ", costo=" + costo + ", total=" + total + ", Pais=" + Pais + ", estado=" + estado + '}';
    }

    public TabActividadUsuario(DatosAuditoria datosAuditoria) {
        this.datosAuditoria = datosAuditoria;
    }

    public TabActividadUsuario() {
    }

 
    
    
    public TabActividadUsuario(TabUsuario usuario, TabUsuario aprobador) {
        this.usuario = usuario;
        this.aprobador = aprobador;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TabActividad getActividad() {
        return actividad;
    }

    public void setActividad(TabActividad actividad) {
        this.actividad = actividad;
    }

    public TabUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(TabUsuario usuario) {
        this.usuario = usuario;
    }

    public TabUsuario getAprobador() {
        return aprobador;
    }

    public void setAprobador(TabUsuario aprobador) {
        this.aprobador = aprobador;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaAprobacion() {
        return fechaAprobacion;
    }

    public void setFechaAprobacion(Date fechaAprobacion) {
        this.fechaAprobacion = fechaAprobacion;
    }

    public Date getFechaRechazado() {
        return fechaRechazado;
    }

    public void setFechaRechazado(Date fechaRechazado) {
        this.fechaRechazado = fechaRechazado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getHoraEmpleada() {
        return horaEmpleada;
    }

    public void setHoraEmpleada(BigDecimal horaEmpleada) {
        this.horaEmpleada = horaEmpleada;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public PaisesEnum getPais() {
        return Pais;
    }

    public void setPais(PaisesEnum Pais) {
        this.Pais = Pais;
    }

    public EstadoActividadEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoActividadEnum estado) {
        this.estado = estado;
    }

    public DatosAuditoria getDatosAuditoria() {
        return datosAuditoria;
    }

    public void setDatosAuditoria(DatosAuditoria datosAuditoria) {
        this.datosAuditoria = datosAuditoria;
    }

   

    public String getDescripcionAprobacion() {
        return descripcionAprobacion;
    }

    public void setDescripcionAprobacion(String descripcionAprobacion) {
        this.descripcionAprobacion = descripcionAprobacion;
    }

    public String getDescripcionRechazo() {
        return descripcionRechazo;
    }

    public void setDescripcionRechazo(String descripcionRechazo) {
        this.descripcionRechazo = descripcionRechazo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

}
