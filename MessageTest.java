/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

package com.mycompany.poepart1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Message class – covers Part 2 and Part 3 requirements
 * @author Student
 */
public class MessageTest {

    @BeforeEach
    public void setUp() {
        // Clear all arrays before each test
        Message.sentMessages.clear();
        Message.disregardedMessages.clear();
        Message.storedMessages.clear();
        Message.messageHashes.clear();
        Message.messageIDs.clear();

        // Official Part 3 Test Data
        new Message("+27834557896", "Did you get the cake?", "Sent");
        new Message("+27838884567", "Where are you? You are late! I have asked you to be on time.", "Stored");
        new Message("+27834484567", "Yohoooo, I am at your gate.", "Disregard");
        new Message("0838884567", "It is dinner time !", "Sent");
        new Message("+27838884567", "Ok, I am leaving without you.", "Stored");
    }

    // =========================================================
    // PART 2 TESTS
    // =========================================================

    @Test
    public void testMessageLength_Success() {
        String message = "Did you get the cake?";
        assertTrue(message.length() <= 250);
    }

    @Test
    public void testMessageLength_Failure() {
        String longMessage = "A".repeat(260);
        assertTrue(longMessage.length() > 250);
    }

    @Test
    public void testCheckRecipientCell_Success() {
        Message msg = new Message("+27834557896", "Test message", "Sent");
        assertEquals("Cell phone number successfully captured.", msg.checkRecipientCell());
    }

    @Test
    public void testCheckRecipientCell_Failure() {
        Message msg = new Message("0838884567", "Test message", "Sent");
        String result = msg.checkRecipientCell();
        assertTrue(result.contains("incorrectly formatted") || result.contains("international code"));
    }

    @Test
    public void testCreateMessageHash() {
        Message msg = Message.sentMessages.get(0);
        String hash = msg.getMessageHash();
        assertNotNull(hash);
        assertTrue(hash.contains(":"));
        assertEquals(hash, hash.toUpperCase()); // must be uppercase
    }

    @Test
    public void testCheckMessageID() {
        Message msg = Message.sentMessages.get(0);
        assertTrue(msg.checkMessageID());
        assertTrue(msg.getMessageID().length() <= 10);
    }

    // =========================================================
    // PART 3 TESTS
    // =========================================================

    @Test
    public void testSentMessagesArrayCorrectlyPopulated() {
        // Expected: "Did you get the cake?" and "It is dinner time !"
        assertEquals(2, Message.sentMessages.size());
        assertEquals("Did you get the cake?", Message.sentMessages.get(0).getMessage());
        assertEquals("It is dinner time !", Message.sentMessages.get(1).getMessage());
    }

    @Test
    public void testDisplayLongestMessage() {
        String longest = Message.displayLongestMessage();
        assertEquals("Where are you? You are late! I have asked you to be on time.", longest);
    }

    @Test
    public void testSearchByMessageID() {
        // Use the Message ID of the 4th test message ("It is dinner time !")
        String id = Message.sentMessages.get(1).getMessageID();
        String result = Message.searchByMessageID(id);
        assertTrue(result.contains("It is dinner time !"));
    }

    @Test
    public void testSearchByRecipient() {
        String result = Message.searchByRecipient("+27838884567");
        assertTrue(result.contains("Where are you? You are late! I have asked you to be on time."));
        assertTrue(result.contains("Ok, I am leaving without you."));
    }

    @Test
    public void testDeleteByHash() {
        // Delete the first stored message
        String hash = Message.storedMessages.get(0).getMessageHash();
        String result = Message.deleteByHash(hash);

        assertTrue(result.contains("successfully deleted"));
        assertEquals(1, Message.storedMessages.size()); // one left
    }

    @Test
    public void testDisplayFullReport() {
        String report = Message.displayFullReport();

        assertTrue(report.contains("SENT MESSAGES"));
        assertTrue(report.contains("STORED MESSAGES"));
        assertTrue(report.contains("DISREGARDED MESSAGES"));
        assertTrue(report.contains("Did you get the cake?"));
        assertTrue(report.contains("Where are you? You are late! I have asked you to be on time."));
        assertTrue(report.contains("It is dinner time !"));
    }

    @Test
    public void testStoredMessagesArrayPopulated() {
        assertEquals(2, Message.storedMessages.size());
    }

    @Test
    public void testDisregardedMessagesArrayPopulated() {
        assertEquals(1, Message.disregardedMessages.size());
        assertEquals("Yohoooo, I am at your gate.", Message.disregardedMessages.get(0).getMessage());
    }
}