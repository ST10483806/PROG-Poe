/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.poepart1;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

public class Message {

    private String messageID;
    private int numMessagesSent;
    private String recipient;
    private String message;
    private String messageHash;
    private String flag;          // "Sent", "Stored", "Disregard"

    // ========== ARRAYS REQUIRED BY PART 3 ==========
    public static ArrayList<Message> sentMessages = new ArrayList<>();
    public static ArrayList<Message> disregardedMessages = new ArrayList<>();
    public static ArrayList<Message> storedMessages = new ArrayList<>();
    public static ArrayList<String> messageHashes = new ArrayList<>();
    public static ArrayList<String> messageIDs = new ArrayList<>();

    private static int totalMessages = 0;

    public Message() {
    }

    public Message(String recipient, String message, String flag) {
        this.messageID = generateMessageID();
        this.recipient = recipient;
        this.message = message;
        this.flag = flag;
        this.numMessagesSent = ++totalMessages;
        this.messageHash = createMessageHash();

        // Populate the arrays according to the flag
        messageIDs.add(this.messageID);
        messageHashes.add(this.messageHash);

        if ("Sent".equalsIgnoreCase(flag)) {
            sentMessages.add(this);
        } else if ("Stored".equalsIgnoreCase(flag)) {
            storedMessages.add(this);
            storeMessage();          // also write to JSON
        } else if ("Disregard".equalsIgnoreCase(flag)) {
            disregardedMessages.add(this);
        }
    }

    private String generateMessageID() {
        Random rand = new Random();
        long id = 1000000000L + (long) (rand.nextDouble() * 9000000000L);
        return String.valueOf(id);
    }

    public boolean checkMessageID() {
        return messageID != null && messageID.length() <= 10;
    }

    public String checkRecipientCell() {
        if (recipient == null || !recipient.startsWith("+") || recipient.length() > 13) {
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
        return "Cell phone number successfully captured.";
    }

    public String createMessageHash() {
        if (messageID == null || message == null || message.trim().isEmpty()) {
            return "";
        }
        String firstTwo = messageID.length() >= 2 ? messageID.substring(0, 2) : messageID;
        String[] words = message.trim().split("\\s+");
        String firstWord = words[0].replaceAll("[^a-zA-Z]", "");
        String lastWord = words.length > 1 ? words[words.length - 1].replaceAll("[^a-zA-Z]", "") : firstWord;
        return (firstTwo + ":" + (numMessagesSent - 1) + ":" + firstWord + lastWord).toUpperCase();
    }

    public String SentMessage(int choice) {
        switch (choice) {
            case 1:
                return "Message successfully sent.";
            case 2:
                return "Press 0 to delete the message.";
            case 3:
                return storeMessage();
            default:
                return "Invalid option.";
        }
    }

    public String storeMessage() {
        try (FileWriter file = new FileWriter("storedMessages.json", true)) {
            String json = "{\n"
                    + "  \"messageID\": \"" + messageID + "\",\n"
                    + "  \"messageHash\": \"" + messageHash + "\",\n"
                    + "  \"recipient\": \"" + recipient + "\",\n"
                    + "  \"message\": \"" + message.replace("\"", "\\\"") + "\",\n"
                    + "  \"flag\": \"" + flag + "\"\n"
                    + "},\n";
            file.write(json);
            return "Message successfully stored.";
        } catch (IOException e) {
            return "Error storing message: " + e.getMessage();
        }
    }

    // ========== PART 3 METHODS ==========

    public static String displaySendersAndRecipients() {
        if (storedMessages.isEmpty()) {
            return "No stored messages.";
        }
        StringBuilder sb = new StringBuilder();
        for (Message m : storedMessages) {
            sb.append("Recipient: ").append(m.recipient)
              .append(" | Message: ").append(m.message).append("\n");
        }
        return sb.toString();
    }

    public static String displayLongestMessage() {
        if (storedMessages.isEmpty() && sentMessages.isEmpty()) {
            return "No messages available.";
        }
        Message longest = null;
        for (Message m : storedMessages) {
            if (longest == null || m.message.length() > longest.message.length()) {
                longest = m;
            }
        }
        for (Message m : sentMessages) {
            if (longest == null || m.message.length() > longest.message.length()) {
                longest = m;
            }
        }
        return longest != null ? longest.message : "No messages found.";
    }

    public static String searchByMessageID(String id) {
        for (Message m : storedMessages) {
            if (m.messageID.equals(id)) {
                return "Recipient: " + m.recipient + "\nMessage: " + m.message;
            }
        }
        for (Message m : sentMessages) {
            if (m.messageID.equals(id)) {
                return "Recipient: " + m.recipient + "\nMessage: " + m.message;
            }
        }
        return "Message ID not found.";
    }

    public static String searchByRecipient(String recipient) {
        StringBuilder sb = new StringBuilder();
        for (Message m : storedMessages) {
            if (m.recipient.equals(recipient)) {
                sb.append(m.message).append("\n");
            }
        }
        for (Message m : sentMessages) {
            if (m.recipient.equals(recipient)) {
                sb.append(m.message).append("\n");
            }
        }
        return sb.length() > 0 ? sb.toString() : "No messages found for this recipient.";
    }

    public static String deleteByHash(String hash) {
        for (int i = 0; i < storedMessages.size(); i++) {
            if (storedMessages.get(i).messageHash.equalsIgnoreCase(hash)) {
                Message removed = storedMessages.remove(i);
                return "Message: \"" + removed.message + "\" successfully deleted.";
            }
        }
        return "Message hash not found.";
    }

    public static String displayFullReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("===== FULL MESSAGE REPORT =====\n\n");

        sb.append("--- SENT MESSAGES ---\n");
        for (Message m : sentMessages) {
            sb.append("Hash: ").append(m.messageHash)
              .append(" | Recipient: ").append(m.recipient)
              .append(" | Message: ").append(m.message).append("\n");
        }

        sb.append("\n--- STORED MESSAGES ---\n");
        for (Message m : storedMessages) {
            sb.append("Hash: ").append(m.messageHash)
              .append(" | Recipient: ").append(m.recipient)
              .append(" | Message: ").append(m.message).append("\n");
        }

        sb.append("\n--- DISREGARDED MESSAGES ---\n");
        for (Message m : disregardedMessages) {
            sb.append("Hash: ").append(m.messageHash)
              .append(" | Recipient: ").append(m.recipient)
              .append(" | Message: ").append(m.message).append("\n");
        }

        return sb.toString();
    }

    // Getters
    public String getMessageID() { return messageID; }
    public String getMessageHash() { return messageHash; }
    public String getRecipient() { return recipient; }
    public String getMessage() { return message; }
    public String getFlag() { return flag; }
    public int getNumMessagesSent() { return numMessagesSent; }

    // Setters (for testing)
    public void setMessageID(String messageID) { this.messageID = messageID; }
    public void setMessage(String message) { this.message = message; }
    public void setRecipient(String recipient) { this.recipient = recipient; }
    public void setNumMessagesSent(int num) { this.numMessagesSent = num; }
    public void setFlag(String flag) { this.flag = flag; }
}