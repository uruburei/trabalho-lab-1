package grafico.controllers.Menu_Principal;

import Entidades.Loja;
import Negocio.NegocioLoja;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class CMenuPrincipal implements Initializable {
    private NegocioLoja negocioloja = new NegocioLoja();

    private ObservableList<Loja> obslojas;

    @FXML
    private ListView<Loja> ListaLojas;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        carregar();
    }

    public void carregar(){

        obslojas = FXCollections.observableArrayList(negocioloja.getDadosLoja().lerDadosLoja());

        ListaLojas.setItems(obslojas);
    }


}
