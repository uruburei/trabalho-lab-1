package grafico.controllers.Login_Cadastro;

import Entidades.Endereco;
import Entidades.Loja;
import Negocio.NegocioLoja;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class CLoginLoja {
    NegocioLoja negocioLoja = new NegocioLoja();

    @FXML
    private TextField CPNJ;

    @FXML
    private Label CadastrarLoja;

    @FXML
    private Button btnLoginLoja;

    @FXML
    private Label ContaErroLoja;

    @FXML
    private VBox PainelLoginLoja;

    private Parent fxml2;

    @FXML
    void CriarLoja(MouseEvent event) {
        try {
            fxml2 = FXMLLoader.load(getClass().getResource("/grafico/view/Login_Cadastro/EnderecoLoja.fxml"));
            PainelLoginLoja.getChildren().removeAll();
            PainelLoginLoja.getChildren().setAll(fxml2);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    @FXML
    void logarLoja(ActionEvent event) {
        if (negocioLoja.Verificarloja(CPNJ.getText()) != null){
            System.out.println("Entrar no programa");
            ContaErroLoja.setVisible(false);
        }else {
            ContaErroLoja.setVisible(true);
        }

    }

    //---------------------------cadastro

    @FXML
    private VBox PainelEndereco;

    @FXML
    private TextField Lugadouro;

    @FXML
    private TextField Numero;

    @FXML
    private TextField Bairro;

    @FXML
    private TextField Cidade;

    @FXML
    private TextField Estado;

    @FXML
    private TextField Cep;

    @FXML
    private Button btnLojaEndereco;

    private Parent fxml;

    private Endereco endereco;
    @FXML
    void logarLojaEndereco(ActionEvent event) {
        endereco = new Endereco(Lugadouro.getText(), Cep.getText(), Numero.getText(), Bairro.getText(),
                Cidade.getText(), Estado.getText());
        try {
            fxml = FXMLLoader.load(getClass().getResource("/grafico/view/Login_Cadastro/cadastroLoja.fxml"));
            PainelEndereco.getChildren().removeAll();
            PainelEndereco.getChildren().setAll(fxml);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    //------------------------------------Loja-------------------------------------


    @FXML
    private VBox PainelDados;

    @FXML
    private TextField Nome;

    @FXML
    private TextField CNPJ;

    @FXML
    private TextField Data;

    @FXML
    private Button btnClienteDados;

    @FXML
    void logarClienteFim(ActionEvent event) {
        System.out.println("tste");
        Loja loja = new Loja(Nome.getText(), CNPJ.getText(), Data.getText(), endereco);
        negocioLoja.CadstrarLoja(loja);
        negocioLoja.getDadosLoja().atualizarArquivo();
    }
}
