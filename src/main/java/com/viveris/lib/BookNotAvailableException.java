package com.viveris.lib;

public class BookNotAvailableException extends RuntimeException {
    public BookNotAvailableException() {
        super();
    }
    public BookNotAvailableException(String message) {
        super(message);
    }
    public BookNotAvailableException(String message, Throwable cause) {
        super(message, cause);
    }
}
