package Apresentacao;

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
    

    public void cadastrarLoja() { 
    	negocioloja.cadstrarLoja(criarLoja());
       

    }

    public int logarLoja() {
        System.out.println("Informe o CNPJ da loja");
        String cnpj = sc.next();
        int i = 0;
        String j = negocioloja.Verificarloja(cnpj);
        if (j == null){
            System.out.println("Loja não existe\nTente de novo\n");
            logarLoja();
        }else {
           i = Integer.parseInt(j);
        }
        return i;
    }

    public void InterfaceDadosLoja(int i) {
        System.out.println("-----------------------------------Dados Loja--------------------------------------------\n"
                + "Nome: " + negocioloja.getDadosLoja().lerDadosLoja().get(i).getNome() + "\n"
                + "CNPJ: " + Util.formatarCNPJ(negocioloja.getDadosLoja().lerDadosLoja().get(i).getCnpj()) + "\n"
                + "Data de criação: " + Util.formatarDataNascimento(negocioloja.getDadosLoja().lerDadosLoja().get(i).getData()) + "\n");
        System.out.println("Deseja obter os dados dos seus produtos? ");
        String opcprodutos = sc.next().toLowerCase();
        if (opcprodutos.equals("sim")) {
            System.out.println("-----------------------------------Dados Produtos--------------------------------------------\n");
            for (int j = 0; j < negocioloja.getDadosLoja().lerDadosLoja().get(i).getProduto().size(); j++) {
                System.out.println("nome: " + negocioloja.getDadosLoja().lerDadosLoja().get(i).getProduto().get(j).getNome() + "\n"
                        + "preço: " + negocioloja.getDadosLoja().lerDadosLoja().get(i).getProduto().get(j).getValor() + "\n"
                        + "codigo: " + negocioloja.getDadosLoja().lerDadosLoja().get(i).getProduto().get(j).getCodigoproduto() + "\n");
            }
        }
        System.out.println("Deseja obter os dados dos seus funcionarios? ");
        String opcfuncionario = sc.next().toLowerCase();
        if (opcfuncionario.equals("sim")) {
            int size = negocioloja.getDadosLoja().lerDadosLoja().get(i).getFucionario().size();
            System.out.println("-----------------------------------Dados Funcionarios--------------------------------------------\n");
            for (int j = 0; j < size; j++) {
                System.out.println("Nome: " + negocioloja.getDadosLoja().lerDadosLoja().get(i).getFucionario().get(j).getNome() + "\n"
                        + "Data de nascimento: " + Util.formatarDataNascimento(negocioloja.getDadosLoja().lerDadosLoja().get(i).getFucionario().get(j).getData()) + "\n"
                        + "CPF: " + Util.formatarCPF(negocioloja.getDadosLoja().lerDadosLoja().get(i).getFucionario().get(j).getCpf()) + "\n"
                        + "Salario: " + negocioloja.getDadosLoja().lerDadosLoja().get(i).getFucionario().get(j).getSalario() + "R$\n"
                        + "salario liquido: " + negocioloja.getDadosLoja().lerDadosLoja().get(i).getFucionario().get(j).calcularSalarioLiquido() + "\n");
            }
        }
    }

    public void AlterarDados(int k) {
        System.out.println("\n*************************Dados da Loja*************************************");
        System.out.println("Informe o nome de sua loja: ");
        String nome = sc.next();
        System.out.println("informe o cnpj da loja: ");
        String cnpj2 = sc.next();
        cnpj2 = negocioloja.validarCNPJ(cnpj2);//O metodo vai validar o cnpj e retornar corrigido
        System.out.println("informe quando sua loja foi criada: ");
        String data = sc.next();
        data = negocioloja.validarDataCriacao(data);//o metodo vai validar a data e retornar corrigido
        System.out.println("\n*************************Endereco*************************************");
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
        ArrayList<Produtoo> proAnterior = negocioloja.getDadosLoja().lerDadosLoja().get(k).getProduto();
        ArrayList<Funcionario> funcAnterior = negocioloja.getDadosLoja().lerDadosLoja().get(k).getFucionario();
        Loja loja = new Loja(nome, cnpj2, data, endereco,proAnterior,funcAnterior);
        System.out.println("Alterar produtos e funcionarios?");
        String opalterarPro = sc.next().toLowerCase();
        if (opalterarPro.equals("sim")) {
            ArrayList<Produtoo> produtoos = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                System.out.println("nome do produto: ");
                String nomep = sc.next();
                System.out.println("codigo do produto: ");
                int codigop = sc.nextInt();
                System.out.println("valor do produto: ");
                double valorp = sc.nextDouble();
                produtoos.add(new Produtoo(nomep, valorp, codigop));
                System.out.println("-----------------------------");
            }
            ArrayList<Funcionario> funcionarios= new ArrayList<>();
            for (int i = 0; i < 2; i++) {
                sc.nextLine();
                NegocioPessoa validarpessoa = new NegocioPessoa();
                System.out.println("nome do funcionario: ");
                String nomef = sc.nextLine();
                System.out.println("cpf do funcionario: ");
                String cpff = sc.next();
                validarpessoa.validarCPF(cpff);
                System.out.println("informe a data de nascimento do funcionario: ");
                String dataf = sc.next();
                validarpessoa.validarDataNascimento(dataf);
                System.out.println("informe o setor do funcionario: ");
                String setorf = sc.next();
                System.out.println("informe o salario bruto do funcionario: ");
                double salariof = sc.nextDouble();
                System.out.println("informe quantos porcentos de imposto seram retirado do salario: ");
                double impostof = sc.nextDouble();
                if (setorf.equals("entregador")) {
                    funcionarios.add(new Entregador(nomef, cpff, dataf, salariof, impostof));
                }else {
                    funcionarios.add(new Funcionario(nomef, cpff, dataf, setorf, salariof, impostof));
                }
            }
           loja = new Loja(nome, cnpj2, data, endereco,produtoos,funcionarios);
        }
        negocioloja.alterarLoja(loja,k);
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
    
    // metodo cadastra endereo
    public Endereco cadastroEndereco(){
    	 System.out.println("------------------------------cadastro loja---------------------------------");
    	 System.out.println("\n*************************Endereco*************************************");

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
         Endereco endereco = new Endereco(lugadouro, cep, numero, bairro, cidade, estado);
         return endereco;
         
    }
    
    // metodo para cadastra uma loja
    public Loja criarLoja() {
    	
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
         Endereco endereco = cadastroEndereco();
         ArrayList<Produtoo> produto = cadastroProdutos();
         ArrayList<Funcionario> funcionario =  cadastroFuncionarios();
         Loja loja =new Loja(nome, cnpj, data, endereco, produto, funcionario);
         return loja;
    }
         
        // metodo para cadastra produto
       public ArrayList<Produtoo> cadastroProdutos() {
    	   System.out.println("\n*************************cadastrar Produtos*************************************");
           ArrayList<Produtoo> produto = new ArrayList<>();
           for (int i = 0; i < 3; i++) {
               System.out.println("nome do produto: ");
               String nomep = sc.next();
               System.out.println("codigo do produto: ");
               int codigop = sc.nextInt();
               System.out.println("valor do produto: ");
               double valorp = sc.nextDouble();
               produto.add(new Produtoo(nomep, valorp, codigop));
               System.out.println("-----------------------------");
           }
    	   return produto;
           
       }
       
       // metodo para cadastra fucionario 
       public ArrayList<Funcionario> cadastroFuncionarios() {
    	   
    	   System.out.println("\n*************************Cadastrar Funcionarios*************************************");
           ArrayList<Funcionario> funcionarios= new ArrayList<>();
           for (int i = 0; i < 2; i++) {
               sc.nextLine();
               NegocioPessoa validarpessoa = new NegocioPessoa();
               System.out.println("nome do funcionario: ");
               String nomef = sc.nextLine();
               System.out.println("cpf do funcionario: ");
               String cpff = sc.next();
               validarpessoa.validarCPF(cpff);
               System.out.println("informe a data de nascimento do funcionario: ");
               String dataf = sc.next();
               validarpessoa.validarDataNascimento(dataf);
               System.out.println("informe o setor do funcionario: ");
               String setorf = sc.next();
               System.out.println("informe o salario bruto do funcionario: ");
               double salariof = sc.nextDouble();
               System.out.println("informe quantos porcentos de imposto seram retirado do salario: ");
               double impostof = sc.nextDouble();
               if (setorf.equals("entregador")) {
                   funcionarios.add(new Entregador(nomef, cpff, dataf, salariof, impostof));
               }else {
                   funcionarios.add(new Funcionario(nomef, cpff, dataf, setorf, salariof, impostof));
               }
               
           }
//           loja = new Loja(nome, cnpj, data, endereco,produtoos,funcionarios);
//
//           negocioloja.CadstrarLoja(loja);
           return funcionarios;
      	
      
  }
       }
    	   
       
       
