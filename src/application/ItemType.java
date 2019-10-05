package application;

public enum ItemType {

  Audio("AU"), Visual("VI"), Audio_Mobile("AM"), Visual_Mobile("VM");

  private final String type;

  /**
   * Private constructor for ItemType Enum.
   *
   * @param type Alternate meaning for Enum.
   */
  ItemType(String type) {
    this.type = type;
  }

  /**
   * Return String value of type.
   *
   * @return return String type.
   */
  public String getType() {
    return type;
  }
}
