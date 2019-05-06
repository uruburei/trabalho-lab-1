package Entidades;

import java.io.Serializable;

public class Endereco implements Serializable {
	private String lugadouro;
	private String numeroResidencia;
	private String bairro,cidade,estado, cep;
	public Endereco(String lugadouro,String cep,String numeroResidencia,String bairro,String cidade,String estado) {
		this.lugadouro = lugadouro;
		this.cep = cep;
		this.numeroResidencia = numeroResidencia;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado; 
		
	}
	public String getLugadouro() {
		return lugadouro;
	}
	public void setLugadouro(String lugadouro) {
		this.lugadouro = lugadouro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getNumeroResidencia() {
		return numeroResidencia;
	}
	public void setNumeroResidencia(String numeroResidencia) {
		this.numeroResidencia = numeroResidencia;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	

}
