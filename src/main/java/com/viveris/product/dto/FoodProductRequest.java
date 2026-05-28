package com.viveris.product.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

// DTO spécifique aux produits alimentaires
// Hérite de ProductRequest (name, price, type)
public class FoodProductRequest extends ProductRequest {

    // TODO: attribut expiryDate — @NotNull + @Future (la date doit être dans le futur)
    // TODO: attribut organic — booléen (pas de validation obligatoire)
    @NotNull
    @Future
    private LocalDate expiryDate;

    private Boolean organic;

    // TODO: constructeur vide
    public FoodProductRequest() {
    }

    // TODO: getters + setters

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Boolean getOrganic() {
        return organic;
    }

    public void setOrganic(Boolean organic) {
        this.organic = organic;
    }
}
