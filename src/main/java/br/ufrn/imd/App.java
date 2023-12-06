package br.ufrn.imd;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
//import br.ufrn.imd.controller.Game;

import java.io.IOException;

/**
 * JavaFX App
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
    
        // homeScene.setRoot(homeRoot);
        // table1Scene.setRoot(table1Root);
        // table2Scene.setRoot(table2Root);
        // playersScene.setRoot(playersRoot);
        // helpScene.setRoot(helpRoot);
        // player1Scene.setRoot(player1Root);
        // player2Scene.setRoot(player2Root);

        //Game game = new Game();


    
        primaryStage.setScene(homeScene);
        primaryStage.show();
    }
    

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

    static void setRoot(String fxml) throws IOException {
        homeScene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}