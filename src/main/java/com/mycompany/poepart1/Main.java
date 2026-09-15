/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poepart1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== REGISTRATION ===");
        System.out.print("Enter first name: ");
        String firstName = sc.nextLine();

        System.out.print("Enter last name: ");
        String lastName = sc.nextLine();

        System.out.print("Enter username: ");
        String username = sc.nextLine();

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        System.out.print("Enter South African cell phone number (e.g. +27838968976): ");
        String cell = sc.nextLine();

        // Create Login object
        Login user = new Login(username, password, cell, firstName, lastName);

        // Register
        String regMessage = user.registerUser();
        System.out.println("\n" + regMessage);

        // Only allow login if registration was successful
        if (regMessage.contains("User registered successfully")) {
            System.out.println("\n=== LOGIN ===");
            System.out.print("Enter username: ");
            String loginUser = sc.nextLine();

            System.out.print("Enter password: ");
            String loginPass = sc.nextLine();

            boolean success = user.loginUser(loginUser, loginPass);
            System.out.println(user.returnLoginStatus(success));
        }

        sc.close();
    }
}


// import org.junit.Test;
//import static org.junit.Assert.*;

//public class LoginTest {

    // ---------- assertEquals style tests ----------

  //  @Test
    //public void testUsernameCorrectlyFormatted() {
       // Login login = new Login("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        // The system should accept it (used in registration flow)
       // assertTrue(login.checkUserName());
    //}

   // @Test
  //  public void testUsernameIncorrectlyFormatted() {
       // Login login = new Login("kyle!", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
       // assertFalse(login.checkUserName());
        // Message check
      //  String msg = login.registerUser();
      //  assertTrue(msg.contains("Username is not correctly formatted"));
 //   }

   // @Test
   // public void testPasswordMeetsComplexity() {
      //  Login login = new Login("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
      //  assertTrue(login.checkPasswordComplexity());
   // }

  //  @Test
   // public void testPasswordDoesNotMeetComplexity() {
    //    Login login = new Login("kyl_1", "password", "+27838968976", "Kyle", "Smith");
     //   assertFalse(login.checkPasswordComplexity());
   // }

  //  @Test
  //  public void testCellPhoneCorrectlyFormatted() {
       // Login login = new Login("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
       // assertTrue(login.checkCellPhoneNumber());
  //  }

   // @Test
   // public void testCellPhoneIncorrectlyFormatted() {
     //   Login login = new Login("kyl_1", "Ch&&sec@ke99!", "08966553", "Kyle", "Smith");
      //  assertFalse(login.checkCellPhoneNumber());
   // }

    // ---------- assertTrue / assertFalse tests ----------

   // @Test
  //  public void testLoginSuccessful() {
      //  Login login = new Login("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
       // assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
   // }

   // @Test
   // public void testLoginFailed() {
       // Login login = new Login("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
       // assertFalse(login.loginUser("wrong", "wrong"));
   // }

    // @Test
   // public void testUsernameCorrectFormatReturnsTrue() {
      //  Login login = new Login("kyl_1", "pass", "cell", "A", "B");
    //    assertTrue(login.checkUserName());
  //  }

    // @Test
  //  public void testUsernameIncorrectFormatReturnsFalse() {
       // Login login = new Login("kyle!", "pass", "cell", "A", "B");
      //  assertFalse(login.checkUserName());
  //  }

 //   @Test
 //   public void testPasswordComplexityTrue() {
      //  Login login = new Login("u", "Ch&&sec@ke99!", "c", "A", "B");
     //   assertTrue(login.checkPasswordComplexity());
  //  }

  //  @Test
  //  public void testPasswordComplexityFalse() {
     //   Login login = new Login("u", "password", "c", "A", "B");
     //   assertFalse(login.checkPasswordComplexity());
  //  }

   // @Test
   // public void testCellPhoneTrue() {
       // Login login = new Login("u", "p", "+27838968976", "A", "B");
      //  assertTrue(login.checkCellPhoneNumber());
   // }

   // @Test
   // public void testCellPhoneFalse() {
      //  Login login = new Login("u", "p", "08966553", "A", "B");
      //  assertFalse(login.checkCellPhoneNumber());
 //   }
// }