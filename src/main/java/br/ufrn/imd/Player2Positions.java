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

    @FXML
    void insertCorveta(ActionEvent event) {
    }

    @FXML
    void insertDestroyer(ActionEvent event) {
    }

    @FXML
    void insertFragata(ActionEvent event) {
    }

    @FXML
    void insertSubmarino(ActionEvent event) {
    }

    @FXML
    void rotateCorveta(ActionEvent event) {
        if (rotateCButton.isSelected()){
            corveta.setRotate(90);
        }else{
            corveta.setRotate(0);
        }
    }

    @FXML
    void rotateDestroyer(ActionEvent event) {
        if (rotateDButton.isSelected()){
            destroyer.setRotate(90);
        }else{  
            destroyer.setRotate(0);
        }
    }

    @FXML
    void rotateFragata(ActionEvent event) {
        if (rotateFButton.isSelected()){
            fragata.setRotate(90);
        }else{
            fragata.setRotate(0);
        }
    }

    @FXML
    void rotateSubmarino(ActionEvent event) {
        if (rotateSButton.isSelected()){
            submarino.setRotate(90);
        }else{
            submarino.setRotate(0);
        }
    }

    @FXML
    void confirmPositions(ActionEvent event) throws IOException{
        App.table2Pos.equals(gridPane);
        App.changeScreen("Table 1");
        
    }

    @FXML
    private void initialize() {
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

