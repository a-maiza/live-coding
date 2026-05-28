package com.viveris.product.entity;

import com.viveris.product.enums.ProductType;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "food_products")
@DiscriminatorValue("FOOD")
public class FoodProduct extends Product {

    @Column(nullable = false)
    private LocalDate expiryDate;

    @Column(nullable = false)
    private boolean organic;

    public FoodProduct() {}

    public FoodProduct(String name, double price, LocalDate expiryDate, boolean organic) {
        super(name, price, ProductType.FOOD);
        this.expiryDate = expiryDate;
        this.organic = organic;
    }

    public LocalDate getExpiryDate() { return expiryDate; }
    public void setExpiryDate(LocalDate expiryDate) { this.expiryDate = expiryDate; }
    public boolean isOrganic() { return organic; }
    public void setOrganic(boolean organic) { this.organic = organic; }
}
