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

	//validar cnpj
	public String validarCNPJ(String cnpj) {
		//vai validar o cnpj pra ver se n tem letras e Ã© menor/maior  que 14,e retorna corrigido ex.(15748596325698)
		while (!cnpj.matches("\\d{14}")) {
			System.out.println("cnpj invalido, por favor digite corretamente: ");
			cnpj = sc.next();
			f = cnpj.matches("\\d{14}");
		}

		System.out.println("cnpj valido!");
		return cnpj;
	}

	//validar data de inicialização da loja
	public String validarDataCriacao(String datacriacao) {
		//vai validar a data pra ver se n tem letras e tamanho 2/2/4 ex.(20/05/2000) e retorna corrigido
		while (!datacriacao.matches("\\d{2}/\\d{2}/\\d{4}")) {
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
	public int Verificarloja(String cnpj) {
		int i;
		int size=dadosLoja.lerDadosLoja().size();
		for (i = 0; i < size; i++) {
			if (cnpj.equals(dadosLoja.lerDadosLoja().get(i).getCnpj())) {
				break;
			}
		}
		return i;
	}
	
	public DadosLoja getDadosLoja() {
		return dadosLoja;
	}
	public void setDadosLoja(DadosLoja dadosLoja) {
		this.dadosLoja = dadosLoja;
	}
}
