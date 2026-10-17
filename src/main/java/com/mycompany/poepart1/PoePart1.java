package com.mycompany.poepart1;

import java.util.Scanner;

public class PoePart1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ========== PART 1: LOGIN ==========
        System.out.println("===== QUICKCHAT LOGIN =====");
        System.out.print("Enter Username: ");
        String username = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        // Using the test user from Part 1 (you can change this)
        Login user = new Login("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");

        boolean loggedIn = user.loginUser(username, password);
        System.out.println(user.returnLoginStatus(loggedIn));

        if (!loggedIn) {
            System.out.println("You must log in successfully to use QuickChat.");
            sc.close();
            return;
        }

        // ========== PART 2: QUICKCHAT MENU ==========
        System.out.println("\nWelcome to QuickChat.");

        boolean running = true;
        while (running) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1) Send Messages");
            System.out.println("2) Show recently sent messages");
            System.out.println("3) Quit");
            System.out.print("Enter your choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    sendMessages(sc);
                    break;
                case 2:
                    System.out.println("Coming Soon.");
                    break;
                case 3:
                    System.out.println("Thank you for using QuickChat. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        sc.close();
    }

    private static void sendMessages(Scanner sc) {
        System.out.print("\nHow many messages do you wish to send? ");
        int numMessages = sc.nextInt();
        sc.nextLine();

        if (numMessages <= 0) {
            System.out.println("Please enter a positive number of messages.");
            return;
        }

        Message msgHelper = new Message();

        for (int i = 1; i <= numMessages; i++) {
            System.out.println("\n----- Message " + i + " of " + numMessages + " -----");

            System.out.print("Enter recipient cell number (+27...): ");
            String recipient = sc.nextLine();

            System.out.print("Enter your message (max 250 characters): ");
            String messageText = sc.nextLine();

            if (messageText.length() > 250) {
                System.out.println("Please enter a message of less than 250 characters.");
                i--; // retry this message
                continue;
            }

            Message currentMsg = new Message(recipient, messageText);

            // Show recipient validation
            System.out.println(currentMsg.checkRecipientCell());

            // Ask what to do with the message
            System.out.println("\nWhat would you like to do with this message?");
            System.out.println("1) Send Message");
            System.out.println("2) Disregard Message");
            System.out.println("3) Store Message to send later");
            System.out.print("Enter choice: ");
            int action = sc.nextInt();
            sc.nextLine();

            switch (action) {
                case 1:
                    currentMsg.addToSentMessages();
                    System.out.println("Message successfully sent.");
                    // Display full details
                    System.out.println("\nMessage ID: " + currentMsg.getMessageID());
                    System.out.println("Message Hash: " + currentMsg.getMessageHash());
                    System.out.println("Recipient: " + currentMsg.getRecipient());
                    System.out.println("Message: " + currentMsg.getMessage());
                    break;
                case 2:
                    System.out.println("Press 0 to delete the message.");
                    break;
                case 3:
                    System.out.println(currentMsg.storeMessage());
                    break;
                default:
                    System.out.println("Invalid choice. Message disregarded.");
            }
        }

        System.out.println("\n===== TOTAL MESSAGES SENT =====");
        System.out.println("Total messages sent: " + msgHelper.returnTotalMessages());
    }
}