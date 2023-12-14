package br.ufrn.imd;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;


import java.net.URL;
import java.io.IOException;
import java.util.ResourceBundle;

public class Table1Controller implements Initializable{

    @FXML
    private GridPane gridPane;

    @FXML
    private GridPane gridPane2;

    @FXML
    private Button shootButton;

    @FXML
    private Button quitButton;

    private boolean firstClicked = true;

    private int clickedColumn1 = 0;
    private int clickedRow1 = 0;
    private Rectangle rectangle1 = new Rectangle();

    @FXML
    void confirmShooting(ActionEvent event) throws IOException{
        if(App.gameFinished == false){
            System.out.println("Confirmou o tiro");
            firstClicked = true;
            
            Rectangle rectangle = new Rectangle(30, 30);
            rectangle.setStyle("-fx-fill: #008080;");
            gridPane2.add(rectangle, clickedColumn1 - 1, clickedRow1 - 1);
            App.setTable1(gridPane2);
            gridPane2.equals(App.getTable2());
            

            App.changeScreen("Table 2");
        }
    }

    @FXML
    private void initialize() {
        gridPane2 = App.getTable2();
        // Adiciona um ouvinte de evento onMouseClicked ao GridPane
        gridPane.setOnMouseClicked(this::handleGridPaneClick);
        gridPane.setOnMouseEntered(this::handleGridPaneEnter);
    }

    public void setupGridPaneClickEvent() {
        // Adicione o evento de clique ao GridPane
        gridPane.setOnMouseClicked(this::handleGridPaneClick);
        gridPane.setOnMouseEntered(this::handleGridPaneEnter);
    }

    private void handleGridPaneEnter(MouseEvent event){
        int enteredColumn = (int) (event.getX() / gridPane.getWidth() * gridPane.getColumnCount());
        int enteredRow = (int) (event.getY() / gridPane.getHeight() * gridPane.getRowCount());

        System.out.println("Cursor na posição: Coluna " + enteredColumn + ", Linha " + enteredRow);
    }

    private void handleGridPaneClick(MouseEvent event) {
        // Lógica a ser executada quando o GridPane for clicado
        int clickedColumn = (int) (event.getX() / gridPane.getWidth() * gridPane.getColumnCount()) + 1;
        int clickedRow = (int) (event.getY() / gridPane.getHeight() * gridPane.getRowCount()) + 1;

        if(clickedColumn1 != clickedColumn || clickedRow1 != clickedRow){
            if(firstClicked){
                Rectangle rectangle = new Rectangle(40, 40);
                rectangle.setStyle("-fx-fill: #008080;");
                gridPane.add(rectangle, clickedColumn - 1, clickedRow - 1);
                rectangle1 = rectangle;
                firstClicked = false;
            }else{
                gridPane.getChildren().remove(rectangle1);
                Rectangle rectangle = new Rectangle(40, 40);
                rectangle.setStyle("-fx-fill: #008080;");
                gridPane.add(rectangle, clickedColumn - 1, clickedRow - 1);
                rectangle1 = rectangle;
            }
        }
        clickedColumn1 = clickedColumn;
        clickedRow1 = clickedRow;

        System.out.println("Clicou na posição: Coluna " + clickedColumn + ", Linha " + clickedRow);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        gridPane.setOnMouseClicked(this::handleGridPaneClick);
        gridPane.setOnMouseEntered(this::handleGridPaneEnter);
    }

    @FXML
    void quitGame(ActionEvent event) throws IOException{
        App.changeScreen("GameOver 2");
    }

}
