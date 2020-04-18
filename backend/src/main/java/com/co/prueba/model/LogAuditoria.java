package com.co.prueba.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the log_auditoria database table.
 * 
 */
@Entity
@Table(name="Log_Auditoria")
@NamedQuery(name="LogAuditoria.findAll", query="SELECT l FROM LogAuditoria l")
public class LogAuditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="campos_in")
	private String camposIn;

	@Column(name="campos_out")
	private String camposOut;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	public LogAuditoria() {
	}

	public LogAuditoria(String camposIn, String camposOut) {
		super();
		this.camposIn = camposIn;
		this.camposOut = camposOut;
	}

	public String getCamposIn() {
		return this.camposIn;
	}

	public void setCamposIn(String camposIn) {
		this.camposIn = camposIn;
	}

	public String getCamposOut() {
		return this.camposOut;
	}

	public void setCamposOut(String camposOut) {
		this.camposOut = camposOut;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

}