package application;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Employee descriptor class.
 *
 * @Author: Seth T. Graham
 */
public class Employee {

  private String name;
  private String userName;
  private String password;
  private String email;
  private Pattern pattern;
  private Matcher matcher;


  /**
   * Constructor to create new employee by utilizing name input.
   *
   * @param inputName Desired employee name.
   * @param password  Desired employee password.
   */
  public Employee(String inputName, String password) {

    setName(inputName);
    checkName(inputName);

    System.out.println(isValidPassword(password));

    if (isValidPassword(password)) {
      this.password = password;
    } else {
      this.password = "pw";
    }
  }

  /**
   * Setter for name field.
   *
   * @param name Desired String value of name field.
   */
  private void setName(String name) {
    this.name = name;
  }

  /**
   * Getter for returning name field.
   *
   * @return name field.
   */
  private String getName() {
    return name;
  }

  /**
   * Setter for userName field.
   *
   * @param userName Desired String value of userName field.
   */
  private void setUserName(String userName) {
    this.userName = userName;
  }

  /**
   * Getter for userName field.
   *
   * @return userName field.
   */
  public String getUserName() {
    return userName;
  }

  /**
   * Used to determine if inputName contains at least one whitespace character.
   *
   * @param inputName Desired String value to check.
   */
  private void checkName(String inputName) {

    if (Pattern.matches("[\\S]+[\\s]+[\\S]+", inputName)) {

      String firstLetter = inputName.substring(0, 1);
      String lastName = inputName.substring(inputName.lastIndexOf(" ") + 1);
      String newUserName = firstLetter.toLowerCase() + lastName.toLowerCase();

      setUserName(newUserName);

      String firstName = inputName.substring(0, inputName.indexOf(" "));
      String newEmail =
          firstName.toLowerCase() + "." + lastName.toLowerCase() + "@oracleacademy.Test";
      setEmail(newEmail);

    } else {
      setUserName("default");
      setEmail("user@oracleacademy.Test");
    }
  }

  /**
   * Setter for email field.
   *
   * @param email Desired String value for email field.
   */
  private void setEmail(String email) {
    this.email = email;
  }

  /**
   * Getter for email field.
   *
   * @return String value of email field.
   */
  private String getEmail() {
    return email;
  }

  /**
   * Setter for password field.
   *
   * @param password Desired String value for password field.
   */
  private void setPassword(String password) {
    this.password = password;
  }

  /**
   * Getter for password field.
   *
   * @return String value of password field.
   */
  private String getPassword() {
    return password;
  }

  /**
   * Check to see if password contains desired characters.
   *
   * @param password String value of password.
   */
  public boolean isValidPassword(String password) {

    pattern = Pattern.compile("((?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%]))");
    matcher = pattern.matcher(password);

    return matcher.matches();
  }

  /**
   * Display all Employees fields in a String.
   *
   * @return String value of Employees fields.
   */
  @Override
  public String toString() {

    String info;

    info =
        "Employee Details\n" + "Name : " + name + "\nUsername : " + userName + "\nEmail : " + email
            + "\nInitial Password : " + password;

    return info;
  }

}
