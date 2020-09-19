import animatefx.animation.*;
import db.DBConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.util.Duration;

import java.awt.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class AppInitializer extends Application {

//    private AnchorPane root;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
//        primaryStage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("view/LoginFrom.fxml"))));
        Parent root = FXMLLoader.load(this.getClass().getResource("view/LoginFrom.fxml"));
//        Scene scene = new Scene(root);
//        primaryStage.setScene(scene);
        primaryStage.setScene(new Scene(root));
        Image image = new Image("assets/titleIcon.png");
        primaryStage.getIcons().add(image);
        primaryStage.setTitle("Sri Lanka Railway Department");
        primaryStage.sizeToScene();
        primaryStage.show();
//        new FadeInUpBig(root).play();
        new FadeIn(root).play();
//        new ZoomInUp(root).play();
    }
}
