package org.example;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        Admin admin = new Admin(zoo);

        System.out.println("Welcome to ZOOtopia!");
        System.out.println();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("1. Enter as admin");
            System.out.println("2. Enter as visitor");
            System.out.println("3. Exit\n");

            System.out.println();
            System.out.print("Enter your choice: ");
            int ch = scanner.nextInt();
            scanner.nextLine();

            System.out.println();

            if (ch == 1) {

                System.out.println("logged in as admin: ");
                System.out.println();

                outermost: while (true) {
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
                    scanner.nextLine();
                    System.out.println();

                    switch (adminChoice) {
                        case 1 -> {
                            // manage attractions
                            System.out.println("Manage Attractions");

                            outer: while (true) {
                                System.out.println("1. Add attraction");
                                System.out.println("2. View attractions");
                                System.out.println("3. Modify attraction");
                                System.out.println("4. Remove attraction");
                                System.out.println("5. Back");

                                System.out.println();
                                System.out.print("Enter your choice: ");
                                int attractionChoice = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println();

                                switch (attractionChoice) {
                                    case 1 -> {
                                        System.out.print("Enter attraction name: ");
                                        String attractionName = scanner.nextLine();
                                        System.out.print("Enter attraction description: ");
                                        String attractionDescription = scanner.nextLine();

                                        admin.addAttraction(attractionName, attractionDescription);
                                        System.out.println("Attraction added successfully.");
                                        System.out.println();
                                    }

                                    case 2 -> {
                                        System.out.println("Attractions: ");
                                        System.out.println();
                                        admin.viewAttractions();
                                    }

                                    case 3 -> {
                                        System.out.print("Enter attraction name: ");
                                        String attractionName = scanner.nextLine();
                                        System.out.print("Enter new attraction description: ");
                                        String attractionDescription = scanner.nextLine();

                                        admin.modifyAttraction(attractionName, attractionDescription);
                                        System.out.println("Attraction modified successfully.");
                                    }

                                    case 4 -> {
                                        System.out.print("Enter attraction name: ");
                                        String attractionName = scanner.nextLine();

                                        admin.removeAttraction(attractionName);
                                        System.out.println("Attraction removed successfully.");
                                        System.out.println();
                                    }

                                    case 5 -> {
                                        System.out.println();
                                        break outer; // exit the attraction menu
                                    }

                                    default -> System.out.println("Invalid choice. Please select a valid option.");
                                }
                            }
                        }

                        case 2 -> {
                            System.out.println("Manage Animals:");

                            outer: while (true) {
                                System.out.println("1. Add Animal");
                                System.out.println("2. Update Animal Details");
                                System.out.println("3. Remove Animal");
                                System.out.println("4. View Animals");
                                System.out.println("5. Back");

                                System.out.println();
                                System.out.print("Enter your choice: ");
                                int animalChoice = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println();

                                switch (animalChoice) {
                                    case 1 -> {
                                        System.out.print("Enter animal name: ");
                                        String animalName = scanner.nextLine();
                                        System.out.print("Enter animal description: ");
                                        String animalDescription = scanner.nextLine();
                                        System.out.print("Enter animal noise: ");
                                        String animalNoise = scanner.nextLine();
                                        System.out.print("Enter animal category: ");
                                        String animalCategory = scanner.nextLine();

                                        admin.addAnimal(animalName, animalDescription, animalNoise, animalCategory);
                                        System.out.println("Animal added successfully.");
                                        System.out.println();
                                    }

                                    case 2 -> {
                                        System.out.print("Enter animal name: ");
                                        String animalName = scanner.nextLine();
                                        System.out.print("Enter new animal description: ");
                                        String animalDescription = scanner.nextLine();

                                        admin.modifyAnimal(animalName, animalDescription);
                                        System.out.println("Animal modified successfully.");
                                        System.out.println();
                                    }

                                    case 3 -> {
                                        System.out.print("Enter animal name: ");
                                        String animalName = scanner.nextLine();

                                        admin.removeAnimal(animalName);
                                        System.out.println("Animal removed successfully.");
                                        System.out.println();
                                    }

                                    case 4 -> {
                                        admin.viewAnimals();
                                        System.out.println();
                                    }

                                    case 5 -> {
                                        System.out.println();
                                        break outer; // exit the animal menu
                                    }

                                    default -> System.out.println("Invalid choice. Please select a valid option.");
                                }
                            }
                        }

                        case 3 -> {
                            System.out.println("Schedule Events:");

                            System.out.print("Enter event name: ");
                            String eventName = scanner.nextLine();
                            System.out.print("Enter event status (open/closed): ");
                            String eventStatus = scanner.nextLine();
                            System.out.print("Enter event ticket price: ");
                            float eventTicketPrice = scanner.nextFloat();
                            scanner.nextLine();

                            if (eventStatus.equals("open")) {
                                admin.scheduleEvent(eventName, true, eventTicketPrice);
                            }
                            else if (eventStatus.equals("closed")) {
                                admin.scheduleEvent(eventName, false, eventTicketPrice);
                            }
                            else {
                                System.out.println("Invalid event status.");
                            }

                            System.out.println("Event scheduled successfully.");
                            System.out.println();
                        }

                        case 4 -> {
                            System.out.println("Set Discounts:");

                            outer: while (true) {
                                System.out.println("1. Add discount");
                                System.out.println("2. Modify discounts");
                                System.out.println("3. Remove discount");
                                System.out.println("4. Back");

                                System.out.println();
                                System.out.print("Enter your choice: ");
                                int discountChoice = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println();

                                switch (discountChoice) {
                                    case 1 -> {
                                        System.out.print("Enter discount category: ");
                                        String discountCategory = scanner.nextLine();
                                        System.out.print("Enter discount code: ");
                                        String discountCode = scanner.nextLine();
                                        System.out.print("Enter discount percentage: ");
                                        int discountPercentage = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.print("Enter lower age limit: ");
                                        int lowerAgeLimit = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.print("Enter upper age limit: ");
                                        int upperAgeLimit = scanner.nextInt();
                                        scanner.nextLine();

                                        admin.addAgeBasedDiscount(lowerAgeLimit, upperAgeLimit, discountPercentage, discountCategory, discountCode);
                                        System.out.println("Discount added successfully.");
                                        System.out.println();
                                    }

                                    case 2 -> {
                                        System.out.print("Enter discount code: ");
                                        String discountCode = scanner.nextLine();
                                        System.out.print("Enter discount percentage: ");
                                        int discountPercentage = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.print("Enter lower age limit: ");
                                        int lowerAgeLimit = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.print("Enter upper age limit: ");
                                        int upperAgeLimit = scanner.nextInt();
                                        scanner.nextLine();

                                        admin.modifyAgeBasedDiscount(discountCode, lowerAgeLimit, upperAgeLimit, discountPercentage);
                                        System.out.println("Discount modified successfully.");
                                        System.out.println();
                                    }

                                    case 3 -> {
                                        System.out.print("Enter discount code: ");
                                        String discountCode = scanner.nextLine();

                                        admin.removeAgeBasedDiscount(discountCode);
                                        System.out.println("Discount removed successfully.");
                                        System.out.println();
                                    }

                                    case 4 -> {
                                        System.out.println();
                                        break outer; // exit the discount menu
                                    }

                                    default -> System.out.println("Invalid choice. Please select a valid option.");
                                }
                            }
                        }

                        case 5 -> {
                            // set special deal

                            System.out.println("Set Special Deal:");

                            outer: while (true) {
                                System.out.println("1. Add special deal");
                                System.out.println("2. Modify special deal");
                                System.out.println("3. Remove special deal");
                                System.out.println("4. Back");

                                System.out.println();
                                System.out.print("Enter your choice: ");
                                int specialDealChoice = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println();

                                switch (specialDealChoice) {
                                    case 1 -> {
                                        System.out.print("Enter number of tickets required to avail the special deal: ");
                                        int minTotalTickets = scanner.nextInt();
                                        scanner.nextLine();

                                        System.out.print("Enter discount percentage to be given on total amount: ");
                                        int discountPercentage = scanner.nextInt();
                                        scanner.nextLine();

                                        admin.addTotalTicketsSpecialDeal(minTotalTickets, discountPercentage);
                                        System.out.println("Special deal added successfully.");
                                        System.out.println();
                                    }

                                    case 2 -> {
                                        System.out.print("Enter number of tickets required to avail the special deal: ");
                                        int minTotalTickets = scanner.nextInt();
                                        scanner.nextLine();

                                        System.out.print("Enter discount percentage to be given on total amount: ");
                                        int discountPercentage = scanner.nextInt();
                                        scanner.nextLine();

                                        System.out.print("Enter new number of tickets required to avail the special deal: ");
                                        int newMinTotalTickets = scanner.nextInt();
                                        scanner.nextLine();

                                        System.out.print("Enter new discount percentage to be given on total amount: ");
                                        int newDiscountPercentage = scanner.nextInt();
                                        scanner.nextLine();

                                        admin.modifyTotalTicketsSpecialDeal(minTotalTickets, discountPercentage, newMinTotalTickets, newDiscountPercentage);
                                        System.out.println("Special deal modified successfully.");
                                        System.out.println();
                                    }

                                    case 3 -> {
                                        System.out.print("Enter number of tickets required to avail the special deal: ");
                                        int minTotalTickets = scanner.nextInt();
                                        scanner.nextLine();

                                        System.out.print("Enter discount percentage to be given on total amount: ");
                                        int discountPercentage = scanner.nextInt();
                                        scanner.nextLine();

                                        admin.removeTotalTicketsSpecialDeal(minTotalTickets, discountPercentage);
                                        System.out.println("Special deal removed successfully.");
                                        System.out.println();
                                    }

                                    case 4 -> {
                                        System.out.println();
                                        break outer; // exit the special deal menu
                                    }

                                    default -> System.out.println("Invalid choice. Please select a valid option.");
                                }
                            }
                        }

                        case 6 -> {
                            // view visitor stats

                            System.out.println("View Visitor Stats:");
                            System.out.println();
                            admin.viewVisitorStats();
                        }

                        case 7 -> {
                            // view feedback

                            System.out.println("View Feedback:");
                            System.out.println();
                            admin.viewFeedback();
                        }

                        case 8 -> {
                            // exit the admin menu
                            System.out.println();
                            System.out.println("Logged out");
                            System.out.println();
                            break outermost; // exit the admin menu
                        }

                        default -> System.out.println("Invalid choice. Please select a valid option.");
                    }
                }
            }

            else if (ch == 2) {

                // visitor login

                while (true) {
                    System.out.println("1. Register");
                    System.out.println("2. Login");
                    System.out.println("3. Back\n");

                    System.out.println();

                    System.out.print("Enter your choice: ");
                    int visitorChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (visitorChoice == 1) {
                        System.out.print("Enter your name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter your age: ");
                        int age = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter your phone number: ");
                        String phoneNumber = scanner.nextLine();
                        System.out.print("Enter your email: ");
                        String email = scanner.nextLine();
                        System.out.print("Enter your password: ");
                        String password = scanner.nextLine();
                        System.out.print("Enter your balance: ");
                        double balance = scanner.nextFloat();

                        zoo.addVisitor(name, age, phoneNumber, balance, email, password);
                        zoo.setVisitorCount(zoo.getVisitorCount() + 1);
                        System.out.println("Visitor added successfully.");
                        System.out.println();
                    }

                    else if (visitorChoice == 2) {
                        System.out.print("Enter visitor email: ");
                        String email = scanner.nextLine();
                        System.out.print("Enter visitor password: ");
                        String password = scanner.nextLine();

                        Visitor visitor = zoo.findVisitor(email, password);

                        if (visitor == null) {
                            System.out.println("Invalid email or password.");
                            System.out.println();
                            continue;
                        }

                        System.out.println();
                        System.out.println("login successful");
                        System.out.println();
                        System.out.println("Visitor menu:");

                        outer: while (true) {
                            System.out.println("1. Explore the Zoo");
                            System.out.println("2. Buy Membership");
                            System.out.println("3. Buy tickets");
                            System.out.println("4. View Discounts");
                            System.out.println("5. View Special Deals");
                            System.out.println("6. Visit Animals");
                            System.out.println("7. Visit Attractions");
                            System.out.println("8. Give Feedback");
                            System.out.println("9. Logout\n");

                            System.out.println();
                            System.out.print("Enter your choice: ");
                            int visitorMenuChoice = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println();

                            switch (visitorMenuChoice) {
                                case 1 -> {
                                    // explore the zoo

                                    System.out.println("Explore the Zoo:");

                                    outer1: while (true) {
                                        System.out.println("1. View attractions");
                                        System.out.println("2. View animals");
                                        System.out.println("3. Back");

                                        System.out.println();
                                        System.out.print("Enter your choice: ");
                                        int exploreChoice = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.println();

                                        switch (exploreChoice) {
                                            case 1 -> {
                                                System.out.println("Attractions: ");
                                                System.out.println();
                                                visitor.viewAttractions();
                                            }

                                            case 2 -> {
                                                System.out.println("Animals: ");
                                                System.out.println();
                                                visitor.viewAnimals();
                                            }

                                            case 3 -> {
                                                System.out.println();
                                                break outer1; // exit the explore menu
                                            }
                                        }
                                    }
                                }

                                case 2 -> {
                                    System.out.print("Enter membership which you would like to buy (basic/premium): ");
                                    String membershipType = scanner.nextLine();
                                    System.out.print("Enter discount code (if none, type none): ");
                                    String discountCode = scanner.nextLine();

                                    if (discountCode.equals("none")) {
                                        visitor.buyMembership(membershipType, "");
                                    }
                                    else {
                                        visitor.buyMembership(membershipType, discountCode);
                                    }

                                    System.out.println("Membership bought successfully.");
                                    System.out.println();
                                }

                                case 3 -> {
                                    System.out.print("Enter name of attraction: ");
                                    String attractionName = scanner.nextLine();
                                    System.out.print("Enter number of tickets: ");
                                    int quantity = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.print("Enter discount code (if none, type none): ");
                                    String discountCode = scanner.nextLine();

                                    if (discountCode.equals("none")) {
                                        visitor.buyTickets(attractionName, quantity, "");
                                    }
                                    else {
                                        visitor.buyTickets(attractionName, quantity, discountCode);
                                    }

                                    System.out.println("Tickets bought successfully.");
                                    System.out.println();
                                }

                                case 4 -> {
                                    System.out.println("Discounts: ");
                                    System.out.println();
                                    visitor.viewDiscounts();
                                }

                                case 5 -> {
                                    System.out.println("Special Deals: ");
                                    System.out.println();
                                    visitor.viewDeals();
                                }

                                case 6 -> {
                                    System.out.print("Which animal would you like to visit: ");
                                    String animalName = scanner.nextLine();
                                    System.out.print("Enter action (feed/read): ");
                                    String action = scanner.nextLine();

                                    if (action.equals("feed")) {
                                        visitor.visitAnimal(animalName, "feed");
                                    }
                                    else if (action.equals("read")) {
                                        visitor.visitAnimal(animalName, "read");
                                    }
                                    else {
                                        System.out.println("Invalid action.");
                                    }

                                    System.out.println();
                                }

                                case 7 -> {
                                    System.out.print("Which attraction would you like to visit: ");
                                    String attractionName = scanner.nextLine();

                                    visitor.visitAttraction(attractionName);
                                    System.out.println();
                                }

                                case 8 -> {
                                    System.out.print("Enter your feedback: ");
                                    String feedback = scanner.nextLine();

                                    visitor.setFeedback(feedback);
                                    System.out.println("Feedback submitted successfully.");
                                    System.out.println();
                                }

                                case 9 -> {
                                    System.out.println();
                                    break outer; // exit the visitor menu
                                }

                                default -> System.out.println("Invalid choice. Please select a valid option.");
                            }
                        }
                    }

                    else if (visitorChoice == 3) {
                        System.out.println();
                        break;
                    }

                    else {
                        System.out.println("Invalid choice. Please select a valid option.");
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

        scanner.close();
    }
}
