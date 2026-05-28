package com.viveris.product.dto;

import com.viveris.product.enums.ProductType;

public class ElectronicProductResponse extends ProductResponse {

    private String brand;
    private int warrantyMonths;

    public ElectronicProductResponse() {}

    public ElectronicProductResponse(Long id, String name, double price,
                                     String brand, int warrantyMonths) {
        super(id, name, price, ProductType.ELECTRONIC);
        this.brand = brand;
        this.warrantyMonths = warrantyMonths;
    }

    public String getBrand() { return brand; }
    public int getWarrantyMonths() { return warrantyMonths; }
}
