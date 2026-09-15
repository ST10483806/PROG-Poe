/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poepart1;

import java.util.regex.Pattern;

public class Login {
    private String username;
    private String password;
    private String cellPhoneNumber;
    private String firstName;
    private String lastName;

    // Constructor (used when registering)
    public Login(String username, String password, String cellPhoneNumber,
                 String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Empty constructor for flexibility
    public Login() {
    }

    // ========== REQUIRED METHODS ==========

    // 1. checkUserName()
    public boolean checkUserName() {
        // Username must contain underscore (_) AND be no more than 5 characters long
        return username != null && username.contains("_") && username.length() <= 5;
    }

    // 2. checkPasswordComplexity()
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

    // 3. checkCellPhoneNumber()
    // Regular expression researched from common South African number validation patterns
    // (international +27 followed by exactly 9 digits). 
    // Reference style: standard E.164 / SA mobile format commonly used in programming examples.
    public boolean checkCellPhoneNumber() {
        if (cellPhoneNumber == null) {
            return false;
        }
        // +27 followed by exactly 9 digits (total length 12 characters)
        String regex = "^\\+27\\d{9}$";
        return Pattern.matches(regex, cellPhoneNumber);
    }

    // 4. registerUser() – returns the correct messages
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
        // All checks passed – user is registered
        return "Username successfully captured.\nPassword successfully captured.\nCell phone number successfully added.\nUser registered successfully.";
    }

    // 5. loginUser()
    public boolean loginUser(String enteredUsername, String enteredPassword) {
        return username != null && password != null &&
               username.equals(enteredUsername) &&
               password.equals(enteredPassword);
    }

    // 6. returnLoginStatus
    public String returnLoginStatus(boolean loginSuccess) {
        if (loginSuccess) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }

    // Getters (useful for tests / main)
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getCellPhoneNumber() { return cellPhoneNumber; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }

    // Setters (optional)
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
    public void setCellPhoneNumber(String cellPhoneNumber) { this.cellPhoneNumber = cellPhoneNumber; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
}
