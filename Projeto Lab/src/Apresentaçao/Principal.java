package Apresentaçao;

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
                    cliente.logarCliente();
                    int voltar=0;
                    while (voltar == 0){
                        System.out.println("----------------------------------------------");
                        System.out.println("1-Visualizar dados\n2-Menu de compra\n3-sair");
                        String menuLogin = sc.next();

                        if (menuLogin.equals("1")) {
                            cliente.InterfaceDadosCliente();
                            System.out.println("----------------------------------------------");
                            System.out.println("1-Alterar dados\n2-Remover conta\n3-Voltar");
                            String menuConta = sc.next();
                            if (menuConta.equals("1")) {
                                cliente.AlterarDados();
                            } else if (menuConta.equals("2")) {
                                cliente.removerDados();
                            }
                        } else if (menuLogin.equals("2")) {
                            cliente.menuCompras();
                        }else if (menuLogin.equals("3")){
                            break;
                        }
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
                    empresa.logarLoja();
                    System.out.println("1-Alterar dados\n2-Remover loja");
                    String lojaEscolha = sc.next().toLowerCase();

                    if (lojaEscolha.equals("1")) {
                        empresa.AlterarDados();
                    }else if (lojaEscolha.equals("2")){
                        empresa.removerDados();
                    }//falta
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
