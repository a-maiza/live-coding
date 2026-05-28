package com.viveris.product.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class ElectronicProductRequest extends ProductRequest {

    @NotBlank(message = "La marque est obligatoire")
    private String brand;

    @Positive(message = "La garantie doit être supérieure à 0 mois")
    private int warrantyMonths;

    public ElectronicProductRequest() {}

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    public int getWarrantyMonths() { return warrantyMonths; }
    public void setWarrantyMonths(int warrantyMonths) { this.warrantyMonths = warrantyMonths; }
}
