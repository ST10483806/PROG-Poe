package com.mycompany.poepart1;

/**
 * Main class for Registration and Login
 * @author Student
 */
public class PoePart1 {

    public static void main(String[] args) {

        // Test data from the assignment
        String firstName = "Kyle";
        String lastName = "Smith";
        String username = "kyl_1";
        String password = "Ch&&sec@ke99!";
        String cellPhone = "+27838968976";

        System.out.println("===== USER REGISTRATION =====");
        System.out.println("First Name : " + firstName);
        System.out.println("Last Name  : " + lastName);
        System.out.println("Username   : " + username);
        System.out.println("Password   : " + password);
        System.out.println("Cell Phone : " + cellPhone);

        Login user = new Login(username, password, cellPhone, firstName, lastName);

        // Register
        String regMessage = user.registerUser();
        System.out.println("\n" + regMessage);

        // Login
        System.out.println("\n===== LOGIN =====");
        boolean success = user.loginUser(username, password);
        System.out.println(user.returnLoginStatus(success));

        // Test failed login
        System.out.println("\n===== FAILED LOGIN TEST =====");
        boolean failed = user.loginUser("wrong", "wrong");
        System.out.println(user.returnLoginStatus(failed));
    }
}