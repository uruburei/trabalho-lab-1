package Negocio;

import java.util.Scanner;

/*
 * essa classe tem como o objetivo de validar os dados de pessoa
 * como: 
 * validar cpf
 * data de nascimento
 */

public class NegocioPessoa {
	
	private Scanner sc = new Scanner (System.in);
	
	//validar cpf
	public void validarCPF(String cpf) {
		boolean f = cpf.matches("\\d{11}");
		while (f == false) {
			System.out.println("cpf invalido, por favor digite corretamente: ");
			cpf = sc.next();
			f = cpf.matches("\\d{11}");
		}
		System.out.println("cpf valido!");
	}
	
	//validar data de nascimento
	public void validarDataNascimento(String datanascimento) {
		int data;
		data = Integer.parseInt(datanascimento.substring(4, 8));
		data = 2018 - data;
		boolean f = datanascimento.matches("\\d{8}");
		while (datanascimento.length() != 8 && data< 18) {
			System.out.println("data de nascimento invalida, por favor digite corretamente: ");
			datanascimento = sc.next();
			data = Integer.parseInt(datanascimento.substring(4, 8));
			data = 2018 - data;
			f = datanascimento.matches("\\d{8}");
		}
		System.out.println("data de nascimento valida!");
	}
}
