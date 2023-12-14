package br.ufrn.imd;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
import br.ufrn.imd.model.RectangleG;


import java.net.URL;
import java.io.IOException;
import java.util.ResourceBundle;

/**
 * Controller class for the Table 1 screen.
 * This class is responsible for controlling the Table 1 screen.
 */
public class Table1Controller implements Initializable{

    @FXML
    private GridPane gridPane;

    @FXML
    private GridPane gridPane2 = App.makeTable2();

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
     * Changes the screen to the Table 2 screen when the shoot button is clicked.
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
            
            

            App.changeScreen("Table 2");
        }
    }

    /**
     * Creates a gridpane with the rectangles that were shot
     * 
     */
    public void setGridPane2(){
        Rectangle rectangle = new Rectangle(30, 30);

        rectangle.setStyle("-fx-fill: #008080;");
        RectangleG rectangle2 = new RectangleG(rectangle, clickedColumn1 - 1, clickedRow1 - 1);
        App.rectangles1.add(rectangle2);

        rectangles.add(rectangle1);
            //gridPane2.add(rectangle, clickedColumn1 - 1, clickedRow1 - 1);
            //App.setTable1(gridPane2);
            
            //gridPane2.equals(App.getTable2());
        
        for(RectangleG r : App.rectangles2){
            gridPane2.add(r.getRectangle(), r.getX(), r.getY());
        }
    }

    /**
     * Clear the GridPane 2
     */
    public void clearGridPane2(){
        for(RectangleG r : App.rectangles2){
            gridPane2.getChildren().remove(r.getRectangle());
        }
    }

    /**
     * Clear the GridPane 1
     */
    public void clearGridPane1(){
        for(Rectangle r : rectangles){
            gridPane.getChildren().remove(r);
        }
    }

    /**
     * Initializes the Table1 screen.
     */
    @FXML
    private void initialize() {
        
        // Adiciona um ouvinte de evento onMouseClicked ao GridPane
        gridPane.setOnMouseClicked(this::handleGridPaneClick);
        gridPane.setOnMouseEntered(this::handleGridPaneEnter);
    }

    /**
     * Sets the click event to the GridPane.
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
     * Handles the GridPane click event.
     * @param event The mouse event triggered by the GridPane.
     */
    private void handleGridPaneEnter(MouseEvent event){
        int enteredColumn = (int) (event.getX() / gridPane.getWidth() * gridPane.getColumnCount());
        int enteredRow = (int) (event.getY() / gridPane.getHeight() * gridPane.getRowCount());

        System.out.println("Cursor na posição: Coluna " + enteredColumn + ", Linha " + enteredRow);
    }

    /**
     * Handles the GridPane click event.
     * @param event The mouse event triggered by the GridPane.
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
     * Initializes the Table1 screen.
     */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        App.setTable1(gridPane2);
        gridPane.setOnMouseClicked(this::handleGridPaneClick);
        gridPane.setOnMouseEntered(this::handleGridPaneEnter);
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
        App.changeScreen("GameOver 2");
    }

}
