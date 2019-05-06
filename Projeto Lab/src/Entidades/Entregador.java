package Entidades;

import java.io.Serializable;

public class Entregador extends Funcionario implements Serializable {

    private double gorjeta;

    public Entregador(String nome, String cpf, String data, double salario, double imposto) {
        super(nome, cpf, data, "entregas", salario, imposto);

    }

    public double getGorjeta() {
        return gorjeta;
    }

    public void setGorjeta(double gorjeta) {
        this.gorjeta = gorjeta;
    }

    public double calcularSalarioLiquido() {
        return calcularSalarioLiquido() + gorjeta;
    }
}
