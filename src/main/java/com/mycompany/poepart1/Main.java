/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poepart1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== REGISTRATION ===");
        System.out.print("Enter first name: ");
        String firstName = sc.nextLine();

        System.out.print("Enter last name: ");
        String lastName = sc.nextLine();

        System.out.print("Enter username: ");
        String username = sc.nextLine();

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        System.out.print("Enter South African cell phone number (e.g. +27838968976): ");
        String cell = sc.nextLine();

        // Create Login object
        Login user = new Login(username, password, cell, firstName, lastName);

        // Register
        String regMessage = user.registerUser();
        System.out.println("\n" + regMessage);

        // Only allow login if registration was successful
        if (regMessage.contains("User registered successfully")) {
            System.out.println("\n=== LOGIN ===");
            System.out.print("Enter username: ");
            String loginUser = sc.nextLine();

            System.out.print("Enter password: ");
            String loginPass = sc.nextLine();

            boolean success = user.loginUser(loginUser, loginPass);
            System.out.println(user.returnLoginStatus(success));
        }

        sc.close();
    }
}
