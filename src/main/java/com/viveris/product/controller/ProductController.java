package com.viveris.product.controller;

import com.viveris.product.dto.ProductRequest;
import com.viveris.product.dto.ProductResponse;
import com.viveris.product.enums.ProductType;
import com.viveris.product.factory.ProductServiceFactory;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    // Le controller ne connaît que la Factory — pas les services spécialisés
    private final ProductServiceFactory factory;

    public ProductController(ProductServiceFactory factory) {
        this.factory = factory;
    }

    // GET /api/products?type=ELECTRONIC
    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAll(@RequestParam ProductType type) {
        return ResponseEntity.ok(factory.getService(type).findAll());
    }

    // GET /api/products/{id}?type=ELECTRONIC
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getById(@PathVariable Long id,
                                                    @RequestParam ProductType type) {
        return ResponseEntity.ok(factory.getService(type).findById(id));
    }

    // POST /api/products
    // Le type est dans le body (ProductRequest.type)
    @PostMapping
    public ResponseEntity<ProductResponse> create(@Valid @RequestBody ProductRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(factory.getService(request.getType()).create(request));
    }

    // PUT /api/products/{id}
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> update(@PathVariable Long id,
                                                   @Valid @RequestBody ProductRequest request) {
        return ResponseEntity.ok(factory.getService(request.getType()).update(id, request));
    }

    // DELETE /api/products/{id}?type=ELECTRONIC
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id,
                                        @RequestParam ProductType type) {
        factory.getService(type).delete(id);
        return ResponseEntity.noContent().build();
    }
}
