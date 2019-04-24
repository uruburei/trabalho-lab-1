package Negocio;

import java.util.Scanner;

/*
 * essa classe tem como o objetivo de validar os dados do endereço
 * como: 
 * 
 * validar o cep
 * 
 */

public class NegocioEndereco {
	private Scanner sc = new Scanner(System.in);
	
	//validar cep
	public void validarCEP(String cep) {
		boolean f = cep.matches("\\d{8}");
		if (f == false) {
			while (f == false) {
				System.out.println("Numero do cep invalido, por favor digite corretamente: ");
				cep = sc.next();
				f = cep.matches("\\d{8}");
			}
		}
			System.out.println("numero do cep valido.");
	
	}
}
