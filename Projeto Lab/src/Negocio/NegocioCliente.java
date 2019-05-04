package Negocio;

import Dados.DadosCliente;
import Entidades.Cliente;

/*
 * essa classe tem como o objetivo de validar os dados do cliente
 * como: 
 * validar criação de um novo cliente
 * validadar altaração de dados dos clientes
 * buscar cliente
 * Validar remoção do cliente
 * 
 */

public class NegocioCliente {
    private DadosCliente dadoscliente = new DadosCliente();
    
    //validar cadastro do cliente
    public boolean CadastroCliente(Cliente cliente) {
        dadoscliente.receberDadosCliente(cliente);
        return true;
    }
    
    //buscar cliente 
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
    
    //alterar dados do cliente
    public boolean alterarCliente(Cliente cliente, int i) {
        dadoscliente.alterarDadosCliente(i, cliente);
        return true;
    }

    //remover dados do cliente
    public boolean removerCliente(int i){
        dadoscliente.removerDadosCliente(i);
        return true;
    }
    
    public DadosCliente getDadoscliente() {
        return dadoscliente;
    }

    public void setDadoscliente(DadosCliente dadoscliente) {
        this.dadoscliente = dadoscliente;
    }

}
