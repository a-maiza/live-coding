package com.viveris.lib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Library {
    private final Map<String, Book> books;

    public Library(Map<String, Book> books) {
        this.books = books;
    }

    public void addBook(Book book){
        if (this.books.containsKey(book.getTitle())){
            throw new IllegalArgumentException("book already exists");
        }
        this.books.put(book.getTitle(), book);
    }

    public Book borrowBook(Book book){
        if (!this.books.containsKey(book.getTitle())){
            throw new BookNotFoundException("book does not exist");
        } else if (books.get(book.getTitle()).getStatus() == Status.BORROWED) {
            throw new BookNotAvailableException("book is borrowed");
        }
        books.get(book.getTitle()).setStatus(Status.BORROWED);
        return books.get(book.getTitle());
    }

    public void returnBook(Book book){
        if (!this.books.containsKey(book.getTitle())){
            throw new BookNotFoundException("book does not exist");
        } else if (books.get(book.getTitle()).getStatus() == Status.AVAILABLE){
            throw new IllegalArgumentException("book already returned");
        }
        books.get(book.getTitle()).setStatus(Status.AVAILABLE);
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
