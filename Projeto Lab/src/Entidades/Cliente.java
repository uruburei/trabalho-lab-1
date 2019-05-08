package Entidades;

import java.io.Serializable;

public class Cliente extends Pessoa implements Serializable {
    private Cartao cartao;
    private Endereco endereco;
    private String senha;

    public Cliente(String nome, String cpf, String data, Cartao cartao, Endereco endereco, String senha) {
        super(nome, cpf, data);
        this.cartao = cartao;
        this.endereco = endereco;
        this.senha = senha;
    }

    public Cliente(String nome, String cpf, String data, Endereco endereco, String senha) {
        super(nome, cpf, data);
        this.endereco = endereco;
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

}
