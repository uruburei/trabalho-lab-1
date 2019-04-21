package Entidades;

public class Funcionario extends Pessoa {
    private String setor;
    private double salario, imposto;

    public Funcionario(String nome, String cpf, String data, String setor, double salario, double imposto) {
        super(nome, cpf, data);
        this.setor = setor;
        this.salario = salario;
        this.imposto = imposto / 100;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getImposto() {
        return imposto;
    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }

    public double calcularSalarioLiquido() {
        return salario - (salario * imposto);
    }
}
