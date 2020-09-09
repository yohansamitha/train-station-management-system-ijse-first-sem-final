import db.DBConnection;
import javafx.application.Application;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.SQLException;

public class AppInitilizer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            System.out.println(connection);
            System.out.println(connection+" connection two");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
