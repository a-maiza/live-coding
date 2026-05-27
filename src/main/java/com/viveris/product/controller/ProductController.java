package com.viveris.product.controller;

import com.viveris.product.ProductRequest;
import com.viveris.product.exception.ProductNotFoundException;
import com.viveris.product.model.Product;
import com.viveris.product.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * GET /api/products
     * Retourne la liste de tous les produits — HTTP 200
     */
    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity
                .ok(productService.findAll());
    }

    /**
     * GET /api/products/{id}
     * Retourne un produit par son id — HTTP 200 ou 404
     */
    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id) {
        return ResponseEntity
                .ok(productService.findById(id));
    }

    /**
     * POST /api/products
     * Crée un produit — HTTP 201 Created
     */
    @PostMapping
    public ResponseEntity<Product> create(@Valid @RequestBody ProductRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productService.create(request));
    }

    /**
     * PUT /api/products/{id}
     * Met à jour un produit — HTTP 200 ou 404
     */
    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id,
                                          @Valid @RequestBody ProductRequest request) {
        return ResponseEntity
                .ok(productService.update(id, request));
    }

    /**
     * DELETE /api/products/{id}
     * Supprime un produit — HTTP 204 No Content ou 404
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
