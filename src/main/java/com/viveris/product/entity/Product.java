package com.viveris.product.entity;

import com.viveris.product.enums.ProductType;
import jakarta.persistence.*;

// Classe mère — contient les données communes à tous les types de produit
// JOINED = une table "products" + une table par sous-type
// SINGLE_TABLE = tout dans une seule table (plus simple mais moins propre)
@Entity
@Table(name = "products")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "product_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double price;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, updatable = false)
    private ProductType type;

    public Product() {}

    public Product(String name, double price, ProductType type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public ProductType getType() { return type; }
}
