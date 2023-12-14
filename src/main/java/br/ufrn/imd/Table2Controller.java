package br.ufrn.imd;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.fxml.Initializable;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.ufrn.imd.model.RectangleG;


public class Table2Controller implements Initializable{

    @FXML
    private GridPane gridPane;

    @FXML
    private GridPane gridPane2 = App.makeTable1();

    @FXML
    private Button shootButton;

    @FXML
    private Button quitButton;

    private boolean firstClicked = true;

    private int clickedColumn1 = 0;
    private int clickedRow1 = 0;
    private Rectangle rectangle1 = new Rectangle();

    ArrayList<Rectangle> rectangles = new ArrayList<Rectangle>();

    @FXML
    void confirmShooting(ActionEvent event) throws IOException{
        if(App.gameFinished == false){
            System.out.println("Confirmou o tiro");
            firstClicked = true;

            clearGridPane2();
            setGridPane2();
            
            for(RectangleG r : App.rectangles1){
                //gridPane2.add(r.getRectangle(), r.getX(), r.getY());
                System.out.println("X: " + r.getX() + " Y: " + r.getY());
            }

            App.changeScreen("Table 1");
            
        }
    }

    public void setGridPane2(){
        Rectangle rectangle = new Rectangle(30, 30);
        rectangle.setStyle("-fx-fill: #008080;");
        rectangles.add(rectangle1);

        RectangleG rectangle2 = new RectangleG(rectangle, clickedColumn1 - 1, clickedRow1 - 1);
        App.rectangles2.add(rectangle2);

            //App.setTable2(gridPane2);
        for(RectangleG r : App.rectangles1){
            gridPane2.add(r.getRectangle(), r.getX(), r.getY());
        }
    }

    public void clearGridPane2(){
        for(RectangleG r : App.rectangles1){
            gridPane2.getChildren().remove(r.getRectangle());
        }
    }

    public void clearGridPane1(){
        for(Rectangle r : rectangles){
            gridPane.getChildren().remove(r);
        }
    }

    @FXML
    void quitGame(ActionEvent event) throws IOException{
        App.restart = true;
        clearGridPane2();
        clearGridPane1();
        App.changeScreen("GameOver 1");
    }

    @FXML
    private void initialize() {
        //gridPane2 = App.getTable2();
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

                // Rectangle rectangle2 = new Rectangle(30, 30);
                // rectangle2.setStyle("-fx-fill: #008080;");
                // RectangleG rectangleG = new RectangleG(rectangle2, clickedColumn - 1, clickedRow - 1);
                // App.rectangles2.add(rectangleG);

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

    public void wasHit(){
        for(int i = 0; i < 10; i ++){
            for(int j = 0; j < 10; j++){
                if(App.game.getTableP2().getBlock(i, j).getHit() == true){
                    // Rectangle rectangle = new Rectangle(40, 40);
                    // rectangle.setStyle("-fx-fill: #FF0000;");
                    // gridPane.add(rectangle, i, j);
                    System.out.println("Foi atingido");
                    break;
                }
            }
        }
        System.out.println("Não foi atingido");
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        App.setTable2(gridPane2);
        gridPane.setOnMouseClicked(this::handleGridPaneClick);
        gridPane.setOnMouseEntered(this::handleGridPaneEnter);
    }

}

