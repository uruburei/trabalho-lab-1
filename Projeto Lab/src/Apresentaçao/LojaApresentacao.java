package Apresentaçao;

import Entidades.*;
import Negocio.NegocioEndereco;
import Negocio.NegocioLoja;
import Negocio.NegocioPessoa;
import Util.Util;

import java.util.ArrayList;
import java.util.Scanner;

public class LojaApresentacao {
    Scanner sc = new Scanner(System.in);

    public NegocioLoja negocioloja = new NegocioLoja();
    public NegocioEndereco negocioendereco = new NegocioEndereco();

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
        if (negocioloja.CadstrarLoja(loja) == true) {
            System.out.println("loja cadastrada!");
        }
    }

    public void InterfaceDadosLoja() {
        System.out.println("Informe o CNPJ da loja");
        String cnpj = sc.next();
        int i = negocioloja.Verificarloja(cnpj);
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
        System.out.println("Informe o CNPJ da loja");
        String cnpj = sc.next();
        int i = negocioloja.Verificarloja(cnpj);
        System.out.println("Alterar dados (nome,cnpj,data) ?");
        String opcBasico = sc.next().toLowerCase();
        if (opcBasico.equals("sim")) {
            System.out.println("\n*************************Dados da Loja*************************************");
            System.out.println("Informe o nome de sua loja: ");
            String nome = sc.next();
            System.out.println("informe o cnpj da loja: ");
            String cnpj2 = sc.next();
            cnpj2 = negocioloja.validarCNPJ(cnpj2);//O metodo vai validar o cnpj e retornar corrigido
            System.out.println("informe quando sua loja foi criada: ");
            String data = sc.next();
            data = negocioloja.validarDataCriacao(data);//o metodo vai validar a data e retornar corrigido
            negocioloja.getDadosLoja().lerDadosLoja().get(i).setNome(nome);
            negocioloja.getDadosLoja().lerDadosLoja().get(i).setCnpj(cnpj2);
            negocioloja.getDadosLoja().lerDadosLoja().get(i).setData(data);
        }

        System.out.println("Alterar endereço da loja ?");
        String opalterar = sc.next().toLowerCase();
        if (opalterar.equals("sim")) {
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
            negocioloja.getDadosLoja().lerDadosLoja().get(i).setEndereco(endereco);
        }
        System.out.println("Alterar produtos?");
        String opalterarPro = sc.next().toLowerCase();
        if (opalterarPro.equals("sim")) {
            Produtoo[] produto = new Produtoo[3];
            for (int j = 0; j < produto.length; j++) {
                System.out.println("nome do produto: ");
                String nomep = sc.next();
                System.out.println("codigo do produto: ");
                int codigop = sc.nextInt();
                System.out.println("valor do produto: ");
                double valorp = sc.nextDouble();
                produto[j] = new Produtoo(nomep, valorp, codigop);
            }
            negocioloja.getDadosLoja().lerDadosLoja().get(i).setProduto(produto);
        }
        System.out.println("Alterar funcionarios?");
        String opalterarfun = sc.next().toLowerCase();
        if (opalterarfun.equals("sim")) {
            ArrayList<Funcionario> fucionario = new ArrayList<Funcionario>(2);
            int size = fucionario.size();
            for (int j = 0; j < size; j++) {
                NegocioPessoa validarpessoa = new NegocioPessoa();
                System.out.println("nome do funcionario: ");
                String nomef = sc.next();
                System.out.println("cpf do funcionario: ");
                String cpff = sc.next();
                cpff = validarpessoa.validarCPF(cpff);//O metodo vai validar o cpf e retornar corrigido
                System.out.println("informe a data de nascimento do funcionario: ");
                String dataf = sc.next();
                dataf = validarpessoa.validarDataNascimento(dataf);//O metodo vai validar a data e retornar corrigido
                System.out.println("informe o setor do funcionario: ");
                String setorf = sc.next();
                System.out.println("informe o salario bruto do funcionario: ");
                double salariof = sc.nextDouble();
                System.out.println("informe quantos porcentos de imposto seram retirado do salario: ");
                double impostof = sc.nextDouble();
                if (setorf.equals("entregador")) {
                    fucionario.add(new Entregador(nomef, cpff, dataf, salariof, impostof));
                } else {
                    fucionario.add(new Funcionario(nomef, cpff, dataf, setorf, salariof, impostof));
                }
            }
            negocioloja.getDadosLoja().lerDadosLoja().get(i).setFucionario(fucionario);
        }
    }
}
