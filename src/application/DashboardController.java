package application;

import java.io.IOException;
import java.sql.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Methods for Dashboard JavaFX.
 *
 * @author Seth T. Graham
 */
public class DashboardController {

  private ItemType itemType;
  private ObservableList<ProductTable> productList;
  private ObservableList<ProductionRecord> prodRecordList;

  private ObservableList comboBoxList = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6,
      7, 8, 9, 10);

  @FXML
  private Button addProductButton;
  @FXML
  private Button recordProductionButton;
  @FXML
  private TextField productName;
  @FXML
  private TextField manufacturer;
  @FXML
  private ChoiceBox<ItemType> choiceBoxType;
  @FXML
  private ComboBox<String> comboBoxQuantity;
  @FXML
  private TableView<ProductTable> tableView;
  @FXML
  private TableColumn<ProductTable, Integer> colId;
  @FXML
  private TableColumn<ProductTable, String> colName;
  @FXML
  private TableColumn<ProductTable, String> colMan;
  @FXML
  private TableColumn<ProductTable, String> colType;
  @FXML
  private ListView<ProductTable> listView;
  @FXML
  private TextArea textArea;

  /**
   * Generate data upon loading of Dashboard.fxml
   *
   * @throws Exception Catch and Throw all Exceptions.
   */
  @FXML
  private void initialize() throws Exception {

    productList = ResourceMethods.getProducts();
    prodRecordList = ResourceMethods.getProductionRecords();

    choiceBoxType.setItems(FXCollections.observableArrayList(itemType.values()));

    comboBoxQuantity.setItems(comboBoxList);
    comboBoxQuantity.setEditable(true);
    comboBoxQuantity.getSelectionModel().selectFirst();

    colId.setCellValueFactory(new PropertyValueFactory<>("id"));
    colName.setCellValueFactory(new PropertyValueFactory<>("name"));
    colMan.setCellValueFactory(new PropertyValueFactory<>("manufacturer"));
    colType.setCellValueFactory(new PropertyValueFactory<>("type"));

    tableView.setItems(productList);

    listView.setItems(productList);

    for (ProductionRecord productionRecord : prodRecordList) {
      textArea.appendText(productionRecord.toString());
    }
  }

  /**
   * Insert data into PRODUCT table when pushed.
   *
   * @param event pressed button.
   * @throws IOException Throw exception if needed.
   */
  public void addProductButtonPushed(ActionEvent event) throws Exception {

    String productNameString = productName.getText();
    String manufacturerString = manufacturer.getText();
    String typeString = choiceBoxType.getValue().getType();

    ResourceMethods rm = new ResourceMethods();
    rm.addProduct(productNameString, manufacturerString, typeString);

    productName.clear();
    manufacturer.clear();
    initialize();
  }

  /**
   * Print value when Record Production button has been pressed.
   *
   * @param event pressed button.
   * @throws IOException Throw exception if needed.
   */
  public void recordProductionButtonPushed(ActionEvent event) throws Exception {

    int prodID;
    String manInfo;
    String typInfo;
    String serialNumber;

    prodID = productList.get(listView.getSelectionModel().getSelectedIndex()).getId();
    manInfo = productList.get(listView.getSelectionModel().getSelectedIndex()).getManufacturer();
    typInfo = productList.get(listView.getSelectionModel().getSelectedIndex()).getType();
    String quantity = (String) comboBoxQuantity.getSelectionModel().getSelectedItem();
    int quantityInt = Integer.parseInt(quantity);

    ProductionRecord proRecord = new ProductionRecord(prodID);

    for (int i = 0; i <= quantityInt; i++) {

      serialNumber = proRecord.generateSerialNum(manInfo, typInfo);
      Date sqlDate = new java.sql.Date(new java.util.Date().getTime());

      ResourceMethods resMeth = new ResourceMethods();
      resMeth.addProductionRecord(prodID, serialNumber, sqlDate);

      textArea.clear();
      initialize();
    }
  }
}
