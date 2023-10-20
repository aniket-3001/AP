package org.example;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<Member> members;
    private final Librarian librarian;
    private final List<Book> books;

    public Library() {
        members = new ArrayList<>();
        books = new ArrayList<>();
        librarian = new Librarian(this);
    }

    // Add a member to the library
    public void addMember(Member member) {
        members.add(member);
    }

    // Remove a member from the library
    public void removeMember(Member member) {
        members.remove(member);
    }

    // Get all members in the library
    public List<Member> getAllMembers() {
        return members;
    }

    public Librarian getLibrarian() {
        return librarian;
    }

    // Add a book to the library
    public void addBook(Book book) {
        books.add(book);
    }

    // Remove a book from the library
    public void removeBook(Book book) {
        books.remove(book);
    }

    // Get all books in the library
    public List<Book> getAllBooks() {
        return books;
    }

    public Member getMember(long phoneNumber, String name) {
        for (Member member: members) {
            if (member.getPhoneNumber() == phoneNumber && member.getName().equals(name)) {
                System.out.println("Welcome " + member.getName() + ". Member ID: " + member.getPhoneNumber() + ".");
                return member;
            }
        }

        System.out.println("Member with name: " + name + " and phone number: " + phoneNumber + " does not exist.");

        return null;

    }

}
