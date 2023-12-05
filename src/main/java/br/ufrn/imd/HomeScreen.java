package br.ufrn.imd;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class HomeScreen {

    @FXML
    private Button exitButton;

    @FXML
    private Button helpButton;

    @FXML
    private Button startButton;

    @FXML
    void exitGame(ActionEvent event) {

    }

    @FXML
    void helpGame(ActionEvent event) {

    }
    @FXML
    public void startGame(ActionEvent event) throws IOException{
        System.out.println("Game started!");
        
        App.changeScreen("Table");
    }

}
