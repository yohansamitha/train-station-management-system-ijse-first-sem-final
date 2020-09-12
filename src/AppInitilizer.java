import db.DBConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import java.awt.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class AppInitilizer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("view/LoginFrom.fxml"))));
        Image image = new Image("assets/titleIcon.png");
        primaryStage.getIcons().add(image);
        primaryStage.setTitle("Sri Lanka Railway Department");
        primaryStage.sizeToScene();
        primaryStage.show();
    }
}
