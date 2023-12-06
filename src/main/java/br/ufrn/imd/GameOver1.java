package br.ufrn.imd;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;


public class GameOver1 {

    @FXML
    private Button quitButton;

    @FXML
    private Button restartButton;

    @FXML
    void quitGame(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void restartGame(ActionEvent event) throws IOException{
        App.changeScreen("Home");
    }

}
