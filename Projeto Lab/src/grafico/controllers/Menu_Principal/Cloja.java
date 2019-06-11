package grafico.controllers.Menu_Principal;

import Entidades.Loja;
import Entidades.Produtoo;
import Negocio.NegocioCliente;
import Negocio.NegocioLoja;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Cloja implements Initializable {
    private NegocioLoja negocioloja = new NegocioLoja();

    @FXML
    private JFXListView<Loja> listviewj;

    @FXML
    private JFXListView<Produtoo> listviewj2;

    @FXML
    private AnchorPane anchorMenu;

    @FXML
    private JFXButton btnAdicionarC;

    @FXML
    private Parent fxml;



    private List<Loja> lista = new ArrayList<>(negocioloja.getDadosLoja().lerDadosLoja());

    int i=0;

    @FXML
    public void carregar(){
        listviewj.setExpanded(true);
        listviewj.depthProperty().set(1);
        ObservableList<Loja> obslojas = FXCollections.observableArrayList(lista);
        listviewj.setItems(obslojas);
    }

    @FXML
    public void clickListLojas(){
        Loja escolha = listviewj.getSelectionModel().getSelectedItem();
        carregarProdutos(escolha);
    }
    @FXML
    public void carregarProdutos(Loja x){
        int qloja = negocioloja.getDadosLoja().lerDadosLoja().indexOf(x);
        listviewj2.setExpanded(true);
        listviewj2.depthProperty().set(1);
        ObservableList<Produtoo> obslojas2 = FXCollections.observableArrayList(negocioloja.getDadosLoja().lerDadosLoja().get(qloja).getProduto());
        listviewj2.setItems(obslojas2);
    }

    public void addCarrinho(){
        if (listviewj2.getSelectionModel().getSelectedItem() != null){
            CMenuPrincipal.carrinho.add(listviewj2.getSelectionModel().getSelectedItem());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        carregar();
    }

}
