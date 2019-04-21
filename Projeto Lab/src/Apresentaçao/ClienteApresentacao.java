package Apresentaçao;

import Entidades.Cartao;
import Entidades.Cliente;
import Entidades.Endereco;
import Negocio.NegocioCartao;
import Negocio.NegocioCliente;
import Negocio.NegocioEndereco;
import Util.Util;

import java.util.Scanner;

public class ClienteApresentacao {
    private Scanner sc = new Scanner(System.in);
    public NegocioCliente negociocliente = new NegocioCliente();
    public NegocioCartao negociocartao = new NegocioCartao();
    public NegocioEndereco negocioendereco = new NegocioEndereco();

    public void CadastrarCliente() {
        System.out.println("*******************************Cadastrar Cliente*********************************\n");
        System.out.println("------------------------------Endereço------------------------------------------\n");
        System.out.println("Lugadouro: ");
        String lugadouro = sc.nextLine();
        System.out.println("Numero: ");
        String numero = sc.next();
        System.out.println("Bairro: ");
        String bairro = sc.next();
        System.out.println("Cidade: ");
        String cidade = sc.next();
        System.out.println("Estado: ");
        String estado = sc.next();
        System.out.println("CEP: ");
        String cep = sc.next();
        negocioendereco.validarCEP(cep);
        Endereco endereco = new Endereco(lugadouro, cep, numero, bairro, cidade, estado);
        System.out.println("\n----------------------------------Dados Cliente-----------------------------------");
        sc.nextLine();
        System.out.println("Nome: ");
        String nome = sc.nextLine();
        System.out.println("Data de nascimento: ");
        String data = sc.next();
        System.out.println("CPF: ");
        String cpf = sc.next();
        System.out.println("Senha: ");
        String senha = sc.next();
        System.out.println("deseja cadastrar o cartão? ");
        String opc = sc.next().toLowerCase();
        Cliente cliente;
        if (opc.equals("sim")) {
            System.out.println("\n----------------------------------Dados Cartão-----------------------------------");
            sc.nextLine();
            System.out.println("Nome do Titular do Cartao: ");
            String nometitular = sc.nextLine();
            System.out.println("Número do Cartão: ");
            String numerocartao = sc.next();
            negociocartao.validarNumero(numerocartao);
            System.out.println("data de validade: ");
            String datavalidade = sc.next();
            negociocartao.validarDatadeValidade(datavalidade);
            System.out.println("código de segurança: ");
            int codigoseguranca = sc.nextInt();
            negociocartao.validarCodigoDeSeguranca(codigoseguranca);
            System.out.println("Limite: ");
            double limite = sc.nextDouble();
            Cartao cartao = new Cartao(nometitular, numerocartao, datavalidade, codigoseguranca, limite);
            cliente = new Cliente(nome, cpf, data, cartao, endereco, senha);

        } else {
            cliente = new Cliente(nome, cpf, data, endereco, senha);
        }
        negociocliente.CadastroCliente(cliente);
    }

    public void InterfaceDadosCliente() {
        System.out.println("informe seu  CPF: ");
        String cpf = sc.next();
        System.out.println("informe sua senha: ");
        String senha = sc.next();
        int i = negociocliente.Verificarcliente(cpf, senha);
        System.out.println("*******************************************Dados do Cliente************************************\n");
        System.out.println("Nome: " + negociocliente.getDadoscliente().lerDadosCliente().get(i).getNome() + "\n"
                + "Data de Nascimento: " + Util.formatarDataNascimento(negociocliente.getDadoscliente().lerDadosCliente().get(i).getData()) + "\n"
                + "CPF: " + Util.formatarCPF(negociocliente.getDadoscliente().lerDadosCliente().get(i).getCpf()) + "\n");
        System.out.println("-deseja obter informações sobre o endereço? ");
        String opc = sc.next().toLowerCase();
        if (opc.equals("sim")) {
            System.out.println("***************************************Dados Endereço Cliente******************************\n");
            System.out.println("Lugadouro: " + negociocliente.getDadoscliente().lerDadosCliente().get(i).getEndereco().getLugadouro() + "\n"
                    + "Nº: " + negociocliente.getDadoscliente().lerDadosCliente().get(i).getEndereco().getNumeroResidencia() + "\n"
                    + "Bairro: " + negociocliente.getDadoscliente().lerDadosCliente().get(i).getEndereco().getBairro() + "\n"
                    + "Cidade: " + negociocliente.getDadoscliente().lerDadosCliente().get(i).getEndereco().getCidade() + "\n"
                    + "Estado: " + negociocliente.getDadoscliente().lerDadosCliente().get(i).getEndereco().getEstado() + "\n"
                    + "CEP: " + Util.formatarCEP(negociocliente.getDadoscliente().lerDadosCliente().get(i).getEndereco().getCep()) + "\n");
        }
        System.out.println("-deseja obter informações do cartão? ");
        opc = sc.next().toLowerCase();
        if (opc.equals("sim")) {
            if (negociocliente.getDadoscliente().lerDadosCliente().get(i).getCartao() != null) {
                System.out.println("***************************************Dados Cartão Cliente******************************");
                System.out.println("Nome do Titular: " + negociocliente.getDadoscliente().lerDadosCliente().get(i).getCartao().getNometitular() + "\n"
                        + "Número do cartao: " + Util.formatarNumeroCartao(negociocliente.getDadoscliente().lerDadosCliente().get(i).getCartao().getNumerocartao()) + "\n"
                        + "Validade: " + Util.formatarDataCartao(negociocliente.getDadoscliente().lerDadosCliente().get(i).getCartao().getValidade()) + "\n");
            } else {
                System.out.println("Cartão não cadastrado");
            }
        }
    }

    public void AlterarDados() {
        System.out.println("informe seu  CPF: ");
        String cpf = sc.next();
        System.out.println("informe sua senha: ");
        String senha = sc.next();
        int i = negociocliente.Verificarcliente(cpf, senha);
        System.out.println("*Alterar* dados Nome, Data de nascimento, Cpf ou Senha?");
        String opBasico = sc.next().toLowerCase();
        if (opBasico.equals("sim")) {
            System.out.println("\n----------------------------------Dados Cliente-----------------------------------");
            sc.nextLine();
            System.out.println("Nome: ");
            String nome = sc.nextLine();
            System.out.println("Data de nascimento: ");
            String data = sc.next();
            System.out.println("CPF: ");
            String cpf2 = sc.next();
            System.out.println("Senha: ");
            String senha2 = sc.next();
            negociocliente.getDadoscliente().lerDadosCliente().get(i).setNome(nome);
            negociocliente.getDadoscliente().lerDadosCliente().get(i).setData(data);
            negociocliente.getDadoscliente().lerDadosCliente().get(i).setCpf(cpf2);
            negociocliente.getDadoscliente().lerDadosCliente().get(i).setSenha(senha2);
        }
        System.out.println("*Alterar* endereço ?");
        String opEndereço = sc.next().toLowerCase();
        if (opEndereço.equals("sim")) {
            System.out.println("------------------------------Endereço------------------------------------------\n");
            sc.nextLine();
            System.out.println("Lugadouro: ");
            String lugadouro = sc.nextLine();
            System.out.println("Numero: ");
            String numero = sc.next();
            System.out.println("Bairro: ");
            String bairro = sc.next();
            System.out.println("Cidade: ");
            String cidade = sc.next();
            System.out.println("Estado: ");
            String estado = sc.next();
            System.out.println("CEP: ");
            String cep = sc.next();
            negocioendereco.validarCEP(cep);
            Endereco endereco = new Endereco(lugadouro, cep, numero, bairro, cidade, estado);
            negociocliente.getDadoscliente().lerDadosCliente().get(i).setEndereco(endereco);
        }
        System.out.println("*Alterar* dados do cartão ?");
        String opAltCartão = sc.next().toLowerCase();
        if (opAltCartão.equals("sim")) {
            System.out.println("\n----------------------------------Dados Cartão-----------------------------------");
            System.out.println("Nome do Titular do Cartao: ");
            String nometitular = sc.nextLine();
            System.out.println("Número do Cartão: ");
            String numerocartao = sc.next();
            negociocartao.validarNumero(numerocartao);
            System.out.println("data de validade: ");
            String datavalidade = sc.next();
            negociocartao.validarDatadeValidade(datavalidade);
            System.out.println("código de segurança: ");
            int codigoseguranca = sc.nextInt();
            negociocartao.validarCodigoDeSeguranca(codigoseguranca);
            System.out.println("Limite: ");
            double limite = sc.nextDouble();
            Cartao cartao = new Cartao(nometitular, numerocartao, datavalidade, codigoseguranca, limite);
            negociocliente.getDadoscliente().lerDadosCliente().get(i).setCartao(cartao);
        }
    }
}
