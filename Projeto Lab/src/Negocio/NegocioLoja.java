package Negocio;

import java.util.Scanner;

import Dados.DadosLoja;
import Entidades.Loja;

/*
 * essa classe tem como o objetivo de validar os dados da Loja
 * como: 
 * validar criação de uma nova loja
 * validar cnpj
 * validadar altaração de dados das lojas
 * buscar loja
 * Validar remoção da loja
 * 
 */

public class NegocioLoja {

	private Scanner sc = new Scanner(System.in);
	private DadosLoja dadosLoja = new DadosLoja();

	//vai validar o cnpj pra ver se n tem letras e se é menor/maior  que 14,e retorna corrigido ex.(15748596325698)
	public String validarCNPJ(String cnpj) {
		while (!cnpj.matches("\\d{14}")) {
			System.out.println("cnpj invalido, por favor digite corretamente: ");
			cnpj = sc.next();
		}
		System.out.println("cnpj valido!");
		return cnpj;
	}

	//vai validar a data pra ver se n tem letras e tamanho 2/2/4 ex.(20/05/2000) e retorna corrigido
	public String validarDataCriacao(String datacriacao) {
		while (!datacriacao.matches("\\d{2}\\d{2}\\d{4}")) {
			System.out.println("data invalida, por favor digite corretamente: ");
			datacriacao = sc.next();
		}
		System.out.println("data valida!");
		return datacriacao;
	}

	//validar cadastro da loja
	public boolean CadstrarLoja(Loja loja) {
		dadosLoja.receberDadosLoja(loja);
		return true;
	}

	//buscar loja
	public String Verificarloja(String cnpj) {
		String j = "";
		int size=dadosLoja.lerDadosLoja().size();
		for (int i = 0; i < size; i++) {
			if (cnpj.equals(dadosLoja.lerDadosLoja().get(i).getCnpj())) {
				j = Integer.toString(i);
				break;
			}else {
				j = null;
			}
		}
		return j;
	}

	//alterar dados da loja
	public boolean alterarLoja(Loja loja, int i) {
		dadosLoja.alterarDadosLoja(i, loja);
		return true;
	}

	//remover dados da loja
	public boolean removerLoja(int i){
		dadosLoja.removerDadosLoja(i);
		return true;
	}
	
	public DadosLoja getDadosLoja() {
		return dadosLoja;
	}
	public void setDadosLoja(DadosLoja dadosLoja) {
		this.dadosLoja = dadosLoja;
	}
}
