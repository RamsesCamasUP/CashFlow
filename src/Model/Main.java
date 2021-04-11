package Model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private static Scene scene;
    private static Stage stage;
    private static Stage secondStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        scene = new Scene(loadFXML("Root"));
        stage = primaryStage;
        primaryStage.setTitle("CashFlow");
        primaryStage.getIcons().add(new Image("imgs/takagi.jpg"));
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void setFXML(String fxml,String title) throws IOException {
        scene.setRoot(loadFXML(fxml));
        stage.sizeToScene();
        stage.centerOnScreen();
        stage.setTitle(title);
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("../View/"+ fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void newStage(String fxml, String title) {
        try {
            Parent node = loadFXML(fxml);
            secondStage = new Stage();
            Scene scene = new Scene(node);
            secondStage.setScene(scene);
            secondStage.setTitle(title);
            secondStage.initOwner(stage);
            secondStage.initModality(Modality.WINDOW_MODAL);
            secondStage.centerOnScreen();
            secondStage.showAndWait();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static Stage getSecondStage() {
        return secondStage;
    }
}
