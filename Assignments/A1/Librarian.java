package org.example;

import java.util.List;
import java.util.Date;

public class Librarian {
    private static Library library;

    public Librarian(Library library) {
        Librarian.library = library;
    }

    // Method to register a member
    public void registerMember(String name, int age, long phoneNumber) { // parameters are to be taken as input in the main method
        Member member = new Member(name, age, phoneNumber, this, library);

        // Get the list of all members from the library
        List<Member> allMembers = library.getAllMembers();

        // Check if the provided member's phone number matches with any existing member
        for (Member existingMember: allMembers) {
            if (existingMember.getPhoneNumber() == member.getPhoneNumber()) {
                System.out.println("Error: Member with the same phone number already exists.");
                return; // Phone numbers must be unique, so exit the method
            }
        }

        // If no matching phone number is found, add the member to the library
        library.addMember(member);
        System.out.println("Member successfully registered with member id: " + member.getPhoneNumber());
    }

    // Method to remove a member
    public void removeMember(String name, long phoneNumber) { // parameters are to be taken as input in the main method
        // Get the list of all members from the library
        List<Member> allMembers = library.getAllMembers();

        // Check if the provided member's phone number matches with any existing member
        for (Member existingMember: allMembers) {
            if (existingMember.getPhoneNumber() == phoneNumber && existingMember.getName().equals(name)) {
                if (!existingMember.getBooks().isEmpty()) {
                    System.out.println("Error: This member has books issued to their name. Hence, they cannot be removed.");
                    return;
                }

                if (existingMember.getPendingFine() > 0) {
                    System.out.println("Error: This member has a pending fine of Rs. " + existingMember.getPendingFine() + ". Please ask them to clear their dues before you remove them.");
                    return;
                }

                library.removeMember(existingMember);
                System.out.println("Member removed successfully.");
                return;
            }
        }

        System.out.println("Error: Member with the given credentials does not exist.");
    }

    // Method to add a book by book ID, title, author, and total copies
    public void addBook(int bookID, String title, String author) { // parameters are to be taken as input in the main method
        // Create a new Book object with the provided details
        Book newBook = new Book(bookID, title, author);

        library.addBook(newBook);
    }

    public void removeBook(int bookID) { // parameters are to be taken as input in the main method
        List<Book> allBooks = library.getAllBooks();

        if (allBooks.isEmpty()) {
            System.out.println("No books registered yet.");
            return;
        }

        for (Book existingBook: allBooks) {
            if (existingBook.getBookId() == bookID) {
                if (existingBook.isIssued()) {
                    System.out.println("Error: This book is currently issued to a member. Hence, it cannot be removed.");
                    return;
                }

                library.removeBook(existingBook);
                System.out.println("Book removed successfully.");
                return;
            }
        }

        System.out.println("Error: Book with the provided book ID doesn't exist.");
    }

    public void viewAllMembersWithBooksAndFines() {
        List<Member> members = library.getAllMembers();

        if (members.isEmpty()) {
            System.out.println("No members registered yet.");
            return;
        }

        System.out.println("List of Members with Books and Fines:");

        for (Member member: members) {
            System.out.println("Member Name: " + member.getName());
            System.out.println("Phone Number: " + member.getPhoneNumber());
            System.out.println("Past fine overdue: Rs. " + member.getPendingFine());

            // Display books owned by the member
            System.out.println("Books Owned:");
            List<Book> memberBooks = member.getBooks();
            if (memberBooks.isEmpty()) {
                System.out.println("No books owned.");
            } else {
                for (Book book : memberBooks) {
                    System.out.println("Book ID: " + book.getBookId());
                    System.out.println("Book Title: " + book.getTitle());
                    System.out.println("Fine for this book till date: Rs. " + calcBookFine(book));
                    System.out.println();
                }
            }

            System.out.println();
        }
    }

    // Method to view all books
    public void viewAllBooks() {
        List<Book> books = library.getAllBooks();

        System.out.println("List of All Books:");

        for (Book book: books) {
            System.out.println("Book ID: " + book.getBookId());
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println();
        }
    }

    // The calcBookFine method calculates the fine for a book
    private double calcBookFine(Book book) {
        // Calculate the time difference in milliseconds between endTime and startTime
        long timeDifferenceMillis = new Date().getTime() - book.getStartTime().getTime();

        // Convert milliseconds to seconds (1 sec = 1 day)
        long timeDifferenceDays = timeDifferenceMillis / 1000;

        // Calculate the number of days overdue (due date is 10 days after the issue date)
        int daysOverdue = (int) (timeDifferenceDays - 10);

        // Calculate the fine (3 rupees per day overdue)
        return Math.max(0, daysOverdue * 3.0);
    }

    // The calcFine method calculates the fine for a book and adds it to a member's pendingFine
    // This method gets called when a book is returned
    private void calcFine(Member member, Book book) {
        double fine = calcBookFine(book);

        // Add the fine to the member's pendingFine
        double currentPendingFine = member.getPendingFine();
        double newPendingFine = currentPendingFine + fine;
        member.setPendingFine(newPendingFine);

        int daysOverdue = ((int) fine) / 3;

        System.out.println("Book ID: " + book.getBookId() + " successfully returned. " + fine + " Rupees has been charged for a delay of " + daysOverdue + " days.");
    }

    public void issueBook(Member member, Book book) {
        // Check if the book is already issued

        if (!book.isIssued()) {
            if (member.getBooks().size() == 2) {
                System.out.println("Error: You can't issue more than 2 books at a time.");
                return;
            }

            // Check if the member has pending fines
            if (member.getPendingFine() > 0) {
                System.out.println("Error: You have a pending fine of Rs " + member.getPendingFine() + ". Please clear your dues before issuing a new book.");
                return;
            }

            // Check if the member already has a book issued that is past its due date
            if (member.getBooks().size() == 1) {
                if (calcBookFine(member.getBooks().get(0)) > 0) {
                    System.out.println("Error: Please return your issued book and clear your dues before issuing a new book.");
                    return;
                }
            }

            // Issue the book
            List<Book> memberBooks = member.getBooks();
            memberBooks.add(book);
            member.setBooks(memberBooks);

            book.setIssued(true);
            book.setStartTime(new Date());
            System.out.println("Book issued successfully.");
        }

        else {
            System.out.println("Error: This book is already issued.");
        }
    }

    public void returnBook(Member member, Book book) {
        List<Book> memberBooks = member.getBooks();

        // Check if the member has the book
        if (memberBooks.contains(book)) {
            // Calculate the fine
            calcFine(member, book);

            memberBooks.remove(book);
            member.setBooks(memberBooks);

            book.setIssued(false);
            book.setStartTime(null);

        } else {
            System.out.println("Error: You don't have this book, hence, you cannot return it.");
        }
    }

}