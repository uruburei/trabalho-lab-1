package Apresentaçao;

import Entidades.*;
import Negocio.NegocioEndereco;
import Negocio.NegocioLoja;
import Negocio.NegocioPessoa;
import Util.Util;

import java.util.ArrayList;
import java.util.Scanner;

public class LojaApresentacao {
    private Scanner sc = new Scanner(System.in);
    public NegocioLoja negocioloja = new NegocioLoja();
    public NegocioEndereco negocioendereco = new NegocioEndereco();
    private int i=0;

    public void CadastrarLoja() {
        System.out.println("------------------------------cadastro loja---------------------------------");
        System.out.println("\n*************************Endereço*************************************");

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
        cep = negocioendereco.validarCEP(cep);//O metodo vai validar o cep e retorna corrigido

        System.out.println("\n*************************Dados da Loja*************************************");
        sc.nextLine();
        System.out.println("Informe o nome da sua loja: ");
        String nome = sc.nextLine();
        System.out.println("informe o cnpj da loja: ");
        String cnpj = sc.next();
        cnpj = negocioloja.validarCNPJ(cnpj);//O metodo vai validar o cnpj e retornar corrigido
        System.out.println("informe quando sua loja foi criada: ");
        String data = sc.next();
        data = negocioloja.validarDataCriacao(data);//O metodo vai validar a data e retornar corrigido
        Endereco endereco = new Endereco(lugadouro, cep, numero, bairro, cidade, estado);
        Loja loja = new Loja(nome, cnpj, data, endereco);


        System.out.println("\n*************************cadastrar Produtos*************************************");
        Produtoo [] produtoos =loja.cadastrarProduto();

        System.out.println("\n*************************Cadastrar Funcionarios*************************************");
        ArrayList<Funcionario> funcionarios= loja.cadastrarFuncionario();
        loja = new Loja(nome, cnpj, data, endereco,produtoos,funcionarios);

        //negocioloja.CadstrarLoja(loja);
        negocioloja.CadstrarLoja(loja);
    }

    public int logarLoja() {
        System.out.println("Informe o CNPJ da loja");
        String cnpj = sc.next();
        int i = negocioloja.Verificarloja(cnpj);
        return i;
    }

    public void InterfaceDadosLoja() {
        System.out.println("-----------------------------------Dados Loja--------------------------------------------\n"
                + "Nome: " + negocioloja.getDadosLoja().lerDadosLoja().get(i).getNome() + "\n"
                + "CNPJ: " + Util.formatarCNPJ(negocioloja.getDadosLoja().lerDadosLoja().get(i).getCnpj()) + "\n"
                + "Data de criação: " + Util.formatarDataNascimento(negocioloja.getDadosLoja().lerDadosLoja().get(i).getData()) + "\n");
        System.out.println("Deseja obter os dados dos seus produtos? ");
        String opcprodutos = sc.next().toLowerCase();
        if (opcprodutos.equals("sim")) {
            System.out.println("-----------------------------------Dados Produtos--------------------------------------------\n");
            for (int j = 0; j < negocioloja.getDadosLoja().lerDadosLoja().get(i).getProduto().length; j++) {
                System.out.println("nome: " + negocioloja.getDadosLoja().lerDadosLoja().get(i).getProduto()[j].getNome() + "\n"
                        + "preço: " + negocioloja.getDadosLoja().lerDadosLoja().get(i).getProduto()[j].getValor() + "\n"
                        + "codigo: " + negocioloja.getDadosLoja().lerDadosLoja().get(i).getProduto()[j].getCodigoproduto() + "\n");
            }
        }
        System.out.println("Deseja obter os dados dos seus funcionarios? ");
        String opcfuncionario = sc.next().toLowerCase();
        if (opcfuncionario.equals("sim")) {
            System.out.println("-----------------------------------Dados Funcionarios--------------------------------------------\n");
            int size=negocioloja.getDadosLoja().lerDadosLoja().get(i).getFucionario().size();
            for (int j = 0; j < size; j++) {
                System.out.println("Nome: " + negocioloja.getDadosLoja().lerDadosLoja().get(i).getFucionario().get(j).getNome() + "\n"
                        + "Data de nascimento: " + Util.formatarDataNascimento(negocioloja.getDadosLoja().lerDadosLoja().get(i).getFucionario().get(j).getData()) + "\n"
                        + "CPF: " + Util.formatarCPF(negocioloja.getDadosLoja().lerDadosLoja().get(i).getFucionario().get(j).getCpf()) + "\n"
                        + "Salario: " + negocioloja.getDadosLoja().lerDadosLoja().get(i).getFucionario().get(j).getSalario() + "R$\n"
                        + "salario liquido: " + negocioloja.getDadosLoja().lerDadosLoja().get(i).getFucionario().get(j).calcularSalarioLiquido() + "\n");
            }
        }
    }

    public void AlterarDados() {
        System.out.println("\n*************************Dados da Loja*************************************");
        System.out.println("Informe o nome de sua loja: ");
        String nome = sc.next();
        System.out.println("informe o cnpj da loja: ");
        String cnpj2 = sc.next();
        cnpj2 = negocioloja.validarCNPJ(cnpj2);//O metodo vai validar o cnpj e retornar corrigido
        System.out.println("informe quando sua loja foi criada: ");
        String data = sc.next();
        data = negocioloja.validarDataCriacao(data);//o metodo vai validar a data e retornar corrigido
        System.out.println("\n*************************Endereço*************************************");
        System.out.println("Lugadouro: ");
        String lugadouro = sc.next();
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
        cep = negocioendereco.validarCEP(cep);//O metodo vai validar o cep e retornar corrigido
        Endereco endereco = new Endereco(lugadouro, cep, numero, bairro, cidade, estado);
        Loja loja = new Loja(nome, cnpj2, data, endereco);
        System.out.println("Alterar produtos e funcionarios?");
        String opalterarPro = sc.next().toLowerCase();
        if (opalterarPro.equals("sim")) {
            Produtoo[] produto =loja.cadastrarProduto();
            ArrayList<Funcionario> fucionario =  loja.cadastrarFuncionario();
           loja = new Loja(nome, cnpj2, data, endereco,produto,fucionario);
        }
        negocioloja.alterarLoja(loja,i);
    }

    public void removerDados(){
        int j = logarLoja();
        System.out.println("*Deseja deletar a loja ? s/n");
        String escolha = sc.next();
        if (escolha.equals("s")){
            negocioloja.removerLoja(j);
        }else{
            System.out.println("Cancelando operação");
        }
    }
}
