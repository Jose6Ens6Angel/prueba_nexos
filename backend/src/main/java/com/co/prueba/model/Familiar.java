package com.co.prueba.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


/**
 * The persistent class for the familiar database table.
 * 
 */
@Entity
@Table(name = "Familiar")
@NamedQuery(name="Familiar.findAll", query="SELECT f FROM Familiar f")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Familiar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String apellido;

	private String celular;

	private String direccion;

	private String nombre;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_familiar")
	@JsonIgnore
	private Usuario usuario;

	public Familiar() {
	}

	public Familiar(Long id, String apellido, String celular, String direccion, String nombre, Usuario usuario) {
		super();
		this.id = id;
		this.apellido = apellido;
		this.celular = celular;
		this.direccion = direccion;
		this.nombre = nombre;
		this.usuario = usuario;
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

	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Familiar [id=" + id + ", apellido=" + apellido + ", celular=" + celular + ", direccion=" + direccion
				+ ", nombre=" + nombre + ", usuario=" + usuario + "]";
	}

}