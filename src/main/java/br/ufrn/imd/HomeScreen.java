package br.ufrn.imd;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

/**
 * Controller class for the Home screen.
 * This class is responsible for controlling the Home screen.
 */
public class HomeScreen {

    @FXML
    private Button exitButton;

    @FXML
    private Button helpButton;

    @FXML
    private Button startButton;

    /**
     * Handles the exit game button action.
     * Exits the application when the exit button is clicked.
     * @param event The action event triggered by the exit button.
     */
    @FXML
    void exitGame(ActionEvent event) throws IOException{
        System.exit(0);
    }

    /**
     * Handles the help button action.
     * Changes the screen to the Help screen when the help button is clicked.
     * @param event The action event triggered by the help button.
     * @throws IOException if an I/O error occurs.
     */
    @FXML
    void helpGame(ActionEvent event) throws IOException{
        App.changeScreen("Help");
    }

    /**
     * Handles the start game button action.
     * Changes the screen to the Players screen when the start button is clicked.
     * @param event The action event triggered by the start button.
     * @throws IOException if an I/O error occurs.
     */
    @FXML
    public void startGame(ActionEvent event) throws IOException{
        System.out.println("Game started!");
        
        App.changeScreen("Players");
    }

}
