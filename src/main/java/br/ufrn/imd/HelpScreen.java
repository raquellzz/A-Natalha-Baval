package br.ufrn.imd;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class HelpScreen {

    @FXML
    private Button backButton;

    @FXML
    void goBack(ActionEvent event) throws IOException{
        App.changeScreen("Home");
    }

}

