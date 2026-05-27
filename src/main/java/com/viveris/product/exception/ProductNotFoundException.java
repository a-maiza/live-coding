package com.viveris.product.exception;

public class ProductNotFoundException extends RuntimeException {

    // TODO: constructeur avec message explicite (ex: "Product not found with id: " + id)
    public ProductNotFoundException(Long id) {
        super("Product not found with id: " + id);
    }
}
