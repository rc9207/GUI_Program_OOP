package application;

/**
 * Interface used to determine specifications of a MonitorType.
 *
 * @Author: Seth T. Graham
 */
public interface ScreenSpec {

  /**
   * Getter for Screen resolution.
   *
   * @return String value of resolution.
   */
  public String getResolution();

  /**
   * Getter for Screen refreshRate.
   *
   * @return Integer value of Screen refreshRate.
   */
  public int getRefreshRate();

  /**
   * Getter for Screen responseTime.
   *
   * @return Integer value for Screen responseTime.
   */
  public int getResponseTime();

}
