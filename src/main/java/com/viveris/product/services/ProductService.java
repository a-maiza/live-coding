package com.viveris.product.services;

import com.viveris.product.dto.ProductResponse;
import com.viveris.product.entity.Product;
import com.viveris.product.exception.ProductNotFoundException;
import com.viveris.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// Service transversal — requêtes cross-type (tous les produits, peu importe le type)
// Les opérations d'écriture (create/update) sont déléguées aux services spécialisés
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    private ProductResponse toResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getType()
        );
    }

    /**
     * Retourne TOUS les produits (tous types confondus) sous forme de DTO de base.
     */
    public List<ProductResponse> findAll() {
        return productRepository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    /**
     * Retourne un produit par son id (tous types).
     */
    public ProductResponse findById(Long id) {
        return toResponse(
                productRepository.findById(id)
                        .orElseThrow(() -> new ProductNotFoundException(id))
        );
    }
}
