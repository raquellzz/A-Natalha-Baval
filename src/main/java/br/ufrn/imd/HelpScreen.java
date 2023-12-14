package br.ufrn.imd;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

/**
 * Controller class for the Help screen.
 * This class is responsible for controlling the Help screen.
 */
public class HelpScreen {

    @FXML
    private Button backButton;

    /**
     * Handles the back button action.
     * Changes the screen to the Home screen when the back button is clicked.
     * @param event The action event triggered by the back button.
     * @throws IOException if an I/O error occurs.
     */
    @FXML
    void goBack(ActionEvent event) throws IOException{
        App.changeScreen("Home");
    }

}

