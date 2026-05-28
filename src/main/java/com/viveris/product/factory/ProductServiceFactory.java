package com.viveris.product.factory;

import com.viveris.product.enums.ProductType;
import com.viveris.product.services.ElectronicProductService;
import com.viveris.product.services.FoodProductService;
import com.viveris.product.services.TypedProductService;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceFactory {

    private final ElectronicProductService electronicProductService;
    private final FoodProductService foodProductService;

    public ProductServiceFactory(ElectronicProductService electronicProductService,
                                 FoodProductService foodProductService) {
        this.electronicProductService = electronicProductService;
        this.foodProductService = foodProductService;
    }

    public TypedProductService getService(ProductType type) {
        return switch (type) {
            case ELECTRONIC -> electronicProductService;
            case FOOD       -> foodProductService;
        };
    }
}
