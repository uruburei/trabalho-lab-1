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
	Scanner sc = new Scanner(System.in);
  
	//vai verificar se o cep nÃ£o tem letras e se tem tamanho 8 ex.(50060070) e retorna corrigido
	public String validarCEP(String cep) {
			while (!cep.matches("\\d{8}")) {
				System.out.println("Numero do cep invalido, por favor digite corretamente: ");
				cep = sc.next();
			}
			System.out.println("numero do cep valido.");
			return cep;
	}
	public boolean validarCEPGrafico(String cep) {
		return (cep.matches("\\d{8}"));
	}
}
