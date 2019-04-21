package Entidades;


import java.util.ArrayList;
import java.util.Scanner;

import Dados.DadosLoja;
import Negocio.NegocioPessoa;

public class Loja {
	Scanner sc = new Scanner(System.in);
	private Produtoo[] produto = new Produtoo[3];
	private String nome, cnpj;
	private String data;
	private Endereco endereco;
	private ArrayList<Funcionario> fucionario = new ArrayList<Funcionario>(2);
	public Loja(String nome, String cnpj, String data, Endereco endereco) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.data = data;
		this.endereco = endereco;
	}

	public Loja(String nome, String cnpj, String data,Endereco endereco,Produtoo[] produto,   ArrayList<Funcionario> fucionario) {
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
	public Produtoo[] getProduto() {
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
	public void setProduto(Produtoo[] produto) {
		this.produto = produto;
	}
	public ArrayList<Funcionario> cadastrarFuncionario() {
		for (int i = 0; i < 2; i++) {
			sc.nextLine();
			NegocioPessoa validarpessoa = new NegocioPessoa();
			System.out.println("nome do funcionario: ");

			String nomef = sc.nextLine();
			System.out.println("cpf do funcionario: ");
			String cpff = sc.next();
			validarpessoa.validarCPF(cpff);
			System.out.println("informe a data de nascimento do funcionario: ");
			String dataf = sc.next();
			validarpessoa.validarDataNascimento(dataf);
			System.out.println("informe o setor do funcionario: ");
			String setorf = sc.next();
			System.out.println("informe o salario bruto do funcionario: ");
			double salariof = sc.nextDouble();
			System.out.println("informe quantos porcentos de imposto seram retirado do salario: ");
			double impostof = sc.nextDouble();
			if (setorf.equals("entregador")) {
				
				fucionario.add(new Entregador(nomef, cpff, dataf, salariof, impostof));
			}else {
				fucionario.add(new Funcionario(nomef, cpff, dataf, setorf, salariof, impostof));
			}
		}
		return fucionario;
	}
	public Produtoo[] cadastrarProduto() {
		for (int i = 0; i < produto.length; i++) {
			System.out.println("nome do produto: ");
			String nomep = sc.next();
			System.out.println("codigo do produto: ");
			int codigop = sc.nextInt();
			System.out.println("valor do produto: ");
			double valorp = sc.nextDouble();
			produto[i] = new Produtoo(nomep, valorp, codigop);
			System.out.println("-----------------------------");

		}
		return produto;
	}
}
