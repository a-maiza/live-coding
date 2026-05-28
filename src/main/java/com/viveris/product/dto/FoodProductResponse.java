package com.viveris.product.dto;

import com.viveris.product.enums.ProductType;

import java.time.LocalDate;
import java.util.Date;

// DTO de réponse spécifique aux produits alimentaires
public class FoodProductResponse extends ProductResponse {

    // TODO: attribut expiryDate
    // TODO: attribut organic
    private LocalDate expiryDate;
    private Boolean organic;
    // TODO: constructeur vide
    public FoodProductResponse() {
    }

    // TODO: constructeur avec (id, name, price, expiryDate, organic)
    //       appeler super(id, name, price, ProductType.FOOD)
    public FoodProductResponse(Long id, String name, double price, ProductType type, LocalDate expiryDate, Boolean organic) {
        super(id, name, price, type);
        this.expiryDate = expiryDate;
        this.organic = organic;
    }

    // TODO: getters
    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public boolean isOrganic() {
        return organic;
    }
}
