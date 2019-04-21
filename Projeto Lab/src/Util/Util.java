package Util;

public class Util {
	
public static String formatarCPF(String cpf) {
	cpf = cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9,11);	
	return cpf;
	}
public static String formatarCEP(String cep) {
	cep = cep.substring(0, 5) + "-" + cep.substring(5, 8);
	return cep;
}
public static String formatarDataNascimento(String data) {
	data = data.substring(0, 2) + "/" + data.substring(2, 4) + "/" + data.substring(4, 8);
	return data;
}
public static String formatarCNPJ(String cnpj) {
	cnpj = cnpj.substring(0, 2) + "." + cnpj.substring(2, 5) + "." + cnpj.substring(5, 8) + "/" + cnpj.substring(8,12) + "-" + cnpj.substring(12,14);
	return cnpj;
}
public static String formatarNumeroCartao(String numerocartao) {
	numerocartao = "************"+ numerocartao.substring(12, 16);
	return numerocartao;
}
public static String formatarDataCartao(String data) {
	data = data.substring(0, 2) + "/" + data.substring(2, 4);
	return data;
}
}
