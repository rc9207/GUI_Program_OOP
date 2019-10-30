
package application;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Methods for manipulating the Database.
 *
 * @author Seth T. Graham
 */
public class ResourceMethods {

  private static final String JDBC_Driver = "org.h2.Driver";
  private static final String DB_URL = "jdbc:h2:./res/database";
  private static final String user = "";
  private static final String password = "";

  /**
   * Method to add products to PRODUCT database.
   *
   * @param name         Name of product.
   * @param manufacturer Manufacturer of product.
   * @param type         Type of product.
   */
  public void addProduct(String name, String manufacturer, String type) {
    try {

      Class.forName(JDBC_Driver);
      Connection connection = DriverManager.getConnection(DB_URL);

      if (connection != null) {
        PreparedStatement prStmt = connection.prepareStatement(
            "INSERT INTO PRODUCT (NAME, MANUFACTURER, TYPE) VALUES (?, ?, ?)",
            PreparedStatement.RETURN_GENERATED_KEYS);
        prStmt.setString(1, name);
        prStmt.setString(2, manufacturer);
        prStmt.setString(3, type);

        prStmt.executeUpdate();

        prStmt.close();
        connection.close();
      } else {
        throw new Exception("Could not connect to the database.");
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Used to connect to the database and create SQL statement for use in the getProductList().
   * Called upon by Initialize() in dashboardController.
   *
   * @return Copy and return getProductList() ObservableList.
   */
  public static ObservableList<ProductTable> getProducts() {

    String sql = "SELECT * FROM PRODUCT";

    try {
      Class.forName(JDBC_Driver);
      Connection connection = DriverManager.getConnection(DB_URL);

      if (connection != null) {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        ObservableList<ProductTable> productList = getProductList(rs);

        stmt.close();
        connection.close();

        return productList;

      } else {
        throw new Exception("Could not connect to the database...");
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * Utilized by getProducts(). Used to convert database data into usable strings and ints.
   *
   * @param rs SQL statement string, created in getProducts().
   * @return Create productList observable list.
   * @throws ClassNotFoundException Catch any ClassNotFoundExceptions.
   * @throws SQLException           Catch any SQL Exceptions.
   */
  private static ObservableList<ProductTable> getProductList(ResultSet rs) {

    try {
      ObservableList<ProductTable> productList = FXCollections.observableArrayList();

      while (rs.next()) {
        ProductTable productTable = new ProductTable();
        productTable.setId(rs.getInt("ID"));
        productTable.setName(rs.getString("NAME"));
        productTable.setManufacturer(rs.getString("MANUFACTURER"));
        productTable.setType(rs.getString("TYPE"));
        productList.add(productTable);
      }
      return productList;

    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * Method to return specific type number. Auto increments in ITEM_NUMBER database.
   *
   * @param type String value of ItemType Enum.
   * @return Integer value of itemNumber.
   */
  public int getItemNumber(String type) {

    int numOfItems = 0;
    int newNumOfItems = 0;

    try {

      Class.forName(JDBC_Driver);
      Connection connection = DriverManager.getConnection(DB_URL);

      if (connection != null) {

        PreparedStatement prGet;
        PreparedStatement prSet;
        ResultSet resGet;

        if (type.equalsIgnoreCase("AU")) {
          prGet = connection.prepareStatement("SELECT AUDIO FROM ITEM_NUMBER");
          resGet = prGet.executeQuery();

          while (resGet.next()) {
            numOfItems = resGet.getInt("AUDIO");
          }

          newNumOfItems = numOfItems + 1;

          prSet = connection.prepareStatement("UPDATE ITEM_NUMBER SET AUDIO = ?");
          prSet.setInt(1, newNumOfItems);
          prSet.executeUpdate();

          prGet.close();
          prSet.close();
          connection.close();

        } else if (type.equalsIgnoreCase("VI")) {
          prGet = connection.prepareStatement("SELECT VISUAL FROM ITEM_NUMBER");
          resGet = prGet.executeQuery();

          while (resGet.next()) {
            numOfItems = resGet.getInt("VISUAL");
          }

          newNumOfItems = numOfItems + 1;

          prSet = connection.prepareStatement("UPDATE ITEM_NUMBER SET VISUAL = ?");
          prSet.setInt(1, newNumOfItems);
          prSet.executeUpdate();

          prGet.close();
          prSet.close();
          connection.close();

        } else if (type.equalsIgnoreCase("AM")) {
          prGet = connection.prepareStatement("SELECT AUDIO_MOBILE FROM ITEM_NUMBER");
          resGet = prGet.executeQuery();

          while (resGet.next()) {
            numOfItems = resGet.getInt("AUDIO_MOBILE");
          }

          newNumOfItems = numOfItems + 1;

          prSet = connection.prepareStatement("UPDATE ITEM_NUMBER SET AUDIO_MOBILE = ?");
          prSet.setInt(1, newNumOfItems);
          prSet.executeUpdate();

          prGet.close();
          prSet.close();
          connection.close();

        } else if (type.equalsIgnoreCase("VM")) {
          prGet = connection.prepareStatement("SELECT VISUAL_MOBILE FROM ITEM_NUMBER");
          resGet = prGet.executeQuery();

          while (resGet.next()) {
            numOfItems = resGet.getInt("VISUAL_MOBILE");
          }

          newNumOfItems = numOfItems + 1;

          prSet = connection.prepareStatement("UPDATE ITEM_NUMBER SET VISUAL_MOBILE = ?");
          prSet.setInt(1, newNumOfItems);
          prSet.executeUpdate();

          prGet.close();
          prSet.close();
          connection.close();
        }
      }

      connection.close();

    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Could not connect to database...");
    }
    return numOfItems;
  }

  /**
   * Insert data into PRODUCTION_RECORD table.
   *
   * @param productID    Integer value for ProductID.
   * @param serialNumber String value of serialNumber created by generateSerialNum method located in
   *                     Production Record Class.
   * @param dateProduced java.sql.Date value for use inside of sql database.
   */
  public void addProductionRecord(int productID, String serialNumber, Date dateProduced) {

    try {

      Class.forName(JDBC_Driver);
      Connection connection = DriverManager.getConnection(DB_URL);

      if (connection != null) {
        PreparedStatement prStmt = connection.prepareStatement(
            "INSERT INTO PRODUCTION_RECORD (PRODUCT_ID, SERIAL_NUM, DATE_PRODUCED) "
                + "VALUES (?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
        prStmt.setInt(1, productID);
        prStmt.setString(2, serialNumber);
        prStmt.setDate(3, dateProduced);

        prStmt.executeUpdate();

        prStmt.close();
        connection.close();
      } else {
        throw new Exception("Could not connect to the database.");
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Allow other classes to utilize ProductionRecord ObservableArrayList.
   *
   * @return ProductionRecordList ObservableArrayList.
   */
  public static ObservableList<ProductionRecord> getProductionRecords() {

    try {

      Class.forName(JDBC_Driver);
      Connection connection = DriverManager.getConnection(DB_URL);

      if (connection != null) {
        PreparedStatement prGet = connection.prepareStatement("SELECT * FROM PRODUCTION_RECORD",
            PreparedStatement.RETURN_GENERATED_KEYS);

        ResultSet resGet = prGet.executeQuery();

        ObservableList<ProductionRecord> productionRecordList = getProductionRecordList(resGet);

        prGet.close();
        connection.close();

        return productionRecordList;
      }

    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Could not connect to database...");
    }
    return null;
  }

  /**
   * Utilized by getProductionRecords. Uses to take database information and place it into
   * observable array List.
   *
   * @param resGet ResultSet from getProductionRecords.
   * @return ObservableList of ProductionRecords.
   */
  private static ObservableList<ProductionRecord> getProductionRecordList(ResultSet resGet) {

    try {
      ObservableList<ProductionRecord> productionRecordList = FXCollections.observableArrayList();

      while (resGet.next()) {
        ProductionRecord productionRecord = new ProductionRecord();
        productionRecord.setProductionNumber(resGet.getInt("PRODUCTION_NUM"));
        productionRecord.setProductID(resGet.getInt("PRODUCT_ID"));
        productionRecord.setSerialNumber(resGet.getString("SERIAL_NUM"));
        productionRecord.setDateProduced(resGet.getDate("DATE_PRODUCED"));
        productionRecordList.add(productionRecord);

      }

      return productionRecordList;

    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}