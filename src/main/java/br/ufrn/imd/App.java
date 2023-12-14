package br.ufrn.imd;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import java.util.ArrayList;

import java.io.IOException;
import br.ufrn.imd.controller.Game;
import br.ufrn.imd.model.RectangleG;

/**
 * The main class of the Natalha Baval application.
 * This class extends the JavaFX Application class and is responsible for starting the application and managing the scenes.
 */
public class App extends Application {
    private static Stage stage;

    private static Scene homeScene;
    private static Scene table1Scene;
    private static Scene table2Scene;
    private static Scene playersScene;
    private static Scene helpScene;
    private static Scene player1Scene;
    private static Scene player2Scene;
    private static Scene GameOver1Scene;
    private static Scene GameOver2Scene;
    
    public static boolean gameFinished = false;
    public static boolean restart = false;

    public static Game game = new Game();

    public static GridPane table1 = new GridPane();
    public static GridPane table1Pos = new GridPane();
    public static ArrayList<RectangleG> rectangles1 = new ArrayList<RectangleG>();

    public static GridPane table2 = new GridPane();
    public static GridPane table2Pos = new GridPane();
    public static ArrayList<RectangleG> rectangles2 = new ArrayList<RectangleG>();

    /**
     * Sets the table1 GridPane.
     * @param table1 The GridPane representing table1.
     */
    public static void setTable1(GridPane table1){
        App.table1.equals(table1);
    }

    /**
     * Sets the table2 GridPane.
     * @param table2 The GridPane representing table2.
     */
    public static void setTable2(GridPane table2){
        App.table2.equals(table2);
    }

    /**
     * Creates and returns the GridPane representation of table1.
     * @return The GridPane representing table1.
     */
    public static GridPane makeTable1(){
        for(RectangleG r : rectangles1){
            table1.add(r.getRectangle(), r.getX(), r.getY());
        }
        return table1;
    }

    /**
     * Creates and returns the GridPane representation of table2.
     * @return The GridPane representing table2.
     */
    public static GridPane makeTable2(){
        for(RectangleG r : rectangles2){
            table2.add(r.getRectangle(), r.getX(), r.getY());
        }
        return table2;
    }

    /**
     * Starts the Natalha Baval application.
     * @param primaryStage The primary stage for the application.
     * @throws IOException If an error occurs while loading the FXML files.
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        primaryStage.setTitle("Natalha Baval");
    
        FXMLLoader homeLoader = new FXMLLoader(getClass().getResource("/br/ufrn/imd/home.fxml"));
        FXMLLoader table1Loader = new FXMLLoader(getClass().getResource("/br/ufrn/imd/table1.fxml"));
        FXMLLoader playersLoader = new FXMLLoader(getClass().getResource("/br/ufrn/imd/players.fxml"));
        FXMLLoader helpLoader = new FXMLLoader(getClass().getResource("/br/ufrn/imd/help.fxml"));
        FXMLLoader player1Loader = new FXMLLoader(getClass().getResource("/br/ufrn/imd/player1.fxml"));
        FXMLLoader player2Loader = new FXMLLoader(getClass().getResource("/br/ufrn/imd/player2.fxml"));
        FXMLLoader table2Loader = new FXMLLoader(getClass().getResource("/br/ufrn/imd/table2.fxml"));
        FXMLLoader GameOver1Loader = new FXMLLoader(getClass().getResource("/br/ufrn/imd/gameover1.fxml"));
        FXMLLoader GameOver2Loader = new FXMLLoader(getClass().getResource("/br/ufrn/imd/gameover2.fxml"));

        // Instancie o controlador manualmente
        Table1Controller table1Controller = new Table1Controller();
    
        // Associe o controlador ao FXMLLoader
        table1Loader.setController(table1Controller);
    
        // Carregue o FXML (depois de configurar o controlador)
        Parent homeRoot = homeLoader.load();
        Parent table1Root = table1Loader.load();
        Parent table2Root = table2Loader.load();
        Parent playersRoot = playersLoader.load();
        Parent helpRoot = helpLoader.load();
        Parent player1Root = player1Loader.load();
        Parent player2Root = player2Loader.load();
        Parent GameOver1Root = GameOver1Loader.load();
        Parent GameOver2Root = GameOver2Loader.load();
    
        // Configure qualquer funcionalidade adicional no controlador
        table1Controller.setupGridPaneClickEvent();
    
        homeScene = new Scene(homeRoot);
        table1Scene = new Scene(table1Root);
        table2Scene = new Scene(table2Root);
        playersScene = new Scene(playersRoot);
        helpScene = new Scene(helpRoot);
        player1Scene = new Scene(player1Root);
        player2Scene = new Scene(player2Root);
        GameOver1Scene = new Scene(GameOver1Root);
        GameOver2Scene = new Scene(GameOver2Root);

        primaryStage.setScene(homeScene);
        primaryStage.show();
    }
    

    /**
     * Changes the current scene to the specified scene.
     * @param src The name of the scene to change to.
     * @throws IOException If an error occurs while loading the FXML file for the specified scene.
     */
    public static void changeScreen(String src) throws IOException {
        switch (src) {
            case "Home":
                stage.setScene(homeScene);
                break;
            case "Players":
                stage.setScene(playersScene);
                break;
            case "Player1":
                stage.setScene(player1Scene);
                break;
            case "Player2":
                stage.setScene(player2Scene);
                break;
            case "Table 1":
                stage.setScene(table1Scene);
                break;
            case "Table 2":
                stage.setScene(table2Scene);
                break;
            case "Help":
                stage.setScene(helpScene);
                break;
            case "GameOver 1":
                stage.setScene(GameOver1Scene);
                break;
            case "GameOver 2":
                stage.setScene(GameOver2Scene);
                break;
        }
    }

    /**
     * Sets the root of the home scene to the specified FXML file.
     * @param fxml The name of the FXML file to set as the root.
     * @throws IOException If an error occurs while loading the FXML file.
     */
    static void setRoot(String fxml) throws IOException {
        homeScene.setRoot(loadFXML(fxml));
    }

    /**
     * Loads the FXML file with the specified name and returns the root node.
     * @param fxml The name of the FXML file to load.
     * @return The root node of the loaded FXML file.
     * @throws IOException If an error occurs while loading the FXML file.
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    /**
     * The main method of the Natalha Baval application.
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        launch();
    }

}