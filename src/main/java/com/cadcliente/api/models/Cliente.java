package com.cadcliente.api.models;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tab_clientes")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 3004571281940906442L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long cliente_id;

	@Column(name = "NOME", nullable = false)
	private String nome;
	
	@Column(name = "TIPO_PESSOA", nullable = false)
	private int tipoPessoa;
	
	@Column(name = "CADASTRO_PESSOA", nullable = false)
	private String cadPessoa; // CPF ou CNPJ
	
	@Column(name = "REGISTRO_PESSOA")
	private String regPessoa; // RE ou IE

	@Column(name = "DATA_CADASTRO", columnDefinition = "DATE DEFAULT CURRENT_DATE")
	private Timestamp dataCadastro;
	
	@Column(name = "CADASTRO_ATIVO", columnDefinition = "BOOLEAN DEFAULT TRUE")
	private boolean cadastroAtivo;
	
	@OneToMany(mappedBy = "cliente")
	private Set<Telefone> telefones;
		
	public long getCliente_id() {
		return cliente_id;
	}

	public void setCliente_id(long cliente_id) {
		this.cliente_id = cliente_id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(int tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public String getCadPessoa() {
		return cadPessoa;
	}

	public void setCadPessoa(String cadPessoa) {
		this.cadPessoa = cadPessoa;
	}

	public String getRegPessoa() {
		return regPessoa;
	}

	public void setRegPessoa(String regPessoa) {
		this.regPessoa = regPessoa;
	}

	public Timestamp getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Timestamp dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public boolean isCadastroAtivo() {
		return cadastroAtivo;
	}

	public void setCadastroAtivo(boolean cadastroAtivo) {
		this.cadastroAtivo = cadastroAtivo;
	}

	public Set<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<Telefone> telefones) {
		this.telefones = telefones;
	}


}
