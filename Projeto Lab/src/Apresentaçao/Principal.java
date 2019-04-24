package Apresentaçao;
//teste
import Dados.DadosLoja;
import Negocio.NegocioCliente;
import Negocio.NegocioLoja;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        ClienteApresentacao cliente = new ClienteApresentacao();
        LojaApresentacao empresa = new LojaApresentacao();
        int rodar = 1;
        Scanner sc = new Scanner(System.in);
        while (rodar == 1) {
            System.out.println("--------------------------Food-Planet-----------------------------");
            System.out.println("1-Cliente\n2-Loja\n3-Sair");
            String opMenu = sc.next();
            if (opMenu.equals("1")) {
                System.out.println("-----------------------Cliente--------------------------");
                System.out.println("1-Logar\n2-Cadastrar-se");
                String opLogin = sc.next();
                if (opLogin.equals("1")) {
                    cliente.InterfaceDadosCliente();
                    System.out.println("----------------------------------------------");
                    System.out.println("1-Alterar dados\n2-Menu de compra");
                    String menuLogin = sc.next();
                    if (menuLogin.equals("1")) {
                        cliente.AlterarDados();
                    } else if (menuLogin.equals("2")) {
                            double carrinho = 0;
                            int menuCompra = 1;
                            System.out.println("----------------------Lojas--------------------------------");
                            int tamanho1=empresa.negocioloja.getDadosLoja().lerDadosLoja().size();
                            for (int i = 0; i < tamanho1; i++) {
                                System.out.println((i + 1) + "-" + empresa.negocioloja.getDadosLoja().lerDadosLoja().get(i).getNome());
                            }
                            System.out.println("Imforme qual da Loja:");
                            int nome = sc.nextInt();
                            int i = nome - 1;
                            while (menuCompra == 1) {
                                System.out.println("-----------------------------------Produtos--------------------------------------------\n");
                                for (int j = 0; j < empresa.negocioloja.getDadosLoja().lerDadosLoja().get(i).getProduto().length; j++) {
                                    System.out.println((j + 1) + "-nome: " + empresa.negocioloja.getDadosLoja().lerDadosLoja().get(i).getProduto()[j].getNome());
                                    System.out.println(" preço: R$" + empresa.negocioloja.getDadosLoja().lerDadosLoja().get(i).getProduto()[j].getValor());
                                    System.out.println(" codigo: " + empresa.negocioloja.getDadosLoja().lerDadosLoja().get(i).getProduto()[j].getCodigoproduto() + "\n");
                                }
                                System.out.println("Adicionar ao Carrinho:");
                                int escolhaProd = sc.nextInt();
                                int j = escolhaProd - 1;
                                System.out.println("*O produto: " + empresa.negocioloja.getDadosLoja().lerDadosLoja().get(i).getProduto()[j].getNome() + " com o valor: R$"
                                        + empresa.negocioloja.getDadosLoja().lerDadosLoja().get(i).getProduto()[j].getValor() + " foi adicionado ao carrinho\n");
                                carrinho += empresa.negocioloja.getDadosLoja().lerDadosLoja().get(i).getProduto()[j].getValor();
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
                                System.out.println("informe seu  CPF: ");
                                String cpf = sc.next();
                                System.out.println("informe sua senha: ");
                                String senha = sc.next();
                                int s = cliente.negociocliente.Verificarcliente(cpf,senha);
                                double lim = cliente.negociocliente.getDadoscliente().lerDadosCliente().get(s).getCartao().getLimite();
                                if (lim > carrinho) {
                                    double returnlimite = lim - carrinho;
                                    cliente.negociocliente.getDadoscliente().lerDadosCliente().get(s).getCartao().setLimite(returnlimite);
                                    System.out.println("O valor do carrinho é: R$" + carrinho);
                                    String setor = "entregador";
                                    int tamanho2 = empresa.negocioloja.getDadosLoja().lerDadosLoja().get(s).getFucionario().size();
                                    for (int j = 0; j < tamanho2; j++) {
                                        if (setor.equals(empresa.negocioloja.getDadosLoja().lerDadosLoja().get(s).getFucionario().get(j).getSetor())) {
                                            System.out.println("O produto será entregue por: " + empresa.negocioloja.getDadosLoja().lerDadosLoja().get(s).getFucionario().get(j).getNome());
                                            break;
                                        }
                                    }
                                } else {
                                    System.out.println("Cartão não autorizado!");
                                }
                            } else if (finalizarCompra.equals("2")) {
                                System.out.println("O valor do carrinho é: R$" + carrinho);
                                String setor = "entregador";
                                int tamanho3=empresa.negocioloja.getDadosLoja().lerDadosLoja().get(i).getFucionario().size();
                                for (int j = 0; j < tamanho3; j++) {
                                    if (setor.equals(empresa.negocioloja.getDadosLoja().lerDadosLoja().get(i).getFucionario().get(j).getSetor())) {
                                        System.out.println("O produto será entregue por: " + empresa.negocioloja.getDadosLoja().lerDadosLoja().get(i).getFucionario().get(j).getNome());
                                        break;
                                    }
                                }
                            } else {
                                System.out.println("Digitou errado");
                            }
                    } else {
                        System.out.println("Digitou errado");
                    }
                } else if (opLogin.equals("2")) {
                    cliente.CadastrarCliente();
                } else {
                    System.out.println("Digitou errado");
                }
            } else if (opMenu.equals("2")) {
                System.out.println("--------------------Loja----------------------");
                System.out.println("1-Logar\n2-Cadastrar-se");
                String opLogin = sc.next();
                if (opLogin.equals("1")) {
                    empresa.InterfaceDadosLoja();
                    System.out.println("*Alterar* dados da Loja?");
                    String lojaEscolha = sc.next().toLowerCase();
                    if (lojaEscolha.equals("sim")) {
                        empresa.AlterarDados();
                    }
                } else if (opLogin.equals("2")) {
                    sc.nextLine();
                    empresa.CadastrarLoja();
                }
            } else if (opMenu.equals("3")) {
                System.out.println("Fechando programa");
                rodar = 0;
            } else {
                System.out.println("Digitou errado");
            }
        }
    }
}
