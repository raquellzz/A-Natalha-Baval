package br.ufrn.imd;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

/**
 * Controller class for the Game Over 2 screen.
 * This class is responsible for controlling the Game Over 2 screen.
 */
public class GameOver2 {

    @FXML
    private Button quitButton;

    @FXML
    private Button restartButton;

    /**
     * Handles the quit game button action.
     * Exits the application when the quit button is clicked.
     * @param event The action event triggered by the quit button.
     */
    @FXML
    void quitGame(ActionEvent event) {
        System.exit(0);
    }

    /**
     * Handles the restart game button action.
     * Changes the screen to the Home screen when the restart button is clicked.
     * @param event The action event triggered by the restart button.
     * @throws IOException if an I/O error occurs.
     */
    @FXML
    void restartGame(ActionEvent event) throws IOException{
        App.changeScreen("Home");
    }

}
