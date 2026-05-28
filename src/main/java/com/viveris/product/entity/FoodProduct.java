package com.viveris.product.entity;

import com.viveris.product.enums.ProductType;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

// Table "food_products" — colonnes spécifiques aux produits alimentaires
@Entity
@Table(name = "food_products")
@DiscriminatorValue("FOOD")
public class FoodProduct extends Product {

    // TODO: attribut expiryDate (date d'expiration) — @Column(nullable = false)
    @Column(nullable = false, updatable = false)
    private LocalDate expiryDate;

    // TODO: attribut organic (produit bio ou non) — booléen
    private Boolean organic;

    // TODO: constructeur vide pour JPA
    public FoodProduct() {
    }

    // TODO: constructeur avec (name, price, expiryDate, organic)
    //       appeler super(name, price, ProductType.FOOD)
    public FoodProduct(String name, double price, ProductType type, LocalDate expiryDate, Boolean organic) {
        super(name, price, type);
        this.expiryDate = expiryDate;
        this.organic = organic;
    }

    // TODO: getters + setters pour expiryDate et organic

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Boolean isOrganic() {
        return organic;
    }

    public void setOrganic(boolean organic) {
        this.organic = organic;
    }
}
