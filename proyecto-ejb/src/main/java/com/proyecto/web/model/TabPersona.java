package com.proyecto.web.model;

import com.proyecto.web.enumeration.PaisesEnum;
import com.proyecto.web.enumeration.TipoIdentificacionEnum;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.hibernate.validator.constraints.Email;

/**
 * The persistent class for the tab_entidad database table.
 *
 */
@Entity
@Table(name = "tab_persona")
public class TabPersona implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "per_id")
    private Long id;

    @Column(name = "per_apellidos", nullable = false)
    private String apellidos;
    @Email(message = "Correo incorrecto")
    @Column(name = "per_correo")
    private String correo;

    @Column(name = "per_direccion")
    private String direccion;

    @Column(name = "per_contacto")
    private String contacto;

    @Enumerated(EnumType.STRING)
    @Column(name = "per_tipo_identificacion")
    private TipoIdentificacionEnum tipoIdentificacion;

    @Column(name = "per_identificacion", nullable = true, unique = true)
    private String identificacion;

    @Column(name = "per_nombres", nullable = false)
    private String nombres;

    @Column(name = "per_telefono")
    private String telefono;

    @Column(name = "per_edad")
    private Integer edad;

    @Temporal(TemporalType.DATE)
    @Column(name = "per_fecha_nacimiento")
    private Date fechaNacimiento;

    @Column(name = "per_genero")
    private String genero;

    @Column(name = "per_nacionalidad")
    private String nacionalidad;

    @Column(name = "per_pais")
    @Enumerated(EnumType.STRING)
    private PaisesEnum Pais;

    @OneToMany(mappedBy = "persona")
    private Collection<TabUsuario> listaUsuarios;

    @Transient
    private String edicionCorreo;

    @Transient
    private String edicionIdentificacion;
    @Transient
    private DatosAuditoria datosAuditoria;

    @Override
    public String toString() {
        return "TabPersona{" + "id=" + id + ", apellidos=" + apellidos + ", correo=" + correo + ", direccion=" + direccion + ", contacto=" + contacto + ", tipoIdentificacion=" + tipoIdentificacion + ", identificacion=" + identificacion + ", nombres=" + nombres + ", telefono=" + telefono + ", edad=" + edad + ", fechaNacimiento=" + fechaNacimiento + ", genero=" + genero + ", nacionalidad=" + nacionalidad + ", Pais=" + Pais + '}';
    }

    public TabPersona(DatosAuditoria datosAuditoria) {
        this.datosAuditoria = datosAuditoria;
    }

    public TabPersona() {
    }

 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getEdicionCorreo() {
        return edicionCorreo;
    }

    public void setEdicionCorreo(String edicionCorreo) {
        this.edicionCorreo = edicionCorreo;
    }

    public String getEdicionIdentificacion() {
        return edicionIdentificacion;
    }

    public void setEdicionIdentificacion(String edicionIdentificacion) {
        this.edicionIdentificacion = edicionIdentificacion;
    }

    public Collection<TabUsuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public DatosAuditoria getDatosAuditoria() {
        return datosAuditoria;
    }

    public void setDatosAuditoria(DatosAuditoria datosAuditoria) {
        this.datosAuditoria = datosAuditoria;
    }

  

   

    public void setListaUsuarios(Collection<TabUsuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public TipoIdentificacionEnum getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(TipoIdentificacionEnum tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public PaisesEnum getPais() {
        return Pais;
    }

    public void setPais(PaisesEnum Pais) {
        this.Pais = Pais;
    }

}
