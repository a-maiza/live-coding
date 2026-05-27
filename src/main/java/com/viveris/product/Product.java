package com.viveris.product;

public class Product {

    private final Long id;
    private final String name;
    private final double price;

    public Product(Long id, String name, double price) {
        if (name == null || name.isEmpty() || price <= 0) {
            throw new IllegalArgumentException();
        }
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
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
