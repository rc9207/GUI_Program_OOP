package application;

public enum ItemType {

  AUDIO("AU"), VISUAL("VI"), AUDIO_MOBILE("AM"), VISUAL_MOBILE("VM");

  private final String type;

  /**
   * Constructor for ItemType Enum.
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
