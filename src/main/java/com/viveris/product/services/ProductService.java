package com.viveris.product.services;

import com.viveris.product.dto.ProductRequest;
import com.viveris.product.exception.ProductNotFoundException;
import com.viveris.product.model.Product;
import com.viveris.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    // Plus de Map ni AtomicLong — la base de données gère tout
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Retourne tous les produits.
     */
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    /**
     * Retourne un produit par son id.
     *
     * @throws ProductNotFoundException si le produit n'existe pas
     */
    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    /**
     * Crée un nouveau produit.
     * L'id est généré automatiquement par la base.
     */
    public Product create(ProductRequest request) {
        Product product = new Product(request.getName(), request.getPrice());
        return productRepository.save(product);
    }

    /**
     * Met à jour un produit existant.
     *
     * @throws ProductNotFoundException si le produit n'existe pas
     */
    public Product update(Long id, ProductRequest request) {
        Product product = findById(id);
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        return productRepository.save(product);
    }

    /**
     * Supprime un produit par son id.
     *
     * @throws ProductNotFoundException si le produit n'existe pas
     */
    public void delete(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        productRepository.deleteById(id);
    }
}
