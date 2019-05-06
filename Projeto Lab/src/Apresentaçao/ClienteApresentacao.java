package Apresentaçao;

import Entidades.Cartao;
import Entidades.Cliente;
import Entidades.Endereco;
import Negocio.*;
import Util.Util;

import java.util.Scanner;

public class ClienteApresentacao {
    private Scanner sc = new Scanner(System.in);
    public NegocioCliente negociocliente = new NegocioCliente();
    public NegocioCartao negociocartao = new NegocioCartao();
    public NegocioEndereco negocioendereco = new NegocioEndereco();
    public NegocioPessoa negociopessoa = new NegocioPessoa();
    public NegocioLoja negocioloja = new NegocioLoja();
    private int i;

    //sistema de cadastro de clientes
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
        cep = negocioendereco.validarCEP(cep);//vai validar o cep e retornar corrigido
        Endereco endereco = new Endereco(lugadouro, cep, numero, bairro, cidade, estado);
        System.out.println("\n----------------------------------Dados Cliente-----------------------------------");
        sc.nextLine();
        System.out.println("Nome: ");
        String nome = sc.nextLine();
        System.out.println("Data de nascimento: ");
        String data = negociopessoa.validarDataNascimento(sc.next());
        System.out.println("CPF: ");
        String cpf = negociopessoa.validarCPF(sc.next());
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
            numerocartao = negociocartao.validarNumero(numerocartao);//vai validar o numero e retornar corrigido
            System.out.println("data de validade: ");
            String datavalidade = sc.next();
            datavalidade = negociocartao.validarDatadeValidade(datavalidade);//vai validar a data e retornar corrigido
            System.out.println("código de segurança: ");
            int codigoseguranca = sc.nextInt();
            codigoseguranca = negociocartao.validarCodigoDeSeguranca(codigoseguranca);//vai validar o codigo e retornar corrigido
            System.out.println("Limite: ");
            double limite = sc.nextDouble();
            Cartao cartao = new Cartao(nometitular, numerocartao, datavalidade, codigoseguranca, limite);
            cliente = new Cliente(nome, cpf, data, cartao, endereco, senha);

        } else {
            cliente = new Cliente(nome, cpf, data, endereco, senha);
        }
        negociocliente.CadastroCliente(cliente);//Vai criar o Cliente

    }

    //
    public int logarCliente() {
    	System.out.println("informe seu  CPF: ");
        String cpf = sc.next();
        System.out.println("informe sua senha: ");
        String senha = sc.next();
        int i = 0;
        String j =  negociocliente.Verificarcliente(cpf, senha);
        if (j == null) {
            System.out.println("A conta não existe!\nTente de novo:\n");
            logarCliente();
        }else {
           i= Integer.parseInt(j);
        }
        return i ;
	}
    
    //obter dados do cliente
    public void InterfaceDadosCliente() {
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
                System.out.println(i);
                System.out.println(negociocliente.getDadoscliente().lerDadosCliente().get(i).getCartao().getLimite());
                System.out.println("***************************************Dados Cartão Cliente******************************");
                System.out.println("Nome do Titular: " + negociocliente.getDadoscliente().lerDadosCliente().get(i).getCartao().getNometitular() + "\n"
                        + "Número do cartao: " + Util.formatarNumeroCartao(negociocliente.getDadoscliente().lerDadosCliente().get(i).getCartao().getNumerocartao()) + "\n"
                        + "Validade: " + Util.formatarDataCartao(negociocliente.getDadoscliente().lerDadosCliente().get(i).getCartao().getValidade()) + "\n");
            } else {
                System.out.println("Cartão não cadastrado");
            }
        }
    }
    
    //alterar dados do cliente
    public void AlterarDados() {
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
            cep=negocioendereco.validarCEP(cep);//vai validar o cep e retornar corrigido
            Endereco endereco = new Endereco(lugadouro, cep, numero, bairro, cidade, estado);
            
            System.out.println("*Alterar* dados do cartão ?");
            String opAltCartão = sc.next().toLowerCase();
        
        if (opAltCartão.equals("sim")) {
            System.out.println("\n----------------------------------Dados Cartão-----------------------------------");
            System.out.println("Nome do Titular do Cartao: ");
            String nometitular = sc.nextLine();
            System.out.println("Número do Cartão: ");
            String numerocartao = sc.next();
            numerocartao=negociocartao.validarNumero(numerocartao);//vai validar o numero do cartão e retornar corrigido
            System.out.println("data de validade: ");
            String datavalidade = sc.next();
            datavalidade=negociocartao.validarDatadeValidade(datavalidade);//vai validar a data e retornar corrigido
            System.out.println("código de segurança: ");
            int codigoseguranca = sc.nextInt();
            codigoseguranca=negociocartao.validarCodigoDeSeguranca(codigoseguranca);//vai validar o codigo e retornar corrigido
            System.out.println("Limite: ");
            double limite = sc.nextDouble();
            Cartao cartao = new Cartao(nometitular, numerocartao, datavalidade, codigoseguranca, limite);

            negociocliente.alterarCliente(new Cliente(nome, cpf, data, cartao, endereco, senha), i);
        }else {
            Cartao cartaoAnte = negociocliente.getDadoscliente().lerDadosCliente().get(i).getCartao();
            negociocliente.alterarCliente(new Cliente(nome, cpf, data,cartaoAnte, endereco, senha), i);
        }
    }
    public void removerDados(){
        int j =logarCliente() ;
        System.out.println("*Deseja deletar conta ? s/n");
        String escolha = sc.next();
        if (escolha.equals("s")){
            negociocliente.removerCliente(j);
        }else{
            System.out.println("Cancelando operação");
        }
    }
    public void menuCompras() {
        double carrinho = 0;
        int menuCompra = 1;
        int tamanho1 = negocioloja.getDadosLoja().lerDadosLoja().size();
        while (menuCompra == 1) {
            System.out.println("----------------------Lojas--------------------------------");
            for (int i = 0; i < tamanho1; i++) {
                System.out.println((i + 1) + "-" + negocioloja.getDadosLoja().lerDadosLoja().get(i).getNome());
            }
            System.out.println("Imforme qual da Loja:");
            int nome = sc.nextInt();
            int i = nome - 1;
            System.out.println("-----------------------------------Produtos--------------------------------------------\n");
            for (int j = 0; j < negocioloja.getDadosLoja().lerDadosLoja().get(i).getProduto().length; j++) {
                System.out.println((j + 1) + "-nome: " + negocioloja.getDadosLoja().lerDadosLoja().get(i).getProduto()[j].getNome());
                System.out.println(" preço: R$" + negocioloja.getDadosLoja().lerDadosLoja().get(i).getProduto()[j].getValor());
                System.out.println(" codigo: " + negocioloja.getDadosLoja().lerDadosLoja().get(i).getProduto()[j].getCodigoproduto() + "\n");
            }
            System.out.println("Adicionar ao Carrinho:");
            int escolhaProd = sc.nextInt();
            int j = escolhaProd - 1;
            System.out.println("*O produto: " + negocioloja.getDadosLoja().lerDadosLoja().get(i).getProduto()[j].getNome() + " com o valor: R$"
                    + negocioloja.getDadosLoja().lerDadosLoja().get(i).getProduto()[j].getValor() + " foi adicionado ao carrinho\n");
            carrinho += negocioloja.getDadosLoja().lerDadosLoja().get(i).getProduto()[j].getValor();
            String y;
            System.out.println("Adicinar mais Produtos ?");
            y = sc.next().toLowerCase();
            if (!y.equals("sim")) {
                System.out.println("Finalizando compra");
                menuCompra = 0;
            }
        }
        menuCompra++;
        String finalizarCompra;
        System.out.println("-------------------------Forma de Pagamento -----------------------------\n" +
                "1-Cartão\n2-Dinheiro");
        finalizarCompra = sc.next();
        if (finalizarCompra.equals("1")) {
            int s = logarCliente();
            System.out.println(s);
            System.out.println(negociocliente.getDadoscliente().lerDadosCliente().get(s).getCartao().getLimite());
            double lim = negociocliente.getDadoscliente().lerDadosCliente().get(s).getCartao().getLimite();
            if (lim > carrinho) {
                double returnlimite = lim - carrinho;
                negociocliente.getDadoscliente().lerDadosCliente().get(s).getCartao().setLimite(returnlimite);
                System.out.println("O valor do carrinho é: R$" + carrinho);
                String setor = "entregador";
                int tamanho2 = negocioloja.getDadosLoja().lerDadosLoja().get(s).getFucionario().size();
                for (int j = 0; j < tamanho2; j++) {
                    if (setor.equals(negocioloja.getDadosLoja().lerDadosLoja().get(s).getFucionario().get(j).getSetor())) {
                        System.out.println("O produto será entregue por: " + negocioloja.getDadosLoja().lerDadosLoja().get(s).getFucionario().get(j).getNome());
                        break;
                    }
                }
            } else {
                System.out.println("Cartão não autorizado!");
            }
        } else if (finalizarCompra.equals("2")) {
            System.out.println("O valor do carrinho é: R$" + carrinho);
            String setor = "entregador";
            int tamanho3=negocioloja.getDadosLoja().lerDadosLoja().get(i).getFucionario().size();
            for (int j = 0; j < tamanho3; j++) {
                if (setor.equals(negocioloja.getDadosLoja().lerDadosLoja().get(i).getFucionario().get(j).getSetor())) {
                    System.out.println("O produto será entregue por: " + negocioloja.getDadosLoja().lerDadosLoja().get(i).getFucionario().get(j).getNome());
                    break;
                }
            }
        } else {
            System.out.println("Digitou errado");
        }
    }
}
