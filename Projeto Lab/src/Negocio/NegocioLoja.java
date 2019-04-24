package Negocio;

import java.util.Scanner;

import Dados.DadosLoja;
import Entidades.Loja;

public class NegocioLoja {

	Scanner sc = new Scanner(System.in);
	private DadosLoja dadosLoja = new DadosLoja();


	public String validarCNPJ(String cnpj) {
		//vai validar o cnpj pra ver se n tem letras e é menor/maior  que 14,e retorna corrigido ex.(15748596325698)
		while (!cnpj.matches("\\d{14}")) {
			System.out.println("cnpj invalido, por favor digite corretamente: ");
			cnpj = sc.next();
		}

		System.out.println("cnpj valido!");
		return cnpj;
	}

	public String validarDataCriacao(String datacriacao) {
		//vai validar a data pra ver se n tem letras e tamanho 2/2/4 ex.(20/05/2000) e retorna corrigido
		while (!datacriacao.matches("\\d{2}/\\d{2}/\\d{4}")) {
			System.out.println("data invalida, por favor digite corretamente: ");
			datacriacao = sc.next();
		}
		System.out.println("data valida!");
		return datacriacao;
	}

	public boolean CadstrarLoja(Loja loja) {
		dadosLoja.receberDadosLoja(loja);
		return true;
	}

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
