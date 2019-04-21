package Negocio;

import java.util.Scanner;

public class NegocioEndereco {
	Scanner sc = new Scanner(System.in);
	public void validarCEP(String cep) {
		if (cep.length()!= 8) {
			while (cep.length() != 8) {
				System.out.println("Numero do cep invalido, por favor digite corretamente: ");
				cep = sc.next();
			}
		}else {
			System.out.println("numero do cep valido.");
		}
	
	}
}
