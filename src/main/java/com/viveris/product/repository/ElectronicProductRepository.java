package com.viveris.product.repository;

import com.viveris.product.entity.ElectronicProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ElectronicProductRepository extends JpaRepository<ElectronicProduct, Long> {

    // TODO (bonus): ajouter une méthode pour rechercher par marque
    List<ElectronicProduct> findByBrandIgnoreCase(String brand);
}
