import animatefx.animation.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.util.Optional;

public class AppInitializer extends Application {
    Parent root;

    public AppInitializer() {
        try {
            root = FXMLLoader.load(this.getClass().getResource("view/LoginFrom.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
//        primaryStage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("view/LoginFrom.fxml"))));
//        Parent root = FXMLLoader.load(this.getClass().getResource("view/ManageCustomerForm.fxml"));
        primaryStage.setScene(new Scene(root));
        Image image = new Image("assets/titleIcon.png");
        primaryStage.getIcons().add(image);
        primaryStage.setTitle("Sri Lanka Railway Department");
        primaryStage.sizeToScene();
        primaryStage.getScene().getWindow().addEventFilter(WindowEvent.WINDOW_CLOSE_REQUEST, this::closeWindowEvent);
        primaryStage.show();
//        new FadeInUpBig(root).play();
        new FadeIn(root).play();
//        new ZoomInUp(root).play();
    }

    private void closeWindowEvent(WindowEvent event) {
        System.out.println("Window close request ...");
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Are you sure you want to exit!");
        Optional<ButtonType> res = alert.showAndWait();
        if (res.isPresent()) {
            if (res.get().equals(ButtonType.CANCEL)) {
                event.consume();
            }else {
                new FadeOut(root).play();
            }
        }
    }
}

