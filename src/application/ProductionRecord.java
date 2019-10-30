package application;

import java.util.Date;

public class ProductionRecord {

  private int productionNumber;
  private int productID;
  private String serialNumber;
  private Date dateProduced;

  /**
   * ProductionRecord constructor with no parameters.
   */
  public ProductionRecord() {
  }

  /**
   * Constructor with 1 parameter.
   *
   * @param productID Desired int value for productID.
   */
  public ProductionRecord(int productID) {
    this.productID = productID;
    productionNumber = 0;
    serialNumber = "0";
    dateProduced = new Date();
  }

  /**
   * Constructor with four arguments.
   *
   * @param productionNumber Desired int value for productionRecord field.
   * @param productID        Desired int value for productId field.
   * @param serialNumber     Desired String value for serialNumber field.
   */
  public ProductionRecord(int productionNumber, int productID, String serialNumber,
      Date dateProduced) {

    this.productionNumber = productionNumber;
    this.productID = productID;
    this.serialNumber = serialNumber;
    this.dateProduced = new Date(dateProduced.getTime());
  }

  /**
   * Setter for productionNumber field.
   *
   * @param productionNumber Desired int value for productionNumber field.
   */
  public void setProductionNumber(int productionNumber) {
    this.productionNumber = productionNumber;
  }

  /**
   * Getter for productionNumber field.
   *
   * @return Integer value for productionNumber field.
   */
  public int getProductionNumber() {
    return productionNumber;
  }

  /**
   * Setter for productID field.
   *
   * @param productID Desired int value for productID field.
   */
  public void setProductID(int productID) {
    this.productID = productID;
  }

  /**
   * Getter for productID field.
   *
   * @return Integer value of productID field.
   */
  public int getProductID() {
    return productID;
  }

  /**
   * Setter for serialNumber field.
   *
   * @param serialNumber Desired string value for serialNumber field.
   */
  public void setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  /**
   * Method to take data from PRODUCT database and convert it into a usable serial number. Also uses
   * ITEM_NUMBER database to generate a unique serial number for each Type of device.
   *
   * @param manufacturer Desired String manufacturer you wish to modify.
   * @param type         Desired String type you wish to modify.
   * @return Combine all values to generate unique serialNumber.
   */
  public String generateSerialNum(String manufacturer, String type) {

    manufacturer = manufacturer.substring(0, 3);
    manufacturer = manufacturer.toUpperCase();

    ResourceMethods rm = new ResourceMethods();

    int itemNumber = rm.getItemNumber(type);
    String padItemNumber = String.format("%05d", itemNumber);

    String serNumber = manufacturer + type + padItemNumber;

    return serNumber;
  }

  /**
   * Getter for serialNumber field.
   *
   * @return String value of serialNumber field.
   */
  public String getSerialNumber() {
    return serialNumber;
  }

  /**
   * Setter for dateProduced field.
   *
   * @param dateProduced Desired value for dateProduced field.
   */
  public void setDateProduced(Date dateProduced) {
    this.dateProduced = new Date(dateProduced.getTime());
  }

  /**
   * Getter for dateProduced field.
   *
   * @return Date value of dateProduced field.
   */
  public Date getDateProduced() {
    return new Date(dateProduced.getTime());
  }

  /**
   * Method to return String value of all fields.
   *
   * @return String value of all Production Record fields.
   */
  @Override
  public String toString() {
    String info;

    info = "Prod. Num: " + productionNumber + " Product ID: " + productID + " Serial Num: "
        + serialNumber + " Date: " + dateProduced + "\n";

    return info;
  }
}
