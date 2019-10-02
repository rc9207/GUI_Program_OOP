package application;

/**
 * Driver class to start JavaFX Application.
 *
 * @author Seth T. Graham
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {

    Parent root = FXMLLoader.load(getClass().getResource("/application/Dashboard.fxml"));
    Scene scene = new Scene(root);
    primaryStage.setTitle("Product Tracker");
    primaryStage.setScene(scene);
    scene.getStylesheets()
        .add(getClass().getResource("/application/DashboardStyle.css").toExternalForm());
    primaryStage.show();
    primaryStage.setResizable(false);

  }

  public static void main(String[] args) {
    launch(args);
  }
}