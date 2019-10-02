package application;

public enum ItemType {

  AU("Audio"), VI("Visual"), AM("Audio Mobile"), VM("Visual Mobile");

  private final String type;

  ItemType(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }
}
