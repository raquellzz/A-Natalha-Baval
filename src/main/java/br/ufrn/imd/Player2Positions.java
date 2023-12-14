package br.ufrn.imd;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller class for the Player 2 Positions screen.
 * This class is responsible for controlling the Player 2 Positions screen.
 */
public class Player2Positions implements Initializable{

    @FXML
    private Button confirmButton;

    @FXML
    private GridPane gridPane;

    @FXML
    private CheckBox rotateCButton;

    @FXML
    private CheckBox rotateDButton;

    @FXML
    private CheckBox rotateFButton;

    @FXML
    private CheckBox rotateSButton;

    @FXML
    private Rectangle corveta;

    @FXML
    private Rectangle destroyer;

    @FXML
    private Rectangle fragata;

    @FXML
    private Rectangle submarino;

    @FXML
    private ToggleButton corvetaB;


    @FXML
    private ToggleButton submarinoB;


    @FXML
    private ToggleButton fragataB;


    @FXML
    private ToggleButton destroyerB;

    DraggableMaker draggableMaker = new DraggableMaker();

    /**
     * Handles the rotate corveta button action.
     * Rotates the corveta when the rotate corveta button is clicked.
     * 
     * @param event
     */
    @FXML
    void rotateCorveta(ActionEvent event) {
        if (rotateCButton.isSelected()){
            corveta.setRotate(90);
        }else{
            corveta.setRotate(0);
        }
    }

    /**
     * Handles the rotate destroyer button action.
     * Rotates the destroyer when the rotate destroyer button is clicked.
     * 
     * @param event
     */
    @FXML
    void rotateDestroyer(ActionEvent event) {
        if (rotateDButton.isSelected()){
            destroyer.setRotate(90);
        }else{  
            destroyer.setRotate(0);
        }
    }

    /**
     * Handles the rotate fragata button action.
     * Rotates the fragata when the rotate fragata button is clicked.
     * 
     * @param event
     */
    @FXML
    void rotateFragata(ActionEvent event) {
        if (rotateFButton.isSelected()){
            fragata.setRotate(90);
        }else{
            fragata.setRotate(0);
        }
    }

    /**
     * Handles the rotate submarino button action.
     * Rotates the submarino when the rotate submarino button is clicked.
     * 
     * @param event
     */
    @FXML
    void rotateSubmarino(ActionEvent event) {
        if (rotateSButton.isSelected()){
            submarino.setRotate(90);
        }else{
            submarino.setRotate(0);
        }
    }

    /**
     * Handles the confirm positions button action.
     * Changes the screen to the Table 1 screen when the confirm positions button is clicked.
     * 
     * @param event
     * @throws IOException
     */
    @FXML
    void confirmPositions(ActionEvent event) throws IOException{
        App.table2Pos.equals(gridPane);
        App.changeScreen("Table 1");
        
    }

    /**
     * Handles the back button action.
     * Changes the screen to the Home screen when the back button is clicked.
     * 
     */
    @FXML
    private void initialize() {
        // Adiciona um ouvinte de evento onMouseClicked ao GridPane
        gridPane.setOnMouseClicked(this::handleGridPaneClick);
        gridPane.setOnMouseEntered(this::handleGridPaneEnter);
    }

    /**
     * Handles the back button action.
     * 
     */
    public void setupGridPaneClickEvent() {
        // Adicione o evento de clique ao GridPane
        gridPane.setOnMouseClicked(this::handleGridPaneClick);
        gridPane.setOnMouseEntered(this::handleGridPaneEnter);
    }

    /**
     * Handles the grid pane click event.
     * 
     * @param event
     */
    private void handleGridPaneEnter(MouseEvent event){
        int enteredColumn = (int) (event.getX() / gridPane.getWidth() * gridPane.getColumnCount());
        int enteredRow = (int) (event.getY() / gridPane.getHeight() * gridPane.getRowCount());

        System.out.println("Cursor na posição: Coluna " + enteredColumn + ", Linha " + enteredRow);
    }

    /**
     * Handles the grid pane click event.
     * 
     * @param event
     */
    private void handleGridPaneClick(MouseEvent event) {
        // Lógica a ser executada quando o GridPane for clicado
        int clickedColumn = (int) (event.getX() / gridPane.getWidth() * gridPane.getColumnCount()) + 1;
        int clickedRow = (int) (event.getY() / gridPane.getHeight() * gridPane.getRowCount()) + 1;

        if(corvetaB.isSelected()){
            if(rotateCButton.isSelected()){
                if(clickedColumn < 10 && clickedRow < 10){
                    gridPane.getChildren().remove(corveta);
                    gridPane.add(corveta, clickedColumn, clickedRow);
                }
            }else{
                if(clickedColumn < 10 && clickedRow < 10){
                    gridPane.getChildren().remove(corveta);
                    gridPane.add(corveta, clickedColumn - 1, clickedRow - 1);
                }
            }
        } else if(submarinoB.isSelected()){
            if(rotateSButton.isSelected()){
                if(clickedColumn < 10 && clickedRow < 10){
                    gridPane.getChildren().remove(submarino);
                    gridPane.add(submarino, clickedColumn, clickedRow);
                }
            }else{
                if(clickedColumn < 10 && clickedRow < 10){
                    gridPane.getChildren().remove(submarino);
                    gridPane.add(submarino, clickedColumn - 1, clickedRow - 1);
                }
            }

        } else if(fragataB.isSelected()){
            if(rotateFButton.isSelected()){
                if(clickedColumn < 10 && clickedRow < 10){
                    gridPane.getChildren().remove(fragata);
                    gridPane.add(fragata, clickedColumn, clickedRow);
                    }
            }else{
                if(clickedColumn < 10 && clickedRow < 10){
                    gridPane.getChildren().remove(fragata);
                    gridPane.add(fragata, clickedColumn - 1, clickedRow - 1);
                }
            }

        } else if(destroyerB.isSelected()){
            if(rotateDButton.isSelected()){
                if(clickedColumn < 10 && clickedRow < 10){
                    gridPane.getChildren().remove(destroyer);
                    gridPane.add(destroyer, clickedColumn, clickedRow);
                    
                }
            }else{
                if(clickedColumn < 10 && clickedRow < 10){
                    gridPane.getChildren().remove(destroyer);
                    gridPane.add(destroyer, clickedColumn - 1, clickedRow - 1);
                
                }
            }
        }

        System.out.println("Clicou na posição: Coluna " + clickedColumn + ", Linha " + clickedRow);
    }

    /**
     * Initializes the Player 2 Positions screen.
     * 
     * @param arg0
     * @param arg1
     */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        draggableMaker.makeDraggable(corveta);
        draggableMaker.makeDraggable(destroyer);
        draggableMaker.makeDraggable(fragata);
        draggableMaker.makeDraggable(submarino);

        gridPane.setOnMouseClicked(this::handleGridPaneClick);
        gridPane.setOnMouseEntered(this::handleGridPaneEnter);
    }

}

