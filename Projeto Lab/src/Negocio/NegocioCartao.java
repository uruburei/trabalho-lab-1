package Negocio;
import java.util.Scanner;

public class NegocioCartao {
	Scanner sc = new Scanner(System.in);
	public void validarNumero(String numerocartao) {
		if (numerocartao.length()!= 16) {
			while (numerocartao.length() != 16) {
				System.out.println("Numero do cartao errado, por favor digite corretamente: ");
				numerocartao = sc.next();
			}
		}else {
			System.out.println("numero do cartao valido.");
		}

	}
	public void validarDatadeValidade(String s) {
		if (s.length()!= 4) {
			while (s.length() != 4) {
				System.out.println("A validade do cartao esta errada, por favor digite corretamente: ");
				s = sc.next();
			}
		}else {
			System.out.println("Data de validade do cartao esta valida.");
		}

	}
	public void validarCodigoDeSeguranca(int codigodeseguranca) {
		String s = Integer.toString(codigodeseguranca);
		if (s.length()!= 3) {
			while (s.length() != 3) {
				System.out.println("O codido de segurança do cartao esta errado, por favor digite corretamente: ");
				codigodeseguranca = sc.nextInt();
				s = Integer.toString(codigodeseguranca);
			}
		}else {
			System.out.println("O codigo de segurança do cartao esta valido.");
		}

	}
}