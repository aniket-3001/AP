package org.example;

import java.util.Scanner;
public class Main {

    static Library library = new Library();

    static int bookID_counter = 1;

    public static void main(String[] args) {
        System.out.println("Library Portal Initialized...");
        System.out.println();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("1. Enter as a librarian");
            System.out.println("2. Enter as a member");
            System.out.println("3. Exit\n");

            int ch = scanner.nextInt();

            scanner.nextLine();

            System.out.println();

            if (ch == 1) {
                Scanner librarianScanner = new Scanner(System.in);

                while (true) {
                    System.out.println();
                    System.out.println("1. Register a member");
                    System.out.println("2. Remove a member");
                    System.out.println("3. Add a book");
                    System.out.println("4. Remove a book");
                    System.out.println("5. View all members along with their books and fines to be paid");
                    System.out.println("6. View all books");
                    System.out.println("7. Back\n");

                    int librarianChoice = librarianScanner.nextInt();
                    System.out.println();

                    switch (librarianChoice) {
                        case 1 -> {
                            // Register a member

                            System.out.print("Name: ");
                            librarianScanner.nextLine();
                            String name = librarianScanner.nextLine();

                            System.out.print("Age: ");
                            int age = librarianScanner.nextInt();

                            librarianScanner.nextLine();
                            System.out.print("Phone Number: ");
                            long phoneNumber = librarianScanner.nextLong();

                            library.getLibrarian().registerMember(name, age, phoneNumber);
                        }

                        case 2 -> {
                            // Remove a member

                            System.out.print("Name: ");
                            librarianScanner.nextLine();
                            String name = librarianScanner.nextLine();

                            System.out.print("Phone Number: ");
                            long phoneNumber = librarianScanner.nextLong();

                            library.getLibrarian().removeMember(name, phoneNumber);
                        }

                        case 3 -> {
                            // Add a book

                            System.out.print("Book title: ");
                            librarianScanner.nextLine();
                            String title = librarianScanner.nextLine();

                            System.out.print("Book author: ");
                            String author = librarianScanner.nextLine();

                            System.out.print("Total copies: ");
                            int totalCopies = librarianScanner.nextInt();

                            for (int i = 1; i <= totalCopies; i++) {
                                library.getLibrarian().addBook(bookID_counter, title, author);
                                bookID_counter++;
                            }

                            System.out.println("Book added successfully.");
                        }

                        case 4 -> {
                            // Remove a book

                            System.out.print("Book ID: ");
                            int bookID = librarianScanner.nextInt();

                            library.getLibrarian().removeBook(bookID);
                        }

                        case 5 -> // View all members along with their books and fines to be paid
                                library.getLibrarian().viewAllMembersWithBooksAndFines();

                        case 6 -> // View all books
                                library.getLibrarian().viewAllBooks();

                        case 7 -> {
                            // Exit the librarian menu
                            System.out.println("Returning to the main menu...");
                            System.out.println();
                        }

                        default -> System.out.println("Invalid choice. Please select a valid option.");
                    }
                    // Exit the librarian menu loop when option 7 is chosen
                    if (librarianChoice == 7) {
                        break;
                    }
                }
            }

            else if (ch == 2) {
                // Member login
                System.out.print("Name: ");
                String memberName = scanner.nextLine();

                System.out.print("Phone No: ");
                long memberPhone = scanner.nextLong();

                System.out.println();

                Member member = library.getMember(memberPhone, memberName);

                if (member == null) {
                    continue;
                }

                while (true) {
                    System.out.println();
                    System.out.println("1. List Available Books");
                    System.out.println("2. List My Books");
                    System.out.println("3. Issue book");
                    System.out.println("4. Return book");
                    System.out.println("5. Pay Fine");
                    System.out.println("6. Back\n");

                    int memberChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    // Implement member actions based on memberChoice
                    switch (memberChoice) {
                        case 1 -> // List available books
                                member.displayAvailableBooks(library);

                        case 2 -> // List my books
                                member.displayMyBooks();

                        case 3 -> {
                            // Issue book
                            System.out.print("Book Id: ");
                            int bookID = scanner.nextInt();

                            member.issueBook(bookID);
                        }

                        case 4 -> {
                            // Return book
                            System.out.print("Book Id: ");
                            int bookID = scanner.nextInt();

                            member.returnBook(bookID);
                        }

                        case 5 -> // Pay fine
                                member.payFine();

                        case 6 -> {
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


