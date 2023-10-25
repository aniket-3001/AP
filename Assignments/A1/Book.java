package org.example;

import java.util.Date;

public class Book {
    private final int bookID;
    private final String title;
    private final String author;
    boolean issued = false;
    private Date startTime;

    public Book(int bookId, String title, String author) {
        this.bookID = bookId;
        this.title = title;
        this.author = author;
    }

    // defining setters and getters for all the fields

    public int getBookId() {
        return bookID;
    }


    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return issued;
    }

    public void setIssued(boolean issued) {
        this.issued = issued;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getStartTime() {
        return startTime;
    }
}
