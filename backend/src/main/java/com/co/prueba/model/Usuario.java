package com.co.prueba.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(name = "Usuario")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String apellido;

	private int cantidad_Personas;

	private String celular;

	private String ciudad;

	private String direccion;

	private String documento;

	@Temporal(TemporalType.DATE)
	private Date fecha_Naci;

	private String nombre;

	private String ocupacion;

	private int tipo_Doc;

	//bi-directional many-to-one association to Familiar
	@OneToMany(mappedBy="usuario")
	private List<Familiar> familiars;

	public Usuario() {
	}

	public Usuario(Long id, String apellido, int cantidad_Personas, String celular, String ciudad, String direccion,
			String documento, Date fecha_Naci, String nombre, String ocupacion, int tipo_Doc,
			List<Familiar> familiars) {
		super();
		this.id = id;
		this.apellido = apellido;
		this.cantidad_Personas = cantidad_Personas;
		this.celular = celular;
		this.ciudad = ciudad;
		this.direccion = direccion;
		this.documento = documento;
		this.fecha_Naci = fecha_Naci;
		this.nombre = nombre;
		this.ocupacion = ocupacion;
		this.tipo_Doc = tipo_Doc;
		this.familiars = familiars;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getCantidad_Personas() {
		return this.cantidad_Personas;
	}

	public void setCantidad_Personas(int cantidad_Personas) {
		this.cantidad_Personas = cantidad_Personas;
	}

	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Date getFecha_Naci() {
		return this.fecha_Naci;
	}

	public void setFecha_Naci(Date fecha_Naci) {
		this.fecha_Naci = fecha_Naci;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getOcupacion() {
		return this.ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	public int getTipo_Doc() {
		return this.tipo_Doc;
	}

	public void setTipo_Doc(int tipo_Doc) {
		this.tipo_Doc = tipo_Doc;
	}

	public List<Familiar> getFamiliars() {
		return this.familiars;
	}

	public void setFamiliars(List<Familiar> familiars) {
		this.familiars = familiars;
	}

	public Familiar addFamiliar(Familiar familiar) {
		getFamiliars().add(familiar);
		familiar.setUsuario(this);

		return familiar;
	}

	public Familiar removeFamiliar(Familiar familiar) {
		getFamiliars().remove(familiar);
		familiar.setUsuario(null);

		return familiar;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", apellido=" + apellido + ", cantidad_Personas=" + cantidad_Personas
				+ ", celular=" + celular + ", ciudad=" + ciudad + ", direccion=" + direccion + ", documento="
				+ documento + ", fecha_Naci=" + fecha_Naci + ", nombre=" + nombre + ", ocupacion=" + ocupacion
				+ ", tipo_Doc=" + tipo_Doc + ", familiars=" + familiars + "]";
	}

}