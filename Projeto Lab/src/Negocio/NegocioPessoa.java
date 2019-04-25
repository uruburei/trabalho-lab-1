package Negocio;

import java.util.Scanner;

/*
 * essa classe tem como o objetivo de validar os dados de pessoa
 * como: 
 * validar cpf
 * data de nascimento
 */

public class NegocioPessoa {
	Scanner sc = new Scanner (System.in);
  
  //vai validar o cpf e verificar se n tem letras e tem mais/menos que 11 de tamanho e retorna corrigido
	public String validarCPF(String cpf) {
		while (!cpf.matches("\\d{11}")) {
			System.out.println("cpf invalido, por favor digite corretamente: ");
			cpf = sc.next();
		}
		System.out.println("cpf valido!");
	}
	
	//validar data de nascimento
	public void validarDataNascimento(String datanascimento) {
		int data;
		data = Integer.parseInt(datanascimento.substring(4, 8));
		data = 2018 - data;
		while (!datanascimento.matches("\\d{8}") && data< 18)) {
			System.out.println("data de nascimento invalida, por favor digite corretamente: ");
			datanascimento = sc.next();
			data = Integer.parseInt(datanascimento.substring(4, 8));
			data = 2018 - data;
		}
		System.out.println("data de nascimento valida!");
	}
}
