package br.ufrn.imd;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {
    private static Stage stage;

    private static Scene homeScene;
    private static Scene detailedScene;

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        primaryStage.setTitle("Natalha Baval");
        
        FXMLLoader homeLoader = new FXMLLoader(getClass().getResource("/br/ufrn/imd/view/home.fxml"));
        FXMLLoader tableLoader = new FXMLLoader(getClass().getResource("/br/ufrn/imd/view/table.fxml"));
        
        Parent homeRoot = homeLoader.load();
        homeScene = new Scene(homeRoot, 640, 480);

        Parent tableRoot = tableLoader.load();
        detailedScene = new Scene(tableRoot, 640, 480);

        homeScene.setRoot(homeRoot);
        detailedScene.setRoot(tableRoot);

        primaryStage.setScene(homeScene);
        primaryStage.show();
        
    }

    public static void changeScreen(String src) throws IOException {
        switch (src) {
            case "Home":
                stage.setScene(homeScene);
                break;
        
            case "Table":
                stage.setScene(detailedScene);
                break;
            case "Help":
                stage.setScene(homeScene);
                break;
            case "Language":
                stage.setScene(homeScene);
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