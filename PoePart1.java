

package com.mycompany.poepart1;

import java.util.Scanner;

public class PoePart1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       // ========== PART 1: LOGIN ==========
System.out.println("===== QUICKCHAT LOGIN =====");

Login user = new Login("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");

System.out.print("Enter Username: ");
String username = sc.nextLine();

System.out.print("Enter Password: ");
String password = sc.nextLine();

boolean loggedIn = user.loginUser(username, password);
System.out.println(user.returnLoginStatus(loggedIn));

if (!loggedIn) {
    System.out.println("You must log in successfully to use QuickChat.");
    sc.close();
    return;
} 

        // ========== LOAD TEST DATA (Part 3) ==========
        loadTestData();

        // ========== MAIN MENU ==========
        System.out.println("\nWelcome to QuickChat.");
        boolean running = true;

        while (running) {
            System.out.println("\n========== MAIN MENU ==========");
            System.out.println("1) Send Messages");
            System.out.println("2) Show recently sent messages");
            System.out.println("3) Quit");
            System.out.println("4) Stored Messages");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

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
                case 4:
                    storedMessagesMenu(sc);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        sc.close();
    }

    private static void loadTestData() {
        // Clear previous data
        Message.sentMessages.clear();
        Message.disregardedMessages.clear();
        Message.storedMessages.clear();
        Message.messageHashes.clear();
        Message.messageIDs.clear();

        // Test Data from the assignment
        new Message("+27834557896", "Did you get the cake?", "Sent");
        new Message("+27838884567", "Where are you? You are late! I have asked you to be on time.", "Stored");
        new Message("+27834484567", "Yohoooo, I am at your gate.", "Disregard");
        new Message("0838884567", "It is dinner time !", "Sent");
        new Message("+27838884567", "Ok, I am leaving without you.", "Stored");
    }

    private static void sendMessages(Scanner sc) {
        System.out.print("\nHow many messages do you wish to send? ");
        int num = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= num; i++) {
            System.out.println("\n----- Message " + i + " -----");
            System.out.print("Enter recipient cell number: ");
            String recipient = sc.nextLine();
            System.out.print("Enter message (max 250 characters): ");
            String text = sc.nextLine();

            if (text.length() > 250) {
                System.out.println("Please enter a message of less than 250 characters.");
                i--;
                continue;
            }

            System.out.println("1) Send Message");
            System.out.println("2) Disregard Message");
            System.out.println("3) Store Message to send later");
            System.out.print("Choice: ");
            int action = sc.nextInt();
            sc.nextLine();

            String flag = action == 1 ? "Sent" : (action == 3 ? "Stored" : "Disregard");
            Message msg = new Message(recipient, text, flag);

            System.out.println(msg.checkRecipientCell());
            System.out.println(msg.SentMessage(action));

            if (action == 1) {
                System.out.println("Message ID   : " + msg.getMessageID());
                System.out.println("Message Hash : " + msg.getMessageHash());
                System.out.println("Recipient    : " + msg.getRecipient());
                System.out.println("Message      : " + msg.getMessage());
            }
        }
    }

    private static void storedMessagesMenu(Scanner sc) {
        boolean back = false;
        while (!back) {
            System.out.println("\n===== STORED MESSAGES MENU =====");
            System.out.println("a) Display sender and recipient of all stored messages");
            System.out.println("b) Display the longest stored message");
            System.out.println("c) Search for a message ID");
            System.out.println("d) Search all messages for a particular recipient");
            System.out.println("e) Delete a message using the message hash");
            System.out.println("f) Display full report");
            System.out.println("g) Back to main menu");
            System.out.print("Enter choice: ");

            String opt = sc.nextLine().toLowerCase();

            switch (opt) {
                case "a":
                    System.out.println(Message.displaySendersAndRecipients());
                    break;
                case "b":
                    System.out.println("Longest message:\n" + Message.displayLongestMessage());
                    break;
                case "c":
                    System.out.print("Enter Message ID: ");
                    System.out.println(Message.searchByMessageID(sc.nextLine()));
                    break;
                case "d":
                    System.out.print("Enter recipient number: ");
                    System.out.println(Message.searchByRecipient(sc.nextLine()));
                    break;
                case "e":
                    System.out.print("Enter Message Hash: ");
                    System.out.println(Message.deleteByHash(sc.nextLine()));
                    break;
                case "f":
                    System.out.println(Message.displayFullReport());
                    break;
                case "g":
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}