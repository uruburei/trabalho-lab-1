package grafico.controllers.Menu_Principal;

import Entidades.Loja;
import Entidades.Produtoo;
import Negocio.NegocioCliente;
import Negocio.NegocioLoja;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXToggleButton;
import grafico.controllers.Login_Cadastro.CLoginCliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Ccarrinho extends Cloja implements Initializable {
    private NegocioLoja negocioloja = new NegocioLoja();
    private NegocioCliente negociocliente = new NegocioCliente();

    @FXML
    private Parent fxml;

    @FXML
    private JFXListView<Produtoo> listCarrinho;

    @FXML
    private JFXButton btnRemover;

    @FXML
    private AnchorPane anchorCarrinho;

    @FXML
    private JFXButton btnFinalizar;

    @FXML
    private JFXToggleButton toggleCartao;

    @FXML
    private Label total;

    private double total2 =0;

    @FXML
    private Label cartaofail;


    public void carregarCarrinho(){
        listCarrinho.setExpanded(true);
        listCarrinho.depthProperty().set(1);
        ObservableList<Produtoo> obsproduto = FXCollections.observableArrayList(CMenuPrincipal.carrinho);
        listCarrinho.setItems(obsproduto);

    }
    public void removerCarrinho(){
        CMenuPrincipal.carrinho.remove(listCarrinho.getSelectionModel().getSelectedItem());
        carregarCarrinho();
        total2=0;
        attTotal();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        carregarCarrinho();
        attTotal();
    }


    public void attTotal(){

        for (Produtoo x:CMenuPrincipal.carrinho) {
            total2 += x.getValor();
        }
        total.setText("Total: R$"+total2);
    }

    public void FinalizarCompra(){
        if(toggleCartao.isSelected()){
            int i = CLoginCliente.i;
            double lim = negociocliente.getDadoscliente().lerDadosCliente().get(i).getCartao().getLimite();
            if (lim > total2) {
                double returnlimite = lim - total2;
                negociocliente.getDadoscliente().lerDadosCliente().get(i).getCartao().setLimite(returnlimite);
                cartaofail.setVisible(false);
            } else {
                cartaofail.setVisible(true);
            }
            try {
                fxml = FXMLLoader.load(getClass().getResource("/grafico/view/Menu_Principal/Fim.fxml"));
                anchorCarrinho.getChildren().removeAll();
                anchorCarrinho.getChildren().setAll(fxml);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }else {
            try {
                fxml = FXMLLoader.load(getClass().getResource("/grafico/view/Menu_Principal/Fim.fxml"));
                anchorCarrinho.getChildren().removeAll();
                anchorCarrinho.getChildren().setAll(fxml);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
