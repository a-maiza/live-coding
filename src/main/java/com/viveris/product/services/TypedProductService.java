package com.viveris.product.services;

import com.viveris.product.dto.ProductRequest;
import com.viveris.product.dto.ProductResponse;

import java.util.List;

// Interface commune à tous les services spécialisés
// Permet à la Factory de retourner n'importe quel service via ce contrat
public interface TypedProductService {

    ProductResponse create(ProductRequest request);
    ProductResponse update(Long id, ProductRequest request);
    void delete(Long id);
    List<ProductResponse> findAll();
    ProductResponse findById(Long id);
}
