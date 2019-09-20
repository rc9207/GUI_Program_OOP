
package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {

    Parent root = FXMLLoader.load(getClass().getResource("/Dashboard.fxml"));
    Scene scene = new Scene(root);
    primaryStage.setTitle("Product Tracker");
    primaryStage.setScene(scene);
    scene.getStylesheets().add(getClass().getResource("/DashboardStyle.css").toExternalForm());
    primaryStage.show();

  }

  public static void main(String[] args) {
    launch(args);
  }
}