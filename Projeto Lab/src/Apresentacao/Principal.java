package Apresentacao;

import java.util.Scanner;

public class Principal {
	private  static ClienteApresentacao cliente = new ClienteApresentacao();
    private static LojaApresentacao empresa = new LojaApresentacao();
    static Scanner sc = new Scanner(System.in);
    
   private static int conta;
   private  static int loja;
   private static int rodar = 1;
    
    public static void main(String[] args) {
    	 	
    	 while (rodar == 1) {
             System.out.println("--------------------------Food-Planet-----------------------------");
             System.out.println("1-Cliente\n2-Loja\n3-Sair");
             String opMenu = sc.next();

             if (opMenu.equals("1")) {
            	 apresentacaoCliente();
             //--------------------------------loja-------------------------------------;;
             } else if (opMenu.equals("2")) {
            	 apresentacaoloja();
             } else if (opMenu.equals("3")) {
                 empresa.negocioloja.getDadosLoja().atualizarArquivo();
                 cliente.negociocliente.getDadoscliente().atualizarArquivo();
                 System.out.println("Fechando programa");

                 rodar = 0;
             } else {
                 System.out.println("Digitou errado");
             }
    	 }
    	
    }
      
        
    
    
    public static void apresentacaoCliente() {
    	System.out.println("-----------------------Cliente--------------------------");
        System.out.println("1-Logar\n2-Cadastrar-se");
        String opLogin = sc.next();

        if (opLogin.equals("1")) {
            conta = cliente.logarCliente();
            int voltar=0;
            while (voltar == 0){
                System.out.println("----------------------------------------------");
                System.out.println("1-Visualizar dados\n2-Menu de compra\n3-sair");
                String menuLogin = sc.next();

                if (menuLogin.equals("1")) {
                    cliente.interfaceDadosCliente(conta);
                    System.out.println("----------------------------------------------");
                    System.out.println("1-Alterar dados\n2-Remover conta\n3-Voltar");
                    String menuConta = sc.next();
                    if (menuConta.equals("1")) {
                        cliente.alterarDados(conta);
                    } else if (menuConta.equals("2")) {
                        cliente.removerDados();
                        break;
                    }
                } else if (menuLogin.equals("2")) {
                    cliente.menuCompras();
                }else if (menuLogin.equals("3")){
                    break;
                }
            }
        } else if (opLogin.equals("2")) {
            cliente.cadastrarCliente();
            cliente.negociocliente.getDadoscliente().atualizarArquivo();
        } else {
            System.out.println("Digitou errado");
        }
    }
    
    public static void apresentacaoloja() {
    	System.out.println("--------------------Loja----------------------");
        System.out.println("1-Logar\n2-Cadastrar-se");
        String opLogin = sc.next();
        int menuLoja=0;

        if (opLogin.equals("1")) {
            loja = empresa.logarLoja();
            while (menuLoja ==0) {
                System.out.println("1-Alterar dados\n2-Remover loja\n3-Visualizar dados");
                String lojaEscolha = sc.next().toLowerCase();

                if (lojaEscolha.equals("1")) {
                    empresa.AlterarDados(loja);
                    break;
                } else if (lojaEscolha.equals("2")) {
                    empresa.removerDados();
                    break;
                } else if (lojaEscolha.equals("3")) {
                    empresa.InterfaceDadosLoja(loja);
                }
            }
            } else if (opLogin.equals("2")) {
                sc.nextLine();
                empresa.cadastrarLoja();
                empresa.negocioloja.getDadosLoja().atualizarArquivo();
            }
    }
    	
}
