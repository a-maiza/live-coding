package com.viveris.product;

public class ProductNotFoundException extends RuntimeException {

    // TODO: constructeur avec message explicite (ex: "Product not found with id: " + id)
    public ProductNotFoundException(String message, Long id) {
        super(message + id);
    }
}
