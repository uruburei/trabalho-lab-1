package Negocio;

import Dados.DadosCliente;
import Entidades.Cliente;

/*
 * essa classe tem como o objetivo de validar os dados do cliente
 * como: 
 * Numero do cartão
 * validade do cartão
 * codigo de segurança
 * 
 */

public class NegocioCliente {
    private DadosCliente dadoscliente = new DadosCliente();

    public boolean CadastroCliente(Cliente cliente) {
        dadoscliente.receberDadosLoja(cliente);
        return true;
    }

    public int Verificarcliente(String cpf, String senha) {
        int i;
        int size = dadoscliente.lerDadosCliente().size();
        for (i = 0; i < size; i++) {
            if (cpf.equals(dadoscliente.lerDadosCliente().get(i).getCpf()) && senha.equals(dadoscliente.lerDadosCliente().get(i).getSenha())) {
                break;
            }
        }
        return i;
    }
    
    public boolean alterarCliente(Cliente cliente, int i) {
        dadoscliente.alterarDados(i, cliente);
        return true;
    }

    public DadosCliente getDadoscliente() {
        return dadoscliente;
    }

    public void setDadoscliente(DadosCliente dadoscliente) {
        this.dadoscliente = dadoscliente;
    }

}
