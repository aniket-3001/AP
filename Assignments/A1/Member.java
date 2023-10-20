package org.example;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private final String name;
    private final int age;
    private final long phoneNumber;
    private List<Book> books;
    private double pendingFine;
    private final Librarian librarian;
    private final Library library;

    public Member(String name, int age, long phoneNumber, Librarian librarian, Library library) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.librarian = librarian;
        this.library = library;
        books = new ArrayList<>();
        pendingFine = 0.0;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for phoneNumber
    public long getPhoneNumber() {
        return phoneNumber;
    }

    // Getter for books owned by the member
    public List<Book> getBooks() {
        return books;
    }

    // Setter for books
    public void setBooks(List<Book> books) {
        this.books = books;
    }

    // Getter for pendingFine
    public double getPendingFine() {
        return pendingFine;
    }

    // Setter for pendingFine
    public void setPendingFine(double pendingFine) {
        this.pendingFine = pendingFine;
    }

    public void displayAvailableBooks(Library library) {
        List<Book> allBooks = library.getAllBooks();

        System.out.println("Available Books:");

        for (Book book: allBooks) {
            if (!book.isIssued()) {
                System.out.println("Book ID: " + book.getBookId());
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println();
            }
        }
    }

    public void payFine() {
        if (pendingFine == 0) {
            System.out.println("You don't have any pending fine.");
            return;
        }

        System.out.println("You had a total fine of Rs. " + pendingFine + ". It has been paid successfully.");
        this.pendingFine = 0;
    }

    public void issueBook(int bookID) {
        List <Book> allBooks = library.getAllBooks();

        for (Book book: allBooks) {
            if (book.getBookId() == bookID) {
                librarian.issueBook(this, book);
                return;
            }
        }

        System.out.println("Error: Book with the provided book ID is not available.");
    }

    public void returnBook(int bookID) {
        List <Book> allBooks = library.getAllBooks();

        for (Book book: allBooks) {
            if (book.getBookId() == bookID) {
                librarian.returnBook(this, book);
                return;
            }
        }

        System.out.println("Error: The book which you would like to return does not exist.");
    }

    public void displayMyBooks() {
        List<Book> myBooks = getBooks();

        System.out.println("My Books:");

        if (myBooks.isEmpty()) {
            System.out.println("You don't own any books.");
        } else {
            for (Book book : myBooks) {
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Book ID: " + book.getBookId());
                System.out.println();
            }
        }
    }

}
