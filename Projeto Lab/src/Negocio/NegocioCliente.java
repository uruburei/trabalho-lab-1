package Negocio;

import Dados.DadosCliente;
import Entidades.Cliente;

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

    public DadosCliente getDadoscliente() {
        return dadoscliente;
    }

    public void setDadoscliente(DadosCliente dadoscliente) {
        this.dadoscliente = dadoscliente;
    }

}
