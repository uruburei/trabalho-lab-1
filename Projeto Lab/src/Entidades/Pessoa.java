package Entidades;

import java.io.Serializable;

public class Pessoa implements Serializable {
	private String nome, cpf, data; 
	public Pessoa(String nome, String cpf, String data){
		this.nome = nome;
		this.cpf = cpf;
		this.data = data;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
}
