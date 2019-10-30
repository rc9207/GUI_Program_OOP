package application;

/**
 * Interface used to set actions for AudioPlayers and MoviePlayers.
 *
 * @Author: Seth T. Graham
 */
public interface MultiMediaControl {

  /**
   * Method to play AudioPlayer.
   */
  public void play();

  /**
   * Method to stop AudioPlayer.
   */
  public void stop();

  /**
   * Method to go to previous track.
   */
  public void previous();

  /**
   * Method to go to next track.
   */
  public void next();

}
