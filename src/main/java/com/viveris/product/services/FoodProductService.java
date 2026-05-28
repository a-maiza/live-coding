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

    private ProductResponse toResponse(FoodProduct entity) {
        return new FoodProductResponse(
                entity.getId(),
                entity.getName(),
                entity.getPrice(),
                entity.getExpiryDate(),
                entity.isOrganic()
        );
    }

    @Override
    public ProductResponse create(ProductRequest request) {
        FoodProductRequest fp = (FoodProductRequest) request;
        FoodProduct entity = new FoodProduct(
                fp.getName(),
                fp.getPrice(),
                fp.getExpiryDate(),
                fp.isOrganic()
        );
        return toResponse(repository.save(entity));
    }

    @Override
    public ProductResponse update(Long id, ProductRequest request) {
        FoodProduct entity = getEntityById(id);
        FoodProductRequest fp = (FoodProductRequest) request;
        entity.setName(fp.getName());
        entity.setPrice(fp.getPrice());
        entity.setExpiryDate(fp.getExpiryDate());
        entity.setOrganic(fp.isOrganic());
        return toResponse(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        getEntityById(id);
        repository.deleteById(id);
    }

    @Override
    public List<ProductResponse> findAll() {
        return repository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public ProductResponse findById(Long id) {
        return toResponse(getEntityById(id));
    }

    private FoodProduct getEntityById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }
}
