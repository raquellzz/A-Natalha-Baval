package br.ufrn.imd;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
//import javafx.scene.control.Cell;
import javafx.scene.control.CheckBox;
//import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.ufrn.imd.utils.Board;

public class Player1Positions implements Initializable{

    @FXML
    private Button confirmButton;

    @FXML
    private Rectangle corveta;

    @FXML
    private Rectangle destroyer;

    @FXML
    private Rectangle fragata;

    @FXML
    private GridPane gridPane;

    @FXML
    private Rectangle submarino;

    @FXML
    private CheckBox rotateCButton;

    @FXML
    private CheckBox rotateDButton;

    @FXML
    private CheckBox rotateFButton;

    @FXML
    private CheckBox rotateSButton;


    DraggableMaker draggableMaker = new DraggableMaker();
    private Board board;



    @FXML
    void rotateCorverta(ActionEvent event) {
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
        App.changeScreen("Player2");
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

    /*private void handleGridPaneEnter(MouseEvent event) {
        int enteredColumn = (int) (event.getX() / gridPane.getWidth() * gridPane.getColumnCount());
        int enteredRow = (int) (event.getY() / gridPane.getHeight() * gridPane.getRowCount());

        System.out.println("Cursor na posição: Coluna " + enteredColumn + ", Linha " + enteredRow);

        Rectangle rectangle = new Rectangle(50, 50 , Color.RED); // Create a rectangle with desired color
        gridPane.add(rectangle, enteredColumn, enteredRow); // Add the rectangle to the gridPane
    }

    private void handleGridPaneClick(MouseEvent event) {
        // Lógica a ser executada quando o GridPane for clicado
        int clickedColumn = (int) (event.getX() / gridPane.getWidth() * gridPane.getColumnCount()) + 1;
        int clickedRow = (int) (event.getY() / gridPane.getHeight() * gridPane.getRowCount()) + 1;

        Cell cell = getCell(clickedColumn, clickedRow);

        
        System.out.println("Clicou na posição: Coluna " + clickedColumn + ", Linha " + clickedRow);

    }*/

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        draggableMaker.makeDraggable(corveta);
        draggableMaker.makeDraggable(destroyer);
        draggableMaker.makeDraggable(fragata);
        draggableMaker.makeDraggable(submarino);

        board = new Board();
        gridPane.getChildren().add(board);

        gridPane.setOnMouseClicked(this::handleGridPaneClick);
        gridPane.setOnMouseEntered(this::handleGridPaneEnter);
    }

        private void handleGridPaneClick(MouseEvent event) {
        int enteredColumn = (int) (event.getX() / gridPane.getWidth() * gridPane.getColumnCount());
        int enteredRow = (int) (event.getY() / gridPane.getHeight() * gridPane.getRowCount());

        System.out.println("Cursor na posição: Coluna " + enteredColumn + ", Linha " + enteredRow);

        Rectangle rectangle = new Rectangle(200, 40 , Color.GREENYELLOW); // Create a rectangle with desired color
        gridPane.add(rectangle, enteredColumn, enteredRow); // Add the rectangle to the gridPane
    }

    private void handleGridPaneEnter(MouseEvent event) {
        // Lógica a ser executada quando o GridPane for clicado
        int clickedColumn = (int) (event.getX() / gridPane.getWidth() * gridPane.getColumnCount()) + 1;
        int clickedRow = (int) (event.getY() / gridPane.getHeight() * gridPane.getRowCount()) + 1;

        //Board.Cell cell = board.getCell(clickedColumn, clickedRow);

        System.out.println("Clicou na posição: Coluna " + clickedColumn + ", Linha " + clickedRow);
    }

}

