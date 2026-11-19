/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poepart2;

import java.util.Scanner;

/**
 *
 * @author Student
 */
public class PoePart1 {

    public static void main(String[] args) {
        // Create a scanner to read user input
        Scanner scan = new Scanner(System.in);

        // Create an object of the Login class
        Login register = new Login();

        // Create an object of the Message class
        Message msg = new Message();

        // ==================== REGISTRATION ====================
        System.out.println("\n======= Register =======");

        // Ask for the first name
        System.out.println("Please enter your first name");
        String firstName = scan.nextLine();

        // Ask for the last name
        System.out.println("Please enter your last name");
        String lastName = scan.nextLine();

        // Ask for the username
        System.out.println("Please enter the username");
        String name = scan.nextLine();

        // Ask for the password
        System.out.println("Please enter the password");
        String password = scan.nextLine();

        // Ask for the cellphone number
        System.out.println("Enter cellphone number");
        String cellphone = scan.nextLine();

        // Store the names in the object so Login can use them
        register.firstName = firstName;
        register.lastName = lastName;

        // Register the user and print the result
        System.out.println(register.registerUser(name, password, cellphone));

        // Only continue if registration was successful
        if (!register.registerStatus(name, password, cellphone)) {
            System.out.println("Registration failed. Cannot login.");
            scan.close();
            return;
        }

        // ==================== LOGIN ====================
        System.out.println("\n======= Login =======");

        System.out.println("Please enter your username to login");
        String loginName = scan.nextLine();

        System.out.println("Please enter your password to login");
        String loginPass = scan.nextLine();

        // Check if login was successful
        boolean loginSuccess = register.loginUser(loginName, loginPass);
        System.out.println(register.returnLoginStatus(loginSuccess));

        // If login failed, exit the program
        if (!loginSuccess) {
            scan.close();
            return;
        }

                // ==================== WELCOME & MENU ====================
        System.out.println("\nWelcome to QuickChat.");

        // Initialize the MessageManager for Part 3
        MessageManager manager = new MessageManager();
        manager.populateTestData(); // Load the lecturer's test data

        boolean running = true;

        while (running) {
            System.out.println("\nPlease choose an option:");
            System.out.println("Option 1) Send Messages");
            System.out.println("Option 2) Show recently sent messages");
            System.out.println("Option 3) Quit");
            System.out.println("Option 4) Stored Messages"); // NEW OPTION

            int menuChoice = scan.nextInt();
            scan.nextLine(); 

            if (menuChoice == 1) {
                // ... (Keep your existing Option 1 code exactly as it is) ...
            } else if (menuChoice == 2) {
                System.out.println("Coming Soon.");
            } else if (menuChoice == 4) {
                // NEW PART 3 SUB-MENU
                boolean subMenuRunning = true;
                while (subMenuRunning) {
                    System.out.println("\n--- STORED MESSAGES MENU ---");
                    System.out.println("a) Display all stored messages");
                    System.out.println("b) Display the longest message");
                    System.out.println("c) Search for a Message ID");
                    System.out.println("d) Search by Recipient");
                    System.out.println("e) Delete a message by Hash");
                    System.out.println("f) Display Message Report");
                    System.out.println("g) Back to Main Menu");
                    
                    String subChoice = scan.nextLine();
                    
                    switch (subChoice.toLowerCase()) {
                        case "a":
                            manager.readJsonFile(); // Also reads the JSON file for marks!
                            manager.displayAllStored();
                            break;
                        case "b":
                            manager.displayLongestMessage();
                            break;
                        case "c":
                            System.out.print("Enter Message ID: ");
                            manager.searchByID(scan.nextLine());
                            break;
                        case "d":
                            System.out.println("Enter Recipient (e.g., +27838884567): ");
                            manager.searchByRecipient(scan.nextLine());
                            break;
                        case "e":
                            System.out.println("Enter Message Hash (e.g., 22:2:WHERETIME): ");
                            manager.deleteByHash(scan.nextLine());
                            break;
                        case "f":
                            manager.displayReport();
                            break;
                        case "g":
                            subMenuRunning = false;
                            break;
                        default:
                            System.out.println("Invalid option.");
                    }
                }
            } else if (menuChoice == 3) {
                System.out.println("Goodbye!");
                running = false;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }

        // Close the scanner
        scan.close();
    }
}