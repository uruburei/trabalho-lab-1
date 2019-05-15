package grafico.controllers;

import com.jfoenix.controls.JFXButton;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CPainelPrincipal implements Initializable {

    @FXML
    private JFXButton btnLoja;

    @FXML
    private JFXButton btnCliente;

    @FXML
    private VBox anchor;

    private Parent fxml;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TranslateTransition t = new TranslateTransition(Duration.millis(300),anchor);
        t.setToX(anchor.getLayoutX());
        t.play();
        t.setOnFinished((e)->{
            try {
                fxml = FXMLLoader.load(getClass().getResource("../view/loginCliente.fxml"));
                anchor.getChildren().removeAll();
                anchor.getChildren().setAll(fxml);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }
    @FXML
    void abrirCliente(ActionEvent event) {
        TranslateTransition t = new TranslateTransition(Duration.millis(300),anchor);
        t.setToX(280);
        t.play();
        t.setOnFinished((e)->{
            try {
                fxml = FXMLLoader.load(getClass().getResource("../view/loginLoja.fxml"));
                anchor.getChildren().removeAll();
                anchor.getChildren().setAll(fxml);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    @FXML
    void abrirLoja(ActionEvent event) {
        TranslateTransition t = new TranslateTransition(Duration.millis(300),anchor);
        t.setToX(0);
        t.play();
        t.setOnFinished((e)->{
            try {
                fxml = FXMLLoader.load(getClass().getResource("../view/loginCliente.fxml"));
                anchor.getChildren().removeAll();
                anchor.getChildren().setAll(fxml);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }
}
