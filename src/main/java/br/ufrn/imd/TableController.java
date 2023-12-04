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
        gridPane.setOnMouseClicked(this::handleGridPaneClick);
    }

    public void setupGridPaneClickEvent() {
        gridPane.setOnMouseClicked(this::handleGridPaneClick);
    }

    private void handleGridPaneClick(MouseEvent event) {
        int clickedColumn = (int) (event.getX() / gridPane.getWidth() * gridPane.getColumnCount()) + 1;
        int clickedRow = (int) (event.getY() / gridPane.getHeight() * gridPane.getRowCount()) + 1;

        System.out.println("Clicou na posição: Coluna " + clickedColumn + ", Linha " + clickedRow);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        gridPane.setOnMouseClicked(this::handleGridPaneClick);
    }

}
