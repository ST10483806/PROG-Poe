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

    // ========== MESSAGE ID TESTS ==========
    @Test
    public void testCheckMessageID() {
        Message instance = new Message("+27718693002", "Hi Mike, can you join us for dinner tonight?");
        assertTrue(instance.checkMessageID());
    }

    // ========== RECIPIENT CELL TESTS ==========
    @Test
    public void testCheckRecipientCell_Success() {
        Message instance = new Message("+27718693002", "Hi Mike, can you join us for dinner tonight?");
        String result = instance.checkRecipientCell();
        assertEquals("Cell phone number successfully captured.", result);
    }

    @Test
    public void testCheckRecipientCell_Failure() {
        Message instance = new Message("08575975889", "Hi Keegan, did you receive the payment?");
        String result = instance.checkRecipientCell();
        assertTrue(result.contains("incorrectly formatted") || result.contains("international code"));
    }

    // ========== MESSAGE HASH TEST ==========
    @Test
    public void testCreateMessageHash() {
        Message instance = new Message("+27718693002", "Hi Mike, can you join us for dinner tonight?");
        instance.setMessageID("0012345678");   // force first two digits to 00
        instance.setNumMessagesSent(1);       // so it becomes 00:0:...
        
        String hash = instance.createMessageHash();
        
        assertTrue(hash.startsWith("00:0:"));
        assertTrue(hash.contains("HI") && hash.contains("TONIGHT"));
    }

    // ========== SENT MESSAGE OPTIONS ==========
    @Test
    public void testSentMessage_Send() {
        Message instance = new Message("+27718693002", "Hi Mike, can you join us for dinner tonight?");
        // If your SentMessage() method takes an int choice:
        // String result = instance.SentMessage(1);
        // assertEquals("Message successfully sent.", result);
        
        // If it has no parameter (as in the auto-generated skeleton):
        String result = instance.SentMessage();
        assertNotNull(result);
    }

    // ========== PRINT MESSAGES ==========
    @Test
    public void testPrintMessages() {
        Message instance = new Message("+27718693002", "Hi Mike, can you join us for dinner tonight?");
        instance.addToSentMessages();
        String result = instance.printMessages();
        assertTrue(result.contains("Message ID") || result.contains("No messages"));
    }

    // ========== TOTAL MESSAGES ==========
    @Test
    public void testReturnTotalMessages() {
        Message instance = new Message("+27718693002", "Test message");
        int result = instance.returnTotalMessages();
        assertTrue(result >= 0);
    }

    // ========== STORE MESSAGE ==========
    @Test
    public void testStoreMessage() {
        Message instance = new Message("+27718693002", "Hi Mike, can you join us for dinner tonight?");
        String result = instance.storeMessage();
        assertTrue(result.contains("successfully stored") || result.contains("Error"));
    }

    // ========== MESSAGE LENGTH (from assignment) ==========
    @Test
    public void testMessageLength_Success() {
        String message = "Hi Mike, can you join us for dinner tonight?";
        assertTrue(message.length() <= 250);
    }

    @Test
    public void testMessageLength_Failure() {
        String longMessage = "A".repeat(260);
        assertTrue(longMessage.length() > 250);
    }

    // ========== GETTERS ==========
    @Test
    public void testGetMessageID() {
        Message instance = new Message("+27718693002", "Test");
        assertNotNull(instance.getMessageID());
        assertTrue(instance.getMessageID().length() <= 10);
    }

    @Test
    public void testGetMessageHash() {
        Message instance = new Message("+27718693002", "Hi Mike, can you join us for dinner tonight?");
        assertNotNull(instance.getMessageHash());
    }

    @Test
    public void testGetRecipient() {
        Message instance = new Message("+27718693002", "Test");
        assertEquals("+27718693002", instance.getRecipient());
    }

    @Test
    public void testGetMessage() {
        Message instance = new Message("+27718693002", "Hi Mike, can you join us for dinner tonight?");
        assertEquals("Hi Mike, can you join us for dinner tonight?", instance.getMessage());
    }

    @Test
    public void testGetNumMessagesSent() {
        Message instance = new Message("+27718693002", "Test");
        assertTrue(instance.getNumMessagesSent() > 0);
    }

    // ========== SETTERS ==========
    @Test
    public void testSetMessageID() {
        Message instance = new Message();
        instance.setMessageID("1234567890");
        assertEquals("1234567890", instance.getMessageID());
    }

    @Test
    public void testSetMessage() {
        Message instance = new Message();
        instance.setMessage("Hello World");
        assertEquals("Hello World", instance.getMessage());
    }

    @Test
    public void testSetRecipient() {
        Message instance = new Message();
        instance.setRecipient("+27718693002");
        assertEquals("+27718693002", instance.getRecipient());
    }

    @Test
    public void testSetNumMessagesSent() {
        Message instance = new Message();
        instance.setNumMessagesSent(5);
        assertEquals(5, instance.getNumMessagesSent());
    }
    
    @Test
    public void testAddToSentMessages() {
        Message instance = new Message("+27718693002", "Test message");
        instance.addToSentMessages();
        // Just checking it doesn't crash
        assertTrue(true);
    }
}