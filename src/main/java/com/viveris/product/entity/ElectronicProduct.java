package com.viveris.product.entity;

import com.viveris.product.enums.ProductType;
import jakarta.persistence.*;

@Entity
@Table(name = "electronic_products")
@DiscriminatorValue("ELECTRONIC")
public class ElectronicProduct extends Product {

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private int warrantyMonths;

    public ElectronicProduct() {}

    public ElectronicProduct(String name, double price, String brand, int warrantyMonths) {
        super(name, price, ProductType.ELECTRONIC);
        this.brand = brand;
        this.warrantyMonths = warrantyMonths;
    }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    public int getWarrantyMonths() { return warrantyMonths; }
    public void setWarrantyMonths(int warrantyMonths) { this.warrantyMonths = warrantyMonths; }
}
