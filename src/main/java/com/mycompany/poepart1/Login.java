package com.mycompany.poepart1;

import java.util.regex.Pattern;

/**
 * Login class for registration and authentication
 * @author Student
 */
public class Login {

    private String username;
    private String password;
    private String cellPhoneNumber;
    private String firstName;
    private String lastName;

    // Constructor
    public Login(String username, String password, String cellPhoneNumber,
                 String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Empty constructor (needed by some tests)
    public Login() {
    }

    // ========== REQUIRED METHODS ==========

    /**
     * Checks if username contains an underscore and is no more than 5 characters long
     */
    public boolean checkUserName() {
        return username != null && username.contains("_") && username.length() <= 5;
    }

    /**
     * Checks password complexity:
     *  At least 8 characters
     *  Contains a capital letter
     *  Contains a number
     *  Contains a special character
     */
    public boolean checkPasswordComplexity() {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasCapital = true;
            } else if (Character.isDigit(c)) {
                hasNumber = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecial = true;
            }
        }
        return hasCapital && hasNumber && hasSpecial;
    }

    /**
     * Checks if the cell phone number is correctly formatted.
     * Must start with international code +27 followed by exactly 9 digits.
     * 
     * Regular expression researched from common South African mobile number validation patterns.
     */
    public boolean checkCellPhoneNumber() {
        if (cellPhoneNumber == null) {
            return false;
        }
        // +27 followed by exactly 9 digits
        String regex = "^\\+27\\d{9}$";
        return Pattern.matches(regex, cellPhoneNumber);
    }

    /**
     * Registers the user and returns the appropriate message
     */
    public String registerUser() {
        if (!checkUserName()) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        if (!checkPasswordComplexity()) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        if (!checkCellPhoneNumber()) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }
        // All conditions met
        return "Username successfully captured.\nPassword successfully captured.\nCell phone number successfully added.\nUser registered successfully.";
    }

    /**
     * Checks if the entered login details match the registered details
     */
    public boolean loginUser(String enteredUsername, String enteredPassword) {
        return username != null && password != null &&
               username.equals(enteredUsername) &&
               password.equals(enteredPassword);
    }

    /**
     * Returns the login status message
     */
    public String returnLoginStatus(boolean loginSuccess) {
        if (loginSuccess) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }

    // ========== GETTERS ==========

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getCellPhoneNumber() {
        return cellPhoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    // ========== SETTERS ==========

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCellPhoneNumber(String cellPhoneNumber) {
        this.cellPhoneNumber = cellPhoneNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}