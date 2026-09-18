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

    // ========== USERNAME TESTS ==========
    
    @Test
    public void testCheckUserName_Correct() {
        // Test Data: "kyl_1" : should return true
        Login instance = new Login("kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976", 
                "Kyle",
                "Smith");
        assertTrue(instance.checkUserName());
    }

    @Test
    public void testCheckUserName_Incorrect() {
        // Test Data: "kyle!!!!!!!" : should return false
        Login instance = new Login("kyle!!!!!!!", 
                "Ch&&sec@ke99!", 
               
                "+27838968976", 
                "Kyle",
                "Smith");
        assertFalse(instance.checkUserName());
    }

    // ========== PASSWORD TESTS ==========
    
    @Test
    public void testCheckPasswordComplexity_Correct() {
        // Test Data: "Ch&&sec@ke99!" : should return true
        Login instance = new Login("kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976", 
                "Kyle", 
                "Smith");
        assertTrue(instance.checkPasswordComplexity());
    }

    @Test
    public void testCheckPasswordComplexity_Incorrect() {
        // Test Data: "password" → should return false
        Login instance = new Login("kyl_1", 
                "password", 
                "+27838968976", 
                "Kyle",
                "Smith");
        assertFalse(instance.checkPasswordComplexity());
    }

    // ========== CELL PHONE TESTS ==========
    
    @Test
    public void testCheckCellPhoneNumber_Correct() {
        // Test Data: "+27838968976" → should return true
        Login instance = new Login("kyl_1", 
                "Ch&&sec@ke99!", 
                "+27838968976", 
                "Kyle",
                "Smith");
        assertTrue(instance.checkCellPhoneNumber());
    }

    @Test
    public void testCheckCellPhoneNumber_Incorrect() {
        // Test Data: "08966553" → should return false
        Login instance = new Login("kyl_1", 
                "Ch&&sec@ke99!", 
                "08966553", 
                "Kyle", 
                "Smith");
        assertFalse(instance.checkCellPhoneNumber());
    }

    // ========== REGISTER USER TESTS ==========
    
    @Test
    public void testRegisterUser_Success() {
        Login instance = new Login("kyl_1", 
                "Ch&&sec@ke99!", 
                "+27838968976",
                "Kyle",
                "Smith");
        String result = instance.registerUser();
        assertTrue(result.contains("successfully") || result.contains("captured") || result.contains("added"));
    }

    @Test
    public void testRegisterUser_UsernameFail() {
        Login instance = new Login("kyle!!!!!!!", 
                "Ch&&sec@ke99!",
                "+27838968976", 
                "Kyle",
                "Smith");
        String result = instance.registerUser();
        assertTrue(result.contains("Username is not correctly formatted"));
    }

    @Test
    public void testRegisterUser_PasswordFail() {
        Login instance = new Login("kyl_1", 
                "password",
                "+27838968976", 
                "Kyle", 
                "Smith");
        String result = instance.registerUser();
        assertTrue(result.contains("Password is not correctly formatted"));
    }

    // ========== LOGIN USER TESTS ==========
    
    @Test
    public void testLoginUser_Success() {
        Login instance = new Login("kyl_1", 
                "Ch&&sec@ke99!", 
                "+27838968976",
                "Kyle", 
                "Smith");
        boolean result = instance.loginUser("kyl_1", "Ch&&sec@ke99!");
        assertTrue(result);
    }

    @Test
    public void testLoginUser_Failed() {
        Login instance = new Login("kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976", 
                "Kyle", 
                "Smith");
        boolean result = instance.loginUser("wrong", "wrong");
        assertFalse(result);
    }

    // ========== RETURN LOGIN STATUS TESTS ==========
    
    @Test
    public void testReturnLoginStatus_Success() {
        Login instance = new Login("kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976", 
                "Kyle", 
                "Smith");
        String result = instance.returnLoginStatus(true);
        assertTrue(result.contains("Welcome") && result.contains("Kyle") && result.contains("Smith"));
    }

    @Test
    public void testReturnLoginStatus_Failed() {
        Login instance = new Login("kyl_1", 
                "Ch&&sec@ke99!",
                "+27838968976", 
                "Kyle", 
                "Smith");
        String result = instance.returnLoginStatus(false);
        assertEquals("Username or password incorrect, please try again.", result);
    }

    // ========== GETTER TESTS (optional but good) ==========
    
    @Test
    public void testGetUsername() {
        Login instance = new Login("kyl_1", 
                "Ch&&sec@ke99!",
                "+27838968976", 
                "Kyle", 
                "Smith");
        assertEquals("kyl_1", instance.getUsername());
    }

    @Test
    public void testGetPassword() {
        Login instance = new Login("kyl_1", 
                "Ch&&sec@ke99!",
                "+27838968976", 
                "Kyle", 
                "Smith");
        assertEquals("Ch&&sec@ke99!", instance.getPassword());
    }

    @Test
    public void testGetCellPhoneNumber() {
        Login instance = new Login("kyl_1", 
                "Ch&&sec@ke99!",
                "+27838968976", 
                "Kyle",
                "Smith");
        assertEquals("+27838968976", instance.getCellPhoneNumber());
    }

    @Test
    public void testGetFirstName() {
        Login instance = new Login("kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976", 
                "Kyle",
                "Smith");
        assertEquals("Kyle", instance.getFirstName());
    }

    @Test
    public void testGetLastName() {
        Login instance = new Login("kyl_1", 
                "Ch&&sec@ke99!",
                "+27838968976",
                "Kyle",
                "Smith");
        assertEquals("Smith", instance.getLastName());
    }
}