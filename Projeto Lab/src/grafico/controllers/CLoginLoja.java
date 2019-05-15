package grafico.controllers;

import Entidades.Endereco;
import Entidades.Loja;
import Negocio.NegocioCliente;
import Negocio.NegocioLoja;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class CLoginLoja {
    NegocioLoja negocioLoja = new NegocioLoja();

    @FXML
    private JFXTextField CPNJ;

    @FXML
    private Label CadastrarLoja;

    @FXML
    private JFXButton btnLoginLoja;

    @FXML
    private Label ContaErroLoja;

    @FXML
    private VBox PainelLoginLoja;

    private Parent fxml2;

    @FXML
    void CriarLoja(MouseEvent event) {
        try {
            fxml2 = FXMLLoader.load(getClass().getResource("../view/EnderecoLoja.fxml"));
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
    private JFXTextField Lugadouro;

    @FXML
    private JFXTextField Numero;

    @FXML
    private JFXTextField Bairro;

    @FXML
    private JFXTextField Cidade;

    @FXML
    private JFXTextField Estado;

    @FXML
    private JFXTextField Cep;

    @FXML
    private JFXButton btnLojaEndereco;

    private Parent fxml;

    private Endereco endereco;
    @FXML
    void logarLojaEndereco(ActionEvent event) {
        endereco = new Endereco(Lugadouro.getText(), Cep.getText(), Numero.getText(), Bairro.getText(),
                Cidade.getText(), Estado.getText());
        try {
            fxml = FXMLLoader.load(getClass().getResource("../view/cadastroLoja.fxml"));
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
    private JFXTextField Nome;

    @FXML
    private JFXTextField CNPJ;

    @FXML
    private JFXTextField Data;

    @FXML
    private JFXButton btnClienteDados;

    @FXML
    void logarClienteFim(ActionEvent event) {
        System.out.println("tste");
        Loja loja = new Loja(Nome.getText(), CNPJ.getText(), Data.getText(), endereco);
        negocioLoja.CadstrarLoja(loja);
        negocioLoja.getDadosLoja().atualizarArquivo();
    }
}
