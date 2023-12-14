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

/**
 * Controller class for the Table 2 screen.
 * This class is responsible for controlling the Table 2 screen.
 */
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

    /**
     * Handles the shoot button action.
     * Changes the screen to the Table 1 screen when the shoot button is clicked.
     * @param event The action event triggered by the shoot button.
     * @throws IOException
     */
    @FXML
    void confirmShooting(ActionEvent event) throws IOException{
        if(App.gameFinished == false){
            System.out.println("Confirmou o tiro");
            firstClicked = true;

            clearGridPane2();
            setGridPane2();

            App.changeScreen("Table 1");
            
        }
    }

    /**
     * Creates a rectangle and adds it to the gridPane2.
     */
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

    /**
     * Removes all the rectangles from the gridPane2.
     */
    public void clearGridPane2(){
        for(RectangleG r : App.rectangles1){
            gridPane2.getChildren().remove(r.getRectangle());
        }
    }

    /**
     * Removes all the rectangles from the gridPane1.
     */
    public void clearGridPane1(){
        for(Rectangle r : rectangles){
            gridPane.getChildren().remove(r);
        }
    }

    /**
     * Handles the quit button action.
     * Changes the screen to the Game Over screen when the quit button is clicked.
     * @param event The action event triggered by the quit button.
     * @throws IOException
     */
    @FXML
    void quitGame(ActionEvent event) throws IOException{
        App.restart = true;
        clearGridPane2();
        clearGridPane1();
        App.changeScreen("GameOver 1");
    }

    /**
     * Initializes the Table 2 screen.
     * @param arg0
     * @param arg1
     */
    @FXML
    private void initialize() {
        // Adiciona um ouvinte de evento onMouseClicked ao GridPane
        gridPane.setOnMouseClicked(this::handleGridPaneClick);
        gridPane.setOnMouseEntered(this::handleGridPaneEnter);
    }

    /**
     * Handles the mouse click event.
     * @param event The mouse event triggered by the mouse click.
     */
    public void setupGridPaneClickEvent() {
        if(App.restart){
            clearGridPane1();
            clearGridPane2();
            App.rectangles1.clear();
            App.rectangles2.clear();
            App.restart = false;
        }
        // Adicione o evento de clique ao GridPane
        gridPane.setOnMouseClicked(this::handleGridPaneClick);
        gridPane.setOnMouseEntered(this::handleGridPaneEnter);
    }

    /**
     * Handles the mouse click event.
     * @param event The mouse event triggered by the mouse click.
     */
    private void handleGridPaneEnter(MouseEvent event){
        int enteredColumn = (int) (event.getX() / gridPane.getWidth() * gridPane.getColumnCount());
        int enteredRow = (int) (event.getY() / gridPane.getHeight() * gridPane.getRowCount());

        System.out.println("Cursor na posição: Coluna " + enteredColumn + ", Linha " + enteredRow);
    }

    /**
     * Handles the mouse click event.
     * @param event The mouse event triggered by the mouse click.
     */
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

    /**
     * Checks if the player was hit.
     */
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

    /**
     * Initializes the Table 2 screen.
     * @param arg0
     * @param arg1
     */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        App.setTable2(gridPane2);
        gridPane.setOnMouseClicked(this::handleGridPaneClick);
        gridPane.setOnMouseEntered(this::handleGridPaneEnter);
    }

}

