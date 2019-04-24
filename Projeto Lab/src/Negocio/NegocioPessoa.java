package Negocio;

import java.util.Scanner;

public class NegocioPessoa {
	Scanner sc = new Scanner (System.in);
	public String validarCPF(String cpf) {
		//vai validar o cpf e verificar se n tem letras e tem mais/menos que 11 de tamanho e retorna corrigido
		while (!cpf.matches("\\d{11}")) {
			System.out.println("cpf invalido, por favor digite corretamente: ");
			cpf = sc.next();
		}
		System.out.println("cpf valido!");
		return cpf;
	}
	public String validarDataNascimento(String datanascimento) {
		int data;
		data = Integer.parseInt(datanascimento.substring(4, 8));
		data = 2018 - data;
		//vai validar a data pra ver se n tem letras e tamanho 2/2/4 ex.(20/05/2000) e retorna corrigido
		while (!datanascimento.matches("\\d{2}/\\d{2}/\\d{4}") && data< 18) {
			System.out.println("data de nascimento invalida, por favor digite corretamente: ");
			datanascimento = sc.next();
		}
		System.out.println("data de nascimento valida!");
		return datanascimento;
	}
}
