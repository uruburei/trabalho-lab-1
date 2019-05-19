package grafico.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/grafico/view/Menu_Principal/MenuPrincipal.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        //  -- /grafico/view/Login_Cadastro/Main.fxml
    }
    public static void main(String[] args) {
        launch(args);
    }
}
