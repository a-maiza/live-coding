package com.viveris.product.factory;

import com.viveris.product.enums.ProductType;
import com.viveris.product.services.ElectronicProductService;
import com.viveris.product.services.FoodProductService;
import com.viveris.product.services.TypedProductService;
import org.springframework.stereotype.Component;

// Factory — retourne le bon service selon le type de produit
// Le controller ne connaît pas les services spécialisés,
// il passe uniquement par cette factory
@Component
public class ProductServiceFactory {

    private final ElectronicProductService electronicProductService;
    private final FoodProductService foodProductService;

    public ProductServiceFactory(ElectronicProductService electronicProductService,
                                 FoodProductService foodProductService) {
        this.electronicProductService = electronicProductService;
        this.foodProductService = foodProductService;
    }

    /**
     * Retourne le service approprié selon le type de produit.
     *
     * @throws IllegalArgumentException si le type n'est pas supporté
     */
    public TypedProductService getService(ProductType type) {
        // TODO: retourner le bon service selon le type
        //   ELECTRONIC → electronicProductService
        //   FOOD       → foodProductService
        //   default    → throw new IllegalArgumentException("Type non supporté : " + type)
        return switch (type){
            case ELECTRONIC -> electronicProductService;
            case FOOD -> foodProductService;
        };
    }
}
