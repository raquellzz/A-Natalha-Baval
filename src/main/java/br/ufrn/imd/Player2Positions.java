package br.ufrn.imd;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class Player2Positions {

    @FXML
    private Button confirmButton;

    @FXML
    void confirmPositions(ActionEvent event) throws IOException{
        App.changeScreen("Table");
    }

}

