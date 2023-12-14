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

        App.game.getPlayer1().setName(name1);
        App.game.getPlayer2().setName(name2);

        System.out.println("Jogador 1: " + App.game.getPlayer1().getName());
        System.out.println("Jogador 2: " + App.game.getPlayer2().getName());

        App.changeScreen("Player1");
    }

}
