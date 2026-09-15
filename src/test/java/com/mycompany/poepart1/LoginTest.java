/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.poepart1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */
public class LoginTest {
    
    public LoginTest() {
    }

    @Test
    public void testCheckUserName() {
        System.out.println("checkUserName");
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.checkUserName();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCheckPasswordComplexity() {
        System.out.println("checkPasswordComplexity");
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.checkPasswordComplexity();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCheckCellPhoneNumber() {
        System.out.println("checkCellPhoneNumber");
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.checkCellPhoneNumber();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRegisterUser() {
        System.out.println("registerUser");
        Login instance = new Login();
        String expResult = "";
        String result = instance.registerUser();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testLoginUser() {
        System.out.println("");
        String enteredUsername = "";
        String enteredPassword = "";
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.loginUser(enteredUsername, enteredPassword);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testReturnLoginStatus() {
        System.out.println("returnLoginStatus");
        boolean loginSuccess = false;
        Login instance = new Login();
        String expResult = "";
        String result = instance.returnLoginStatus(loginSuccess);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        Login instance = new Login();
        String expResult = "";
        String result = instance.getUsername();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetPassword() {
        System.out.println("");
        Login instance = new Login();
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetCellPhoneNumber() {
        System.out.println("getCellPhoneNumber");
        Login instance = new Login();
        String expResult = "";
        String result = instance.getCellPhoneNumber();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        Login instance = new Login();
        String expResult = "";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        Login instance = new Login();
        String expResult = "";
        String result = instance.getLastName();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "";
        Login instance = new Login();
        instance.setUsername(username);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "Ch&&sec@ke";
        Login instance = new Login();
        instance.setPassword(password);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetCellPhoneNumber() {
        System.out.println("setCellPhoneNumber");
        String cellPhoneNumber = "";
        Login instance = new Login();
        instance.setCellPhoneNumber(cellPhoneNumber);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        String firstName = "";
        Login instance = new Login();
        instance.setFirstName(firstName);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetLastName() {
        System.out.println("setLastName");
        String lastName = "";
        Login instance = new Login();
        instance.setLastName(lastName);
        fail("The test case is a prototype.");
    }
    
}
