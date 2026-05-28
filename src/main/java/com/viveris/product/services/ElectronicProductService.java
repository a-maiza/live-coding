package com.viveris.product.services;

import com.viveris.product.dto.ElectronicProductRequest;
import com.viveris.product.dto.ElectronicProductResponse;
import com.viveris.product.dto.ProductRequest;
import com.viveris.product.dto.ProductResponse;
import com.viveris.product.entity.ElectronicProduct;
import com.viveris.product.exception.ProductNotFoundException;
import com.viveris.product.repository.ElectronicProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectronicProductService implements TypedProductService {

    private final ElectronicProductRepository repository;

    public ElectronicProductService(ElectronicProductRepository repository) {
        this.repository = repository;
    }

    // Mapping entity → DTO de réponse
    private ElectronicProductResponse toResponse(ElectronicProduct entity) {
        // TODO: construire et retourner un ElectronicProductResponse depuis l'entité
        return null;
    }

    @Override
    public ProductResponse create(ProductRequest request) {
        // TODO: caster request en ElectronicProductRequest
        //       construire une ElectronicProduct, sauvegarder, convertir
        return null;
    }

    @Override
    public ProductResponse update(Long id, ProductRequest request) {
        // TODO: récupérer l'entité, modifier les champs, sauvegarder, convertir
        return null;
    }

    @Override
    public void delete(Long id) {
        // TODO: vérifier l'existence, supprimer
    }

    @Override
    public List<ProductResponse> findAll() {
        // TODO: retourner tous les produits électroniques convertis en DTO
        return null;
    }

    @Override
    public ProductResponse findById(Long id) {
        // TODO: récupérer par id, lever ProductNotFoundException si absent
        return null;
    }

    private ElectronicProduct getEntityById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }
}
