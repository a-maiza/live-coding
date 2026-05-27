package com.viveris.product;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
        return ResponseEntity.ok(productService.findAll());
    }

    /**
     * GET /api/products/{id}
     * Retourne un produit par son id — HTTP 200 ou 404
     */
    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id) {
        Product product = productService.findById(id);
        if (product == null) {
            throw new ProductNotFoundException("the product dosn't exite", id);
        }
        return ResponseEntity.ok(product);
    }

    /**
     * POST /api/products
     * Crée un produit — HTTP 201 Created
     */
    @PostMapping
    public ResponseEntity<Product> create(@Valid @RequestBody ProductRequest request) {
        return ResponseEntity.ok(productService.create(request));
    }

    /**
     * PUT /api/products/{id}
     * Met à jour un produit — HTTP 200 ou 404
     */
    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id,
                                          @Valid @RequestBody ProductRequest request) {
        Product product = productService.findById(id);
        if (product == null) {
            throw new ProductNotFoundException("the product doesn't exite", id);
        }
        return ResponseEntity.ok(productService.update(id, request));
    }

    /**
     * DELETE /api/products/{id}
     * Supprime un produit — HTTP 204 No Content ou 404
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Product deleted = productService.delete(id);

        if (deleted == null) {
            throw new ProductNotFoundException("the product doesn't exite", id);
        }
        return ResponseEntity.noContent().build();
    }
}
