package application;

/**
 * Class used to describe and create new Screen objects.
 *
 * @Author: Seth T. Graham
 */
public class Screen implements ScreenSpec {

  private String resolution;
  private int refreshRate;
  private int responseTime;

  /**
   * Constructor with 3 parameters.
   *
   * @param resolution   String value of resolution.
   * @param refreshRate  Integer value of refreshRate.
   * @param responseTime Integer value of responseTime.
   */
  public Screen(String resolution, int refreshRate, int responseTime) {
    this.resolution = resolution;
    this.refreshRate = refreshRate;
    this.responseTime = responseTime;
  }

  /**
   * Setter for resolution field.
   *
   * @param resolution Resolution of screen.
   */
  public void setResolution(String resolution) {
    this.resolution = resolution;
  }

  /**
   * Getter for resolution field.
   *
   * @return String value of resolution.
   */
  @Override
  public String getResolution() {
    return resolution;
  }

  /**
   * Setter for refreshRate field.
   *
   * @param refreshRate Refresh rate of the screen.
   */
  public void setRefreshRate(int refreshRate) {
    this.refreshRate = refreshRate;
  }

  /**
   * Getter for refreshRate field.
   *
   * @return Integer value of refreshRate field.
   */
  @Override
  public int getRefreshRate() {
    return refreshRate;
  }

  /**
   * Setter for responseTime field.
   *
   * @param responseTime Response time of the screen.
   */
  public void setResponseTime(int responseTime) {
    this.responseTime = responseTime;
  }

  /**
   * Getter for responseTime field.
   *
   * @return Integer value of responseTime field.
   */
  @Override
  public int getResponseTime() {
    return responseTime;
  }

  /**
   * Gather all the Screen fields display them for the user.
   *
   * @return String value of all of Screens fields.
   */
  public String toString() {
    String info;

    info = "Resolution: " + resolution + "\nRefresh rate: " + refreshRate + "\nResponse time: "
        + responseTime;

    return info;
  }
}
