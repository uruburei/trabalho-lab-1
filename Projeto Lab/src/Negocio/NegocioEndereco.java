package Negocio;

import java.util.Scanner;

public class NegocioEndereco {
	Scanner sc = new Scanner(System.in);
	public String validarCEP(String cep) {
		//vai verificar se o cep não tem letras e se tem tamanho 8 ex.(50060070) e retorna corrigido
			while (!cep.matches("\\d{8}")) {
				System.out.println("Numero do cep invalido, por favor digite corretamente: ");
				cep = sc.next();
			}
			System.out.println("numero do cep valido.");
			return cep;
	}
}
