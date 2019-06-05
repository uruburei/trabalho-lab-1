package Entidades;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import Dados.DadosLoja;
import Negocio.NegocioPessoa;

public class Loja implements Serializable {
	private ArrayList<Produtoo> produto;
	private String nome, cnpj;
	private String data;
	private Endereco endereco;
	private ArrayList<Funcionario> fucionario;

	public Loja(String nome, String cnpj, String data,Endereco endereco,ArrayList<Produtoo> produto,   ArrayList<Funcionario> fucionario) {
		this.produto = produto;
		this.nome = nome;
		this.cnpj = cnpj;
		this.data = data;
		this.endereco = endereco;
		this.fucionario = fucionario;
	}

	public String getNome() {
		return nome;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<Produtoo> getProduto() {
		return produto;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public ArrayList<Funcionario> getFucionario() {
		return fucionario;
	}
	public void setFucionario(ArrayList<Funcionario> fucionario) {
		this.fucionario = fucionario;
	}
	public void setProduto(ArrayList<Produtoo> produto) {
		this.produto = produto;
	}
}
