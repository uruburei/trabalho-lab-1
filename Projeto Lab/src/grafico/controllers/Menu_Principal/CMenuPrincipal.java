package grafico.controllers.Menu_Principal;

import Entidades.Loja;
import Entidades.Produtoo;
import Negocio.NegocioLoja;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CMenuPrincipal implements Initializable {
    private NegocioLoja negocioloja = new NegocioLoja();

    @FXML
    private JFXButton btnCarrinho;

    @FXML
    private JFXButton btnLoja;

    @FXML
    private JFXButton btnConta;

    @FXML
    private JFXButton btnSair;

    @FXML
    private AnchorPane anchorMenu;

    @FXML
    private Parent fxml;

    public static ArrayList<Produtoo> carrinho = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        anchorLoja();
    }
    @FXML
    public void anchorLoja(){
        try {
            fxml = FXMLLoader.load(getClass().getResource("/grafico/view/Menu_Principal/Loja.fxml"));
            anchorMenu.getChildren().removeAll();
            anchorMenu.getChildren().setAll(fxml);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    @FXML
    public void anchorCarrinho(){

        try {
            fxml = FXMLLoader.load(getClass().getResource("/grafico/view/Menu_Principal/Carrinho.fxml"));
            anchorMenu.getChildren().removeAll();
            anchorMenu.getChildren().setAll(fxml);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void anchorConta(){

        try {
            fxml = FXMLLoader.load(getClass().getResource("/grafico/view/Menu_Principal/EnderecoAlt.fxml"));
            anchorMenu.getChildren().removeAll();
            anchorMenu.getChildren().setAll(fxml);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void sair(){

    }

}
