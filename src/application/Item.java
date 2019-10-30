package application;

/**
 * Interface that has use in Product, AudioPlayer, and MoviePlayer.
 *
 * @Author: Seth T. Graham
 */
public interface Item {

  /**
   * Getter to return id field.
   *
   * @return Int for id field.
   */
  int getID();

  /**
   * Setter for name field.
   *
   * @param name String argument.
   */
  void setName(String name);

  /**
   * Getter for name field.
   *
   * @return String value of name field.
   */
  String getName();

  /**
   * Setter for manufacturer field.
   *
   * @param manufacturer String argument.
   */
  void setManufacturer(String manufacturer);

  /**
   * Getter for manufacturer field.
   *
   * @return String value of manufacturer field.
   */
  String getManufacturer();
}
