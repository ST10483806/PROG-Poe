/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.PoePart1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Message {

    private String messageID;
    private int numMessagesSent;
    private String recipient;
    private String message;
    private String messageHash;

    // Static list to keep all sent messages during the program run
    private static ArrayList<Message> sentMessages = new ArrayList<>();
    private static int totalMessages = 0;

    public Message() {
    }

    public Message(String recipient, String message) {
        this.messageID = generateMessageID();
        this.recipient = recipient;
        this.message = message;
        this.numMessagesSent = ++totalMessages;
        this.messageHash = createMessageHash();
    }

    // Generates a random 10-digit Message ID
    private String generateMessageID() {
        Random rand = new Random();
        long id = 1000000000L + (long) (rand.nextDouble() * 9000000000L);
        return String.valueOf(id);
    }

    // Boolean: checkMessageID()
    public boolean checkMessageID() {
        return messageID != null && messageID.length() <= 10;
    }

    // String: checkRecipientCell()
    public String checkRecipientCell() {
        if (recipient == null || recipient.length() > 13 || !recipient.startsWith("+")) {
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
        return "Cell phone number successfully captured.";
    }

    // String: createMessageHash()
    public String createMessageHash() {
        if (messageID == null || message == null) {
            return "";
        }

        String firstTwo = messageID.length() >= 2 ? messageID.substring(0, 2) : messageID;
        String[] words = message.trim().split("\\s+");
        String firstWord = words.length > 0 ? words[0].replaceAll("[^a-zA-Z]", "") : "";
        String lastWord = words.length > 1 ? words[words.length - 1].replaceAll("[^a-zA-Z]", "") : firstWord;

        String hash = firstTwo + ":" + (numMessagesSent - 1) + ":" + firstWord + lastWord;
        return hash.toUpperCase();
    }

    // String: SentMessage() - lets user choose Send / Disregard / Store
    public String SentMessage() {
        // This method is normally called after the user chooses an option
        // We keep it simple for the flow
        return "Message successfully sent.";
    }

    // Returns all messages that were sent
    public String printMessages() {
        if (sentMessages.isEmpty()) {
            return "No messages sent yet.";
        }
        StringBuilder sb = new StringBuilder();
        for (Message msg : sentMessages) {
            sb.append("Message ID: ").append(msg.messageID).append("\n");
            sb.append("Message Hash: ").append(msg.messageHash).append("\n");
            sb.append("Recipient: ").append(msg.recipient).append("\n");
            sb.append("Message: ").append(msg.message).append("\n\n");
        }
        return sb.toString();
    }

    // Returns total number of messages sent
    public int returnTotalMessages() {
        return totalMessages;
    }

    // Stores the message in a JSON file
    public String storeMessage() {
        try (FileWriter file = new FileWriter("storedMessages.json", true)) {
            String json = "{\n" +
                    "  \"messageID\": \"" + messageID + "\",\n" +
                    "  \"messageHash\": \"" + messageHash + "\",\n" +
                    "  \"recipient\": \"" + recipient + "\",\n" +
                    "  \"message\": \"" + message.replace("\"", "\\\"") + "\"\n" +
                    "},\n";
            file.write(json);
            return "Message successfully stored.";
        } catch (IOException e) {
            return "Error storing message: " + e.getMessage();
        }
    }

    // Helper method used by the main program
    public void addToSentMessages() {
        sentMessages.add(this);
    }

    // Getters
    public String getMessageID() { return messageID; }
    public String getMessageHash() { return messageHash; }
    public String getRecipient() { return recipient; }
    public String getMessage() { return message; }
    public int getNumMessagesSent() { return numMessagesSent; }

    // For testing
    public void setMessageID(String messageID) { this.messageID = messageID; }
    public void setMessage(String message) { this.message = message; }
    public void setRecipient(String recipient) { this.recipient = recipient; }
    public void setNumMessagesSent(int num) { this.numMessagesSent = num; }
}
