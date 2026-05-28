package com.viveris.product.dto;

import com.viveris.product.enums.ProductType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

// DTO de base — contient les champs communs à tous les types
// Les sous-classes ajoutent les champs spécifiques
public class ProductRequest {

    @NotNull(message = "Le type du produit est obligatoire (ELECTRONIC, FOOD)")
    private ProductType type;

    @NotBlank(message = "Le nom du produit est obligatoire")
    private String name;

    @Positive(message = "Le prix du produit doit être supérieur à 0")
    private double price;

    public ProductRequest() {}

    public ProductType getType() { return type; }
    public void setType(ProductType type) { this.type = type; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}
