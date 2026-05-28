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

    private ProductResponse toResponse(ElectronicProduct entity) {
        return new ElectronicProductResponse(
                entity.getId(),
                entity.getName(),
                entity.getPrice(),
                entity.getBrand(),
                entity.getWarrantyMonths()
        );
    }

    @Override
    public ProductResponse create(ProductRequest request) {
        ElectronicProductRequest ep = (ElectronicProductRequest) request;
        ElectronicProduct entity = new ElectronicProduct(
                ep.getName(),
                ep.getPrice(),
                ep.getBrand(),
                ep.getWarrantyMonths()
        );
        return toResponse(repository.save(entity));
    }

    @Override
    public ProductResponse update(Long id, ProductRequest request) {
        ElectronicProduct entity = getEntityById(id);
        ElectronicProductRequest ep = (ElectronicProductRequest) request;
        entity.setName(ep.getName());
        entity.setPrice(ep.getPrice());
        entity.setBrand(ep.getBrand());
        entity.setWarrantyMonths(ep.getWarrantyMonths());
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

    private ElectronicProduct getEntityById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }
}
