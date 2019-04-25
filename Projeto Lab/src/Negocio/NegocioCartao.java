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
	
	//vai verificar se tem 16 numeros e nem uma letra ex.(1478523698521478) e retorna corrigido
	public String validarNumero(String numerocartao) {
		while (!numerocartao.matches("\\d{16}")) {
				System.out.println("Numero do cartao errado, por favor digite corretamente: ");
				numerocartao = sc.next();
			}
			System.out.println("numero do cartao valido.");
			return numerocartao;
	}
  
  //vai verificar se a data esta correta exemplo ex.(12/22) e retorna corrigido
	public String validarDatadeValidade(String s) {
			while (!s.matches("\\d{2}/\\d{2}")) {
				System.out.println("A validade do cartao esta errada, por favor digite corretamente: ");
				s = sc.next();
			}
			System.out.println("Data de validade do cartao esta valida.");
			return s;
	}
  
  //vai verificar o codigo de segurança se tem 3 numeros e não letrar ex.(325) e retorna corrigido
	public int validarCodigoDeSeguranca(int codigodeseguranca) {
		String s = Integer.toString(codigodeseguranca);
			while (!s.matches("\\d{3}")) {
				System.out.println("O codido de segurança do cartao esta errado, por favor digite corretamente: ");
				codigodeseguranca = sc.nextInt();
				s = Integer.toString(codigodeseguranca);
			}
			System.out.println("O codigo de segurança do cartao esta valido.");
			return Integer.parseInt(s);
	}
}