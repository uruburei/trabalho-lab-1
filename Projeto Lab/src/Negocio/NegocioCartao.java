package Negocio;
import java.util.Scanner;
/*
 * essa classe tem como o objetivo de validar os dados obtidos do cartão
 * como: 
 * Numero do cartão
 * validade do cartão
 * codigo de segurança
 * 
 */

public class NegocioCartao {
	private Scanner sc = new Scanner(System.in);
	
	//metodo para validar o numero do cartão
	public void validarNumero(String numerocartao) {
		boolean f = numerocartao.matches("\\d{4}");
		if (f == false) {
			while (f == false) {
				System.out.println("Numero do cartao errado, por favor digite corretamente: ");
				numerocartao = sc.next();
				f = numerocartao.matches("\\d{4}");
			}
		}
			System.out.println("numero do cartao valido.");
		

	}
	
	//metodo para validar a data de validade
	public void validarDatadeValidade(String s) {
		boolean f = s.matches("\\d{4}");
		if (f == false ) {
			while (f == false ) {
				System.out.println("A validade do cartao esta errada, por favor digite corretamente: ");
				s = sc.next();
				f = s.matches("\\d{0,4}");
			}
		}
		System.out.println("Data de validade do cartao esta valida.");
	}
	
	//metodo para validar o codigo de seguranca
	public void validarCodigoDeSeguranca(int codigodeseguranca) {
		String s = Integer.toString(codigodeseguranca);
		boolean f = s.matches("\\d{3}");
		if (f == false) {
			while (f == false) {
				System.out.println("O codido de segurança do cartao esta errado, por favor digite corretamente: ");
				codigodeseguranca = sc.nextInt();
				s = Integer.toString(codigodeseguranca);
				f = s.matches("\\d{3}");
			}
		}
			System.out.println("O codigo de segurança do cartao esta valido.");
	}
}