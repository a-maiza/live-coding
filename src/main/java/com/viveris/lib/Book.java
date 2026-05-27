package com.viveris.lib;

public class Book {
    private final String title;
    private final String author;
    private Status status;

    public Book(String title, String author) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be null or blank");
        }
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("Author cannot be null or blank");
        }
        this.title = title;
        this.author = author;
        this.status = Status.AVAILABLE;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", status=" + status +
                '}';
    }
}
