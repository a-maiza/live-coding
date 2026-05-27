package com.viveris.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class ProductRequest {

    @NotBlank(message = "Le nom du produit est obligatoire")
    private String name;
    @Positive(message = "Le prix du produit doit être supérieur à 0")
    private double price;

    public ProductRequest() {
    }

    public ProductRequest(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
