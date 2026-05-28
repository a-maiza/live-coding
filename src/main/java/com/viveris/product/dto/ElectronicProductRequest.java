package com.viveris.product.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

// DTO spécifique aux produits électroniques
// Hérite de ProductRequest (name, price, type)
public class ElectronicProductRequest extends ProductRequest {

    // TODO: attribut brand — @NotBlank
    // TODO: attribut warrantyMonths — @Positive
    @NotBlank
    private String brand;
    @Positive
    private int warrantyMonths;

    // TODO: constructeur vide
    public ElectronicProductRequest() {
    }

    // TODO: getters + setters
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
