package com.viveris.product.services;

import com.viveris.product.dto.ProductRequest;
import com.viveris.product.dto.ProductResponse;
import com.viveris.product.entity.Product;
import com.viveris.product.exception.ProductNotFoundException;
import com.viveris.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // -------------------------------------------------------
    // Mapping : Entity → DTO de réponse
    // Le service est le seul responsable de cette conversion
    // -------------------------------------------------------
    private ProductResponse toResponse(Product product) {
        // TODO: construire et retourner un ProductResponse depuis l'entité Product
        return new ProductResponse(product.getId(), product.getName(), product.getPrice());
    }

    /**
     * Retourne tous les produits sous forme de DTO.
     */
    public List<ProductResponse> findAll() {
        return productRepository.findAll().stream().map(this::toResponse).toList();
    }

    /**
     * Retourne un produit par son id sous forme de DTO.
     *
     * @throws ProductNotFoundException si le produit n'existe pas
     */
    public ProductResponse findById(Long id) {
        Product product = getEntityById(id);
        return toResponse(product);
    }

    /**
     * Crée un nouveau produit et retourne le DTO.
     */
    public ProductResponse create(ProductRequest request) {
        Product product = new Product(request.getName(), request.getPrice());
        return toResponse(productRepository.save(product));
    }

    /**
     * Met à jour un produit existant et retourne le DTO.
     *
     * @throws ProductNotFoundException si le produit n'existe pas
     */
    public ProductResponse update(Long id, ProductRequest request) {
        Product updated = getEntityById(id);
        updated.setName(request.getName());
        updated.setPrice(request.getPrice());
        return toResponse(productRepository.save(updated));
    }

    /**
     * Supprime un produit par son id.
     *
     * @throws ProductNotFoundException si le produit n'existe pas
     */
    public void delete(Long id) {
        getEntityById(id);
        productRepository.deleteById(id);
    }

    // -------------------------------------------------------
    // Usage interne uniquement : retourne l'entité brute
    // -------------------------------------------------------
    private Product getEntityById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }
}
