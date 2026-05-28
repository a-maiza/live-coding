package com.viveris.product.dto;

import com.viveris.product.enums.ProductType;

// DTO de réponse de base — champs communs à tous les types
// Converti en classe (plus de record) pour permettre l'héritage
public class ProductResponse {

    private Long id;
    private String name;
    private double price;
    private ProductType type;

    public ProductResponse() {}

    public ProductResponse(Long id, String name, double price, ProductType type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public ProductType getType() { return type; }
}
