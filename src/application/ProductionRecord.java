package application;

import java.util.Date;

public class ProductionRecord {

  private int productionNumber;
  private int productID;
  private String serialNumber;
  private Date dateProduced;

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
   * @param dateProduced     Desired Date value for dateProduced field.
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
        + serialNumber
        + " Date: " + dateProduced;

    return info;
  }
}
