

package com.mycompany.poepart1;

/**
 * QuickChat - Part 2 (Sending Messages)
 * Automatically uses the assignment test data
 */
public class PoePart1 {

    public static void main(String[] args) {

        // ========== PART 1: LOGIN (using Part 1 test data) ==========
        System.out.println("===== QUICKCHAT LOGIN =====");
        
        Login user = new Login("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        
        // Simulate successful login
        boolean loggedIn = user.loginUser("kyl_1", "Ch&&sec@ke99!");
        System.out.println(user.returnLoginStatus(loggedIn));

        if (!loggedIn) {
            System.out.println("Login failed. Exiting...");
            return;
        }

        // ========== PART 2: QUICKCHAT ==========
        System.out.println("\nWelcome to QuickChat.");

        // ----- Test Message 1 -----
        System.out.println("\n===== SENDING MESSAGE 1 =====");
        String recipient1 = "+27718693002";
        String message1 = "Hi Mike, can you join us for dinner tonight?";

        Message msg1 = new Message(recipient1, message1);
        System.out.println(msg1.checkRecipientCell());
        System.out.println("Message Hash: " + msg1.getMessageHash());
        
        // User selected Send
        msg1.addToSentMessages();
        System.out.println("Message successfully sent.");
        
        System.out.println("\n--- Message Details ---");
        System.out.println("Message ID   : " + msg1.getMessageID());
        System.out.println("Message Hash : " + msg1.getMessageHash());
        System.out.println("Recipient    : " + msg1.getRecipient());
        System.out.println("Message      : " + msg1.getMessage());

        // ----- Test Message 2 -----
        System.out.println("\n===== SENDING MESSAGE 2 =====");
        String recipient2 = "08575975889";
        String message2 = "Hi Keegan, did you receive the payment?";

        Message msg2 = new Message(recipient2, message2);
        System.out.println(msg2.checkRecipientCell());
        
        // User selected Disregard
        System.out.println("Press 0 to delete the message.");

        // ----- Show total messages -----
        System.out.println("\n===== TOTAL MESSAGES SENT =====");
        System.out.println("Total messages sent: " + msg1.returnTotalMessages());

        // ----- Demonstrate the menu options -----
        System.out.println("\n===== MENU DEMONSTRATION =====");
        System.out.println("1) Send Messages");
        System.out.println("2) Show recently sent messages → Coming Soon.");
        System.out.println("3) Quit");
    }
}