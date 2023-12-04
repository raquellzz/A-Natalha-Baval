package br.ufrn.imd;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class TableController implements Initializable{

    @FXML
    private GridPane gridPane;

    @FXML
    private void initialize() {
        // Adiciona um ouvinte de evento onMouseClicked ao GridPane
        gridPane.setOnMouseClicked(this::handleGridPaneClick);
    }

    public void setupGridPaneClickEvent() {
        // Adicione o evento de clique ao GridPane
        gridPane.setOnMouseClicked(this::handleGridPaneClick);
    }

    private void handleGridPaneClick(MouseEvent event) {
        // Lógica a ser executada quando o GridPane for clicado
        System.out.println("GridPane clicado!");
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        gridPane.setOnMouseClicked(this::handleGridPaneClick);
    }

}
