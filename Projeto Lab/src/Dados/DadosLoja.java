package Dados;

import Entidades.Endereco;
import Entidades.Funcionario;
import Entidades.Loja;
import Entidades.Produtoo;

import java.util.ArrayList;

public class DadosLoja {
    private ArrayList<Loja> lojas = new ArrayList<Loja>(3);
    private Produtoo[] produtoLojaMcDonald = new Produtoo[3];
    private Produtoo[] produto2 = new Produtoo[3];
    private Produtoo[] produto3 = new Produtoo[3];
    private Endereco[] endereco = new Endereco[3];
    private ArrayList<Funcionario>  funcionario = new ArrayList<Funcionario>(2);


    public ArrayList<Loja> lerDadosLoja() {
        //produtos das lojas
        produtoLojaMcDonald[0] = new Produtoo("mcBurguer", 24.5, 2405);
        produtoLojaMcDonald[1] = new Produtoo("mcFly", 14.99, 2487);
        produtoLojaMcDonald[2] = new Produtoo("mcChiken", 12.5, 4405);

        produto2[0] = new Produtoo("Triplo-cheddar", 22, 2745);
        produto2[1] = new Produtoo("Ovomaltine", 12.8, 2555);
        produto2[2] = new Produtoo("batata-frita", 5.5, 8405);

        produto3[0] = new Produtoo("parmegiana", 40, 5405);
        produto3[1] = new Produtoo("galeto", 35, 4405);
        produto3[2] = new Produtoo("yaksoba", 45, 8505);

        //funcionarios das lojas
        funcionario.add(new Funcionario("Jubscleiton", "01418395463", "20031997", "RH", 1500, 20));
        funcionario.add(new Funcionario("Sara", "11125965764", "30051992", "entregador", 1200, 15));

        //endereço loja
        endereco[0] = new Endereco("Av. Agamenon Magalhães", "54568281", "280", "Recife", "Recife", "PE");
        endereco[1] = new Endereco("Av. Caxanga", "55978281", "3050", "Cordeiro", "Recife", "PE");
        endereco[2] = new Endereco("Av. norte", "55978281", "3050", "Varzea", "Recife", "PE");
        //Lojas
        lojas.add(new Loja("McDonald's", "01685640001021", "10081980", endereco[0], produtoLojaMcDonald, funcionario));
        lojas.add(new Loja("BurguerKing", "51685840001021", "10081980", endereco[1], produto2, funcionario));
        lojas.add(new Loja("Giraffa's", "51686890001021", "10081980", endereco[2], produto3, funcionario));
        return lojas;
    }
    public void receberDadosLoja(Loja loja1) {
        lojas.add(loja1);
    }
}
