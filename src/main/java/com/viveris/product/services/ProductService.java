package com.viveris.product.services;

import com.viveris.product.model.Product;
import com.viveris.product.ProductRequest;
import com.viveris.product.exception.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ProductService {

    private Map<Long, Product> products = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);
    /**
     * Retourne tous les produits.
     */
    public List<Product> findAll() {
        return products.values().stream().toList();
    }

    /**
     * Retourne un produit par son id.
     *
     * @throws ProductNotFoundException si le produit n'existe pas
     */
    public Product findById(Long id) {
        Product product = products.get(id);
        if (product == null) {
            throw new ProductNotFoundException(id);
        }
        return product;
    }

    /**
     * Crée un nouveau produit à partir du DTO reçu.
     * L'id est auto-généré.
     */
    public Product create(ProductRequest request) {
        Long id = idCounter.getAndIncrement();
        Product product = new Product(id, request.getName(), request.getPrice());
        products.put(id, product);
        return product;
    }

    /**
     * Met à jour un produit existant.
     *
     * @throws ProductNotFoundException si le produit n'existe pas
     */
    public Product update(Long id, ProductRequest request) {
        Product product = findById(id);
        products.put(id, product);
        return product;
    }

    /**
     * Supprime un produit par son id.
     *
     * @throws ProductNotFoundException si le produit n'existe pas
     */
    public Product delete(Long id) {
        if (this.products.containsKey(id)) {
            return this.products.remove(id);
        }else {
            throw new ProductNotFoundException(id);
        }
    }
}
