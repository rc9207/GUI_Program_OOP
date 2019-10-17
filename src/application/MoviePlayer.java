package application;

public class MoviePlayer extends Product implements MultiMediaControl {

  private Screen screen;
  private MonitorType monitorType;
  private ItemType itemType;

  /**
   * Constructor with 5 arguments.
   *
   * @param name String value of the product name.
   * @param manufacturer String value of the manufacturer.
   * @param screen Name of the Screen object.
   * @param monitorType Name of the monitorType Enum.
   * @param itemType Name of the itemType Enum.
   */
  public MoviePlayer(String name, String manufacturer, Screen screen, MonitorType monitorType,
      ItemType itemType) {
    super(name, manufacturer);
    this.screen = screen;
    this.monitorType = monitorType;
    this.itemType = itemType;
  }

  /**
   * Setter for the Screen Object.
   *
   * @param screen Name of the Screen object.
   */
  public void setScreen(Screen screen) {
    this.screen = screen;
  }

  /**
   * Getter for screen object.
   *
   * @return The memory location of this Screen object.
   */
  public Screen getScreen() {
    return screen;
  }

  /**
   * Setter for MonitorType Enum.
   *
   * @param monitorType Name of the particular Enumerated value.
   */
  public void setMonitorType(MonitorType monitorType) {
    this.monitorType = monitorType;
  }

  /**
   * Getter for monitorType field.
   *
   * @return The memory location of this particular MonitorType object.
   */
  public MonitorType getMonitorType() {
    return monitorType;
  }

  /**
   * Setter for ItemType Enum.
   *
   * @param itemType Name of the particular Enumerated value.
   */
  public void setItemType(ItemType itemType) {
    this.itemType = itemType;
  }

  /**
   * Getter for itemType field.
   *
   * @return The memory location of this particular ItemType object.
   */
  public ItemType getItemType() {
    return itemType;
  }

  /**
   * Method to play video.
   */
  @Override
  public void play() {
    System.out.println("Playing movie...");
  }

  /**
   * Method to stop the video.
   */
  @Override
  public void stop() {
    System.out.println("Stopping movie...");
  }

  /**
   * Method to go to the previous movie.
   */
  @Override
  public void previous() {
    System.out.println("Previous movie...");
  }

  /**
   * Method to go to the next movie.
   */
  @Override
  public void next() {
    System.out.println("Next movie...");
  }

  /**
   * Method to return string values of all the fields in an organized list.
   *
   * @return String info.
   */
  @Override
  public String toString() {
    String info;

    info = "Name: " + getName() + "\nManufacturer: " + getManufacturer() + "\nType: "
        + itemType.getType() + "\nScreen: \nResolution: " + screen.getResolution()
        + "\nRefresh rate: " + screen.getRefreshRate() + "\nResponse time: "
        + screen.getResponseTime() + "\nMonitor Type: "
        + monitorType.getMonitorType();

    return info;
  }
}
