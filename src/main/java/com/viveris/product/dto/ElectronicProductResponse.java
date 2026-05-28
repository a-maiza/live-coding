package com.viveris.product.dto;

import com.viveris.product.enums.ProductType;

// DTO de réponse spécifique aux produits électroniques
public class ElectronicProductResponse extends ProductResponse {

    // TODO: attribut brand
    // TODO: attribut warrantyMonths
    private String brand;
    private int warrantyMonths;

    // TODO: constructeur vide
    public ElectronicProductResponse() {
    }

    // TODO: constructeur avec (id, name, price, brand, warrantyMonths)
    //       appeler super(id, name, price, ProductType.ELECTRONIC)
    public ElectronicProductResponse(Long id, String name, double price, ProductType type, String brand, int warrantyMonths) {
        super(id, name, price, type);
        this.brand = brand;
        this.warrantyMonths = warrantyMonths;
    }

    // TODO: getters

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
