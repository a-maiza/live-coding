package com.viveris.product.dto;

import com.viveris.product.enums.ProductType;

import java.time.LocalDate;

public class FoodProductResponse extends ProductResponse {

    private LocalDate expiryDate;
    private boolean organic;

    public FoodProductResponse() {}

    public FoodProductResponse(Long id, String name, double price,
                               LocalDate expiryDate, boolean organic) {
        super(id, name, price, ProductType.FOOD);
        this.expiryDate = expiryDate;
        this.organic = organic;
    }

    public LocalDate getExpiryDate() { return expiryDate; }
    public boolean isOrganic() { return organic; }
}
