package application;

/**
 * Class designed to create new AudioPlayers.
 *
 * @Author: Seth T. Graham
 */
public class AudioPlayer extends Product implements MultiMediaControl {

  private String audioSpecification;
  private String mediaType;

  /**
   * Constructor with three arguments, Uses Product parent.
   *
   * @param name               Field located in Parent.java
   * @param manufacturer       Field located in Parent.java
   * @param audioSpecification Field located locally.
   */
  public AudioPlayer(String name, String manufacturer, String audioSpecification) {
    super(name, manufacturer);
    this.audioSpecification = audioSpecification;
  }

  /**
   * Constructor with four arguments, Uses Product parent.
   *
   * @param name               Field located in Parent.java.
   * @param manufacturer       Field located in Parent.java.
   * @param audioSpecification Field located locally.
   * @param mediaType          Field located locally.
   */
  public AudioPlayer(String name, String manufacturer, String audioSpecification,
      String mediaType) {

    super(name, manufacturer);
    this.audioSpecification = audioSpecification;
    this.mediaType = mediaType;
  }

  /**
   * Constructor with 5 arguments.
   *
   * @param name               Field located in Parent.java
   * @param manufacturer       Field located in Parent.java
   * @param itemType           Desired ItemType for AudioPlayer.
   * @param audioSpecification Field is located locally.
   * @param mediaType          Field is located locally.
   */
  public AudioPlayer(String name, String manufacturer, ItemType itemType, String audioSpecification,
      String mediaType) {

    super(name, manufacturer, itemType);
    this.audioSpecification = audioSpecification;
    this.mediaType = mediaType;
  }

  /**
   * Setter for audioSpecification field.
   *
   * @param audioSpecification String argument.
   */
  public void setAudioSpecification(String audioSpecification) {
    this.audioSpecification = audioSpecification;
  }

  /**
   * Getter for audioSpecification.
   *
   * @return String value of audioSpecification field.
   */
  public String getAudioSpecification() {
    return audioSpecification;
  }

  /**
   * Setter for mediaType field.
   *
   * @param mediaType String argument.
   */
  public void setMediaType(String mediaType) {
    this.mediaType = mediaType;
  }

  /**
   * Method to play music.
   */
  public void play() {
    System.out.println("Playing...");
  }

  /**
   * Method to stop music.
   */
  public void stop() {
    System.out.println("Stopping...");
  }

  /**
   * Method to go to previous track.
   */
  public void previous() {
    System.out.println("Previous...");
  }

  /**
   * Method to go to next track.
   */
  public void next() {
    System.out.println("Next...");
  }

  /**
   * Method to gather all fields and create a large description of the object.
   *
   * @return String representation of AudioPlayer object.
   */
  @Override
  public String toString() {
    String info = "Name: " + getName() + "\nManufacturer: " + getManufacturer() + "\nType: "
        + super.getType() + "\nSupported Audio Formats: " + audioSpecification
        + "\nSupported Playlist Formats: " + mediaType;

    return info;
  }
}
