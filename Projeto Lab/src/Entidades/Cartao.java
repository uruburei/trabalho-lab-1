package Entidades;

import java.io.Serializable;

public class Cartao implements Serializable {
		private String nometitular;
		private String numerocartao;
		private String validade;
		private int codigoseguranca;
		private double limite;
		public Cartao(String nometitular, String numerocartao, String validade, int codigoseguranca, double limite) {
			this.nometitular = nometitular;
			this.numerocartao = numerocartao;
			this.validade = validade;
			this.codigoseguranca = codigoseguranca;
			this.limite = limite;
		}
		public String getNometitular() {
			return nometitular;
		}
		public double getLimite() {
			return limite;
		}
		public void setLimite(double limite) {
			this.limite = limite;
		}
		public String getNumerocartao() {
			return numerocartao;
		}
		public String getValidade() {
			return validade;
		}
		public int getCodigoseguranca() {
			return codigoseguranca;
		}
		public void setNometitular(String nometitular) {
			this.nometitular = nometitular;
		}
		public void setNumerocartao(String numerocartao) {
			this.numerocartao = numerocartao;
		}
		public void setValidade(String validade) {
			this.validade = validade;
		}
		public void setCodigoseguranca(int codigoseguranca) {
			this.codigoseguranca = codigoseguranca;
		}
		
}
