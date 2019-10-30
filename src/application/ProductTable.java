package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Class that describes and creates productTables.
 *
 * @author Seth T. Graham
 */
public class ProductTable {

  private IntegerProperty id;
  private StringProperty name;
  private StringProperty manufacturer;
  private StringProperty type;

  /**
   * Constructor for ProductTable().
   */
  public ProductTable() {
    this.id = new SimpleIntegerProperty();
    this.name = new SimpleStringProperty();
    this.manufacturer = new SimpleStringProperty();
    this.type = new SimpleStringProperty();
  }

  /**
   * Setter for IntegerProperty id.
   *
   * @param id IntegerProperty value for ID column.
   */
  public void setId(Integer id) {
    this.id.set(id);
  }

  /**
   * Setter for StringProperty name.
   *
   * @param name StringProperty value for NAME column.
   */
  public void setName(String name) {
    this.name.set(name);
  }

  /**
   * Setter for StringProperty manufacturer.
   *
   * @param manufacturer StringProperty value for MANUFACTURER column.
   */
  public void setManufacturer(String manufacturer) {
    this.manufacturer.set(manufacturer);
  }

  /**
   * Setter for StringProperty type.
   *
   * @param type StringProperty value for TYPE column.
   */
  public void setType(String type) {
    this.type.set(type);
  }

  /**
   * Getter for id.
   *
   * @return Integer value for ID column.
   */
  public Integer getId() {
    return id.get();
  }

  /**
   * Getter for name.
   *
   * @return String value for NAME column.
   */
  public String getName() {
    return name.get();
  }

  /**
   * Getter for manufacturer.
   *
   * @return String value for MANUFACTURER column.
   */
  public String getManufacturer() {
    return manufacturer.get();
  }

  /**
   * Getter for type.
   *
   * @return String value for TYPE column.
   */
  public String getType() {
    return type.get();
  }

  @Override
  public String toString() {
    String info;

    info = "Product ID: " + getId() + "\t\tProduct Name: " + getName() + "\t\tManufacturer: "
        + getManufacturer() + "\t\tType: " + getType();

    return info;
  }
}


