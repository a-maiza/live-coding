package com.viveris.product.repository;

import com.viveris.product.entity.FoodProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface FoodProductRepository extends JpaRepository<FoodProduct, Long> {

    // TODO (bonus): trouver les produits expirés
    List<FoodProduct> findByExpiryDateBefore(LocalDate date);
}
