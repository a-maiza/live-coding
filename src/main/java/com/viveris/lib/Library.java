package com.viveris.lib;

import java.util.*;

public class Library {
    private final Map<String, Book> books;

    public Library() {
        this.books = new HashMap<>();
    }

    public void addBook(Book book){
        if (this.books.containsKey(book.getTitle())){
            throw new IllegalArgumentException("book already exists");
        }
        this.books.put(book.getTitle(), book);
    }

    public Book borrowBook(String titre){
        if (!this.books.containsKey(titre)){
            throw new BookNotFoundException("book does not exist");
        } else if (books.get(titre).getStatus() == Status.BORROWED) {
            throw new BookNotAvailableException("book is borrowed");
        }
        books.get(titre).setStatus(Status.BORROWED);
        return books.get(titre);
    }

    public void returnBook(String titre){
        if (!this.books.containsKey(titre)){
            throw new BookNotFoundException("book does not exist");
        } else if (books.get(titre).getStatus() == Status.AVAILABLE){
            throw new IllegalArgumentException("book already returned");
        }
        books.get(titre).setStatus(Status.AVAILABLE);
    }

    public List<Book> listBooks(Map<String, Book> books){
        List<Book> bookList = new ArrayList<>();
        books.forEach((title, book) -> {
            if (this.books.get(book.getTitle()).getStatus() ==  Status.AVAILABLE){
                bookList.add(book);
            }
        });
        return bookList;
    }

    public List<Book> searchBook(String author){
        List<Book> bookList = new ArrayList<>();
        books.forEach((title, book) -> {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                bookList.add(book);
            }
        });
        return bookList;
    }

    public Map<String, Book> getBooks() {
        return Collections.unmodifiableMap(books);
    }
}
