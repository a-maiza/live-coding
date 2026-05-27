package com.viveris.product.dto;

// DTO de réponse : ce que l'API expose au client
// Ne contient que ce que le client a le droit de voir
// Aucune annotation JPA — complètement découplé de la base de données
public class ProductResponse {

    private final Long id;
    private final String name;
    private final double price;

    public ProductResponse(Long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "ProductResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
