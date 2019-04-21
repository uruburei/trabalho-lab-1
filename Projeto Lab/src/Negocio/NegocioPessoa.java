package Negocio;

import java.util.Scanner;

public class NegocioPessoa {
	Scanner sc = new Scanner (System.in);
	public String validarCPF(String cpf) {
		while (cpf.length() != 11) {
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
		while (datanascimento.length() != 8 && data< 18) {
			System.out.println("data de nascimento invalida, por favor digite corretamente: ");
			datanascimento = sc.next();
		}
		System.out.println("data de nascimento valida!");
		return datanascimento;
	}
}
