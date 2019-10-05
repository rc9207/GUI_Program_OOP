/**
 * Methods for manipulating the Database.
 *
 * @author Seth T. Graham
 */

package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
  private static ObservableList<ProductTable> getProductList(ResultSet rs)
      throws ClassNotFoundException,
      SQLException {

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

}