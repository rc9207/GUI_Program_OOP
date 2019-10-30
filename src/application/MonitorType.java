package application;

/**
 * Enum used to abbreviate monitorType field.
 *
 * @Author: Seth T. Graham
 */
public enum MonitorType {

  Liquid_Crystal_Display("LED"), Light_Emitting_Diode("LED");

  private String monitorType;

  /**
   * Constructor for MonitorType Enum.
   *
   * @param monitorType String value of MonitorType Enum.
   */
  MonitorType(String monitorType) {
    this.monitorType = monitorType;
  }

  /**
   * Getter for MonitorType Enum.
   *
   * @return String value of MonitorType Enum.
   */
  public String getMonitorType() {
    return monitorType;
  }
}
