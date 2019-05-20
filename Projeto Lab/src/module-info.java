module Projeto.Lab {
    requires javafx.fxml;
    requires javafx.controls;

    opens grafico.main to javafx.fxml;

    opens grafico.controllers.Login_Cadastro to javafx.fxml;
    opens grafico.controllers.Menu_Principal to javafx.fxml;

    exports grafico.main;

    exports grafico.controllers.Login_Cadastro;
    exports grafico.controllers.Menu_Principal;
}