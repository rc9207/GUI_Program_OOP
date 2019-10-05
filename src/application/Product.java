package application;

public abstract class Product implements Item {

  private int id;
  private String name;
  private String manufacturer;
  private String type;

  /**
   * Constructor for Product with two arguments.
   *
   * @param name Field is located locally.
   * @param manufacturer Field is located locally.
   */
  public Product(String name, String manufacturer) {
    this.name = name;
    this.manufacturer = manufacturer;
  }

  /**
   * Constructor for product with three arguments.
   *
   * @param name Field is located locally.
   * @param manufacturer Field is located locally.
   * @param type Field is located locally.
   */
  public Product(String name, String manufacturer, String type) {
    this.name = name;
    this.manufacturer = manufacturer;
    this.type = type;
  }

  /**
   * Setter for id field.
   *
   * @param id int value.
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * Getter for id field.
   *
   * @return Int value for id.
   */
  public int getID() {
    return id;
  }

  /**
   * Setter for name field.
   *
   * @param name String argument.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Getter for name field.
   *
   * @return String value of name field.
   */
  public String getName() {
    return name;
  }

  /**
   * Setter for manufacturer field.
   *
   * @param manufacturer String argument.
   */
  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  /**
   * Getter for manufacturer field.
   *
   * @return String value of manufacturer field.
   */
  public String getManufacturer() {
    return manufacturer;
  }

  /**
   * Setter for type field.
   *
   * @param type Int argument.
   */
  public void setType(String type) {
    this.type = type;
  }

  /**
   * Getter for type field.
   *
   * @return String value of type field.
   */
  public String getType() {
    return type;
  }

  /**
   * Method to take all fields in product and place them into a single string.
   *
   * @return String describing this object.
   */
  public String toString() {
    String info = "Name: " + name + "\nManufacturer: " + manufacturer + "\nType: " + type;

    return info;
  }
}