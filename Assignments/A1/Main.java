package org.example;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to ZOOtopia!");
        System.out.println();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("1. Enter as admin");
            System.out.println("2. Enter as visitor");
            System.out.println("3. View Special Details");
            System.out.println("4. Exit\n");

            System.out.println();
            System.out.print("Enter your choice: ");
            int ch = scanner.nextInt();
            scanner.nextLine();

            System.out.println();
            System.out.println("Logged in as Admin.");
            System.out.println();

            if (ch == 1) {

                while (true) {
                    System.out.println("Admin Menu:");
                    System.out.println("1. Manage Attractions");
                    System.out.println("2. Manage Animals");
                    System.out.println("3. Schedule Events");
                    System.out.println("4. Set Discounts");
                    System.out.println("5. Set Special Deal");
                    System.out.println("6. View visitor stats");
                    System.out.println("7. View Feedback");
                    System.out.println("8. Exit\n");
                    System.out.println();

                    System.out.print("Enter your choice: ");
                    int adminChoice = scanner.nextInt();
                    System.out.println();

                    switch (adminChoice) {
                        case 1 -> {
                            // manage attractions

                            System.out.println("Manage Attractions");
                            System.out.println("1. Add attraction");
                            System.out.println("2. View attraction");
                            System.out.println("3. Modify attraction");
                            System.out.println("4. Remove attraction");
                            System.out.println("5. Exit");

                            System.out.println();
                            System.out.print("Enter your choice: ");
                            int attractionChoice = scanner.nextInt();
                            System.out.println();

                            switch (attractionChoice) {
                                case 1 -> {
                                    // code
                                }

                                case 2 -> {
                                    // code
                                }

                                case 3 -> {
                                    // code
                                }

                                case 4 -> {
                                    // code
                                }

                                case 5 -> {
                                    // code
                                }
                            }
                        }

                        case 2 -> {

                            System.out.println();
                            System.out.println("Manage Animals:");
                            System.out.println("1. Add Animal");
                            System.out.println("2. Update Animal Details");
                            System.out.println("3. Remove Animal");
                            System.out.println("4. Exit");

                            System.out.println();
                            System.out.print("Enter your choice: ");
                            int animalChoice = scanner.nextInt();


                        }

                        case 3 -> {

                            System.out.println();
                            System.out.println("Schedule Event:");
                            System.out.println("1. Enter Event Name: ");
                            System.out.println("2. Enter Event Start Time: ");
                            System.out.println("3. Enter Event End Time: ");
                        }

                        case 4 -> {

                            System.out.println();
                            System.out.println("Set Discounts:");
                            System.out.println("1. Add Discount: ");
                            System.out.println("2. Modify Discount: ");
                            System.out.println("3. Remove Discount: ");
                            System.out.println("4. Exit");
                        }

                        case 5 -> {

                            System.out.println();
                            System.out.println("Set Special Deal:");
                            System.out.println("Enter Number of attractions that the user has to visit in order to avail the deal: ");
                            System.out.println("Enter the discount percentage on the total amount: ");
                        }

                        case 6 -> {
                            // view visitor stats
                        }

                        case 7 -> {
                            // view feedback
                        }

                        case 8 -> {
                            // exit the admin menu
                            System.out.println();
                            System.out.println("Logged out");
                            System.out.println();
                        }

                        default -> System.out.println("Invalid choice. Please select a valid option.");
                    }
                }
            }

            else if (ch == 2) {

                // visitor login
                while (true) {
                    System.out.println();
                    System.out.println("1. Register");
                    System.out.println("2. Login");
                    System.out.println("3. Back\n");

                    System.out.println();

                    System.out.print("Enter your choice: ");
                    scanner.nextLine(); // Consume the newline character

                    // Implement member actions based on memberChoice
                    switch (memberChoice) {
                        case 1 -> {

                        }

                        case 2 -> {

                        }

                        case 3 -> {
                            // Exit the member menu
                            System.out.println("Returning to the main menu...");
                            System.out.println();
                        }

                        default -> System.out.println("Invalid choice. Please select a valid option.");
                    }

                    // Exit the member menu loop when option 6 is chosen
                    if (memberChoice == 6) {
                        break;
                    }
                }
            }

            else if (ch == 3) {
                System.out.println("Thanks for visiting!");
                break; // Exit the while loop and the program
            }

            else {
                System.out.println("Invalid choice. Please select a valid option.");
            }
        }

        // Close the main scanner when you're done with it to avoid resource leaks
        scanner.close();
    }
}


