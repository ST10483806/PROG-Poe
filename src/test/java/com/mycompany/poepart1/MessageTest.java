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
public class MessageTest {
    
    public MessageTest() {
    }

    @Test
    public void testCheckMessageID() {
        System.out.println("checkMessageID");
        Message instance = new Message();
        boolean expResult = false;
        boolean result = instance.checkMessageID();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCheckRecipientCell() {
        System.out.println("checkRecipientCell");
        Message instance = new Message();
        String expResult = "";
        String result = instance.checkRecipientCell();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCreateMessageHash() {
        System.out.println("createMessageHash");
        Message instance = new Message();
        String expResult = "";
        String result = instance.createMessageHash();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSentMessage() {
        System.out.println("SentMessage");
        Message instance = new Message();
        String expResult = "";
        String result = instance.SentMessage();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testPrintMessages() {
        System.out.println("printMessages");
        Message instance = new Message();
        String expResult = "";
        String result = instance.printMessages();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testReturnTotalMessages() {
        System.out.println("returnTotalMessages");
        Message instance = new Message();
        int expResult = 0;
        int result = instance.returnTotalMessages();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testStoreMessage() {
        System.out.println("storeMessage");
        Message instance = new Message();
        String expResult = "";
        String result = instance.storeMessage();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAddToSentMessages() {
        System.out.println("addToSentMessages");
        Message instance = new Message();
        instance.addToSentMessages();
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetMessageID() {
        System.out.println("getMessageID");
        Message instance = new Message();
        String expResult = "";
        String result = instance.getMessageID();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetMessageHash() {
        System.out.println("getMessageHash");
        Message instance = new Message();
        String expResult = "";
        String result = instance.getMessageHash();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetRecipient() {
        System.out.println("getRecipient");
        Message instance = new Message();
        String expResult = "";
        String result = instance.getRecipient();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetMessage() {
        System.out.println("getMessage");
        Message instance = new Message();
        String expResult = "";
        String result = instance.getMessage();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetNumMessagesSent() {
        System.out.println("getNumMessagesSent");
        Message instance = new Message();
        int expResult = 0;
        int result = instance.getNumMessagesSent();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetMessageID() {
        System.out.println("setMessageID");
        String messageID = "";
        Message instance = new Message();
        instance.setMessageID(messageID);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetMessage() {
        System.out.println("setMessage");
        String message = "";
        Message instance = new Message();
        instance.setMessage(message);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetRecipient() {
        System.out.println("setRecipient");
        String recipient = "";
        Message instance = new Message();
        instance.setRecipient(recipient);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetNumMessagesSent() {
        System.out.println("setNumMessagesSent");
        int num = 0;
        Message instance = new Message();
        instance.setNumMessagesSent(num);
        fail("The test case is a prototype.");
    }
    
}
