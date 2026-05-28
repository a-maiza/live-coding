package com.viveris.product.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class FoodProductRequest extends ProductRequest {

    @NotNull(message = "La date d'expiration est obligatoire")
    @Future(message = "La date d'expiration doit être dans le futur")
    private LocalDate expiryDate;

    private boolean organic;

    public FoodProductRequest() {}

    public LocalDate getExpiryDate() { return expiryDate; }
    public void setExpiryDate(LocalDate expiryDate) { this.expiryDate = expiryDate; }
    public boolean isOrganic() { return organic; }
    public void setOrganic(boolean organic) { this.organic = organic; }
}
