package com.viveris.product.entity;

import com.viveris.product.enums.ProductType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;

// Table "electronic_products" — contient uniquement les colonnes spécifiques
// Les colonnes communes (name, price, type) restent dans "products"
@Entity
@Table(name = "electronic_products")
@DiscriminatorValue("ELECTRONIC")
public class ElectronicProduct extends Product {

    // TODO: attribut brand (marque) — @Column(nullable = false)
    @Column(nullable = false, updatable = false)
    private String brand;

    // TODO: attribut warrantyMonths (durée de garantie en mois) — @Column(nullable = false)
    @Positive
    private int warrantyMonths;

    // TODO: constructeur vide pour JPA
    public ElectronicProduct() {
    }

    // TODO: constructeur avec (name, price, brand, warrantyMonths)
    //       appeler super(name, price, ProductType.ELECTRONIC)
    public ElectronicProduct(String name, double price, ProductType type, String brand, int warrantyMonths) {
        super(name, price, type);
        this.brand = brand;
        this.warrantyMonths = warrantyMonths;
    }

    // TODO: getters + setters pour brand et warrantyMonths
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getWarrantyMonths() {
        return warrantyMonths;
    }

    public void setWarrantyMonths(int warrantyMonths) {
        this.warrantyMonths = warrantyMonths;
    }
}
