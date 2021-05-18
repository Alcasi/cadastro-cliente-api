package com.cadcliente.api.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tab_telefones")
public class Telefone {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long telefone_id;
	
	private String telefone;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id", nullable = false )
    @JsonIgnore
	private Cliente cliente;
	
	public long getTelefone_id() {
		return telefone_id;
	}

	public void setTelefone_id(long telefone_id) {
		this.telefone_id = telefone_id;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
