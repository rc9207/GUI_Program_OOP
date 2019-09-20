package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.io.IOException;

public class DashboardController {

  @FXML
  private Button addProductButton;
  @FXML
  private Button recordProductionButton;

  public void addProductButtonPushed(ActionEvent event) throws IOException {

    System.out.println("Add Product button was pushed.");
  }

  public void recordProductionButtonPushed(ActionEvent event) throws IOException {

    System.out.println("Record Production button was pushed.");
  }
}
