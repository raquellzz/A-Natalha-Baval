package br.ufrn.imd;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class PlayerInput {

    @FXML
    private Button confirmButton;

    @FXML
    private TextField namePlayer1;

    @FXML
    private TextField namePlayer2;

    @FXML
    void registerNames(ActionEvent event) throws IOException{
        String name1 = namePlayer1.getText();
        String name2 = namePlayer2.getText();
        
        System.out.println("Jogador 1: " + name1);
        System.out.println("Jogador 2: " + name2);

        App.changeScreen("Player1");
    }

}
