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
    private static Scene tableScene;
    private static Scene playersScene;
    private static Scene helpScene;
    private static Scene player1Scene;
    private static Scene player2Scene;


    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        primaryStage.setTitle("Natalha Baval");
    
        FXMLLoader homeLoader = new FXMLLoader(getClass().getResource("/br/ufrn/imd/home.fxml"));
        FXMLLoader tableLoader = new FXMLLoader(getClass().getResource("/br/ufrn/imd/table.fxml"));
        FXMLLoader playersLoader = new FXMLLoader(getClass().getResource("/br/ufrn/imd/players.fxml"));
        FXMLLoader helpLoader = new FXMLLoader(getClass().getResource("/br/ufrn/imd/help.fxml"));
        FXMLLoader player1Loader = new FXMLLoader(getClass().getResource("/br/ufrn/imd/player1.fxml"));
        FXMLLoader player2Loader = new FXMLLoader(getClass().getResource("/br/ufrn/imd/player2.fxml"));
    
        // Instancie o controlador manualmente
        TableController tableController = new TableController();
    
        // Associe o controlador ao FXMLLoader
        tableLoader.setController(tableController);
    
        // Carregue o FXML (depois de configurar o controlador)
        Parent homeRoot = homeLoader.load();
        Parent tableRoot = tableLoader.load();
        Parent playersRoot = playersLoader.load();
        Parent helpRoot = helpLoader.load();
        Parent player1Root = player1Loader.load();
        Parent player2Root = player2Loader.load();
    
        // Configure qualquer funcionalidade adicional no controlador
        tableController.setupGridPaneClickEvent();
    
        homeScene = new Scene(homeRoot);
        tableScene = new Scene(tableRoot, 900, 600);
        playersScene = new Scene(playersRoot);
        helpScene = new Scene(helpRoot);
        player1Scene = new Scene(player1Root);
        player2Scene = new Scene(player2Root);
    
        homeScene.setRoot(homeRoot);
        tableScene.setRoot(tableRoot);
        playersScene.setRoot(playersRoot);
        helpScene.setRoot(helpRoot);
        player1Scene.setRoot(player1Root);
        player2Scene.setRoot(player2Root);

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
            case "Table":
                stage.setScene(tableScene);
                break;
            case "Help":
                stage.setScene(helpScene);
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