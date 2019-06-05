package Dados;

import Entidades.Endereco;
import Entidades.Funcionario;
import Entidades.Loja;
import Entidades.Produtoo;

import java.io.*;
import java.util.ArrayList;

public class DadosLoja {
    private ArrayList<Loja> lojas = new ArrayList<>(3);
    private File file = new File("src/Loja.txt");
    public DadosLoja(){
        if (!file.exists()){
            preCadastrado();
            atualizarArquivo();
        }
        atualizarArray();
    }
    public void atualizarArray(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            lojas = (ArrayList<Loja>) ois.readObject();
            ois.close();
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public void atualizarArquivo(){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(lojas);
            oos.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public ArrayList<Loja> lerDadosLoja() {
        return lojas;
    }
    public void receberDadosLoja(Loja loja1) {
        lojas.add(loja1);
    }
    public void alterarDadosLoja(int i, Loja loja) {
        lojas.set(i, loja);
    }
    public void removerDadosLoja(int i){
        lojas.remove(i);
    }
    public void preCadastrado(){
        Produtoo[] produtoLojaMcDonald = new Produtoo[3];
        Produtoo[] produto2 = new Produtoo[3];
        Produtoo[] produto3 = new Produtoo[3];
        Endereco[] endereco = new Endereco[3];

        ArrayList<Funcionario>  funcionario = new ArrayList<Funcionario>(2);
        produtoLojaMcDonald[0] = new Produtoo("mcBurguer", 24.5, 2405);
        produtoLojaMcDonald[1] = new Produtoo("mcFly", 14.99, 2487);
        produtoLojaMcDonald[2] = new Produtoo("mcChiken", 12.5, 4405);

        produto2[0] = new Produtoo("Triplo-cheddar", 22, 2745);
        produto2[1] = new Produtoo("Ovomaltine", 12.8, 2555);
        produto2[2] = new Produtoo("batata-frita", 5.5, 8405);

        produto3[0] = new Produtoo("parmegiana", 40, 5405);
        produto3[1] = new Produtoo("galeto", 35, 4405);
        produto3[2] = new Produtoo("yaksoba", 45, 8505);
        
        ArrayList<Produtoo> produto = new ArrayList<>();
        produto.add(produtoLojaMcDonald[0]);
        produto.add(produtoLojaMcDonald[1]);
        produto.add(produtoLojaMcDonald[2]);
        
        ArrayList<Produtoo> produto2a = new ArrayList<>();
        produto2a.add(produto2[1]);
        produto2a.add(produto2[0]);
        produto2a.add(produto2[2]);
        
        ArrayList<Produtoo> produto3a = new ArrayList<>();
        produto3a.add(produto3[1]);
        produto3a.add(produto3[0]);
        produto3a.add(produto3[2]);
        
        //funcionarios das lojas
        funcionario.add(new Funcionario("Jubscleiton", "01418395463", "20031997", "RH", 1500, 20));
        funcionario.add(new Funcionario("Sara", "11125965764", "30051992", "entregador", 1200, 15));

        //endereço loja
        endereco[0] = new Endereco("Av. Agamenon Magalhães", "54568281", "280", "Recife", "Recife", "PE");
        endereco[1] = new Endereco("Av. Caxanga", "55978281", "3050", "Cordeiro", "Recife", "PE");
        endereco[2] = new Endereco("Av. norte", "55978281", "3050", "Varzea", "Recife", "PE");
        //Lojas
        lojas.add(new Loja("McDonald's", "01685640001021", "10081980", endereco[0], produto2a, funcionario));
        lojas.add(new Loja("BurguerKing", "51685840001021", "10081980", endereco[1], produto, funcionario));
        lojas.add(new Loja("Giraffa's", "51686890001021", "10081980", endereco[2], produto3a, funcionario));
    }
}
