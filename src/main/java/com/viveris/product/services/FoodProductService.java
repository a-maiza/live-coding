package com.viveris.product.services;

import com.viveris.product.dto.FoodProductRequest;
import com.viveris.product.dto.FoodProductResponse;
import com.viveris.product.dto.ProductRequest;
import com.viveris.product.dto.ProductResponse;
import com.viveris.product.entity.FoodProduct;
import com.viveris.product.exception.ProductNotFoundException;
import com.viveris.product.repository.FoodProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodProductService implements TypedProductService {

    private final FoodProductRepository repository;

    public FoodProductService(FoodProductRepository repository) {
        this.repository = repository;
    }

    private FoodProductResponse toResponse(FoodProduct entity) {
        // TODO: construire et retourner un FoodProductResponse depuis l'entité
        return new FoodProductResponse(entity.getId(), entity.getName(), entity.getPrice(), entity.getType(), entity.getExpiryDate(), entity.isOrganic());
    }

    @Override
    public ProductResponse create(ProductRequest request) {
        // TODO: caster request en FoodProductRequest
        //       construire une FoodProduct, sauvegarder, convertir
        FoodProductRequest fp = (FoodProductRequest)  request;
        FoodProduct foodProduct = new FoodProduct(fp.getName(),fp.getPrice(), fp.getType(), fp.getExpiryDate(), fp.getOrganic());
        return toResponse(repository.save(foodProduct));
    }

    @Override
    public ProductResponse update(Long id, ProductRequest request) {
        // TODO: récupérer l'entité, modifier les champs, sauvegarder, convertir
        FoodProduct updated = getEntityById(id);
        FoodProductRequest fp = (FoodProductRequest)  request;
        updated.setName(fp.getName());
        updated.setPrice(fp.getPrice());
        updated.setExpiryDate(fp.getExpiryDate());
        updated.setOrganic(fp.getOrganic());
        return toResponse(repository.save(updated));
    }

    @Override
    public void delete(Long id) {
        // TODO: vérifier l'existence, supprimer
        FoodProduct entity = getEntityById(id);
        repository.delete(entity);
    }

    @Override
    public List<ProductResponse> findAll() {
        // TODO: retourner tous les produits alimentaires convertis en DTO
        return repository.findAll().stream().map(foodProduct -> toResponse(foodProduct)).toList();
    }

    @Override
    public ProductResponse findById(Long id) {
        // TODO: récupérer par id, lever ProductNotFoundException si absent
        return null;
    }

    private FoodProduct getEntityById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }
}
