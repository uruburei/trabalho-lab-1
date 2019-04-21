package Entidades;

public class Produtoo {
	private String nome;
	private int codigoproduto;
	private double valor;
	public Produtoo(String nome, double d, int codigoproduto) {
		this.nome = nome;
		this.valor = d;
		this.codigoproduto = codigoproduto;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public void setCodigoproduto(int codigoproduto) {
		this.codigoproduto = codigoproduto;
	}
	public String getNome() {
		return nome;
	}
	public double getValor() {
		return valor;
	}
	public int getCodigoproduto() {
		return codigoproduto;
	}
	
}
