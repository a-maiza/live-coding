package com.viveris.product;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.viveris.product.controller.ProductController;
import com.viveris.product.dto.ElectronicProductRequest;
import com.viveris.product.dto.ElectronicProductResponse;
import com.viveris.product.dto.FoodProductRequest;
import com.viveris.product.dto.FoodProductResponse;
import com.viveris.product.enums.ProductType;
import com.viveris.product.exception.ProductNotFoundException;
import com.viveris.product.factory.ProductServiceFactory;
import com.viveris.product.services.ElectronicProductService;
import com.viveris.product.services.FoodProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductServiceFactory factory;

    @MockBean
    private ElectronicProductService electronicProductService;

    @MockBean
    private FoodProductService foodProductService;

    private final ObjectMapper mapper = new ObjectMapper()
            .registerModule(new JavaTimeModule());

    // -------------------------------------------------------
    // GET /api/products?type=ELECTRONIC
    // -------------------------------------------------------
    @Test
    void getAll_electronics_should_return_200() throws Exception {
        ElectronicProductResponse response = new ElectronicProductResponse(
                1L, "TV Sony", 999.0, "Sony", 24);

        when(factory.getService(ProductType.ELECTRONIC)).thenReturn(electronicProductService);
        when(electronicProductService.findAll()).thenReturn(List.of(response));

        mockMvc.perform(get("/api/products").param("type", "ELECTRONIC"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("TV Sony"))
                .andExpect(jsonPath("$[0].brand").value("Sony"));
    }

    // -------------------------------------------------------
    // GET /api/products/{id}?type=FOOD → 404
    // -------------------------------------------------------
    @Test
    void getById_should_return_404_when_not_found() throws Exception {
        when(factory.getService(ProductType.FOOD)).thenReturn(foodProductService);
        when(foodProductService.findById(99L)).thenThrow(new ProductNotFoundException(99L));

        mockMvc.perform(get("/api/products/99").param("type", "FOOD"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.status").value(404))
                .andExpect(jsonPath("$.message").value("Product not found with id: 99"));
    }

    // -------------------------------------------------------
    // POST /api/products → 201 Created
    // -------------------------------------------------------
    @Test
    void create_electronic_should_return_201() throws Exception {
        ElectronicProductRequest request = new ElectronicProductRequest();
        request.setType(ProductType.ELECTRONIC);
        request.setName("TV Samsung");
        request.setPrice(799.0);
        request.setBrand("Samsung");
        request.setWarrantyMonths(12);

        ElectronicProductResponse response = new ElectronicProductResponse(
                1L, "TV Samsung", 799.0, "Samsung", 12);

        when(factory.getService(ProductType.ELECTRONIC)).thenReturn(electronicProductService);
        when(electronicProductService.create(any())).thenReturn(response);

        mockMvc.perform(post("/api/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.brand").value("Samsung"));
    }

    // -------------------------------------------------------
    // POST /api/products → 400 si champs invalides
    // -------------------------------------------------------
    @Test
    void create_should_return_400_when_name_is_blank() throws Exception {
        ElectronicProductRequest request = new ElectronicProductRequest();
        request.setType(ProductType.ELECTRONIC);
        request.setName("");
        request.setPrice(799.0);
        request.setBrand("Samsung");
        request.setWarrantyMonths(12);

        mockMvc.perform(post("/api/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }

    // -------------------------------------------------------
    // DELETE /api/products/{id}?type=FOOD → 204
    // -------------------------------------------------------
    @Test
    void delete_should_return_204() throws Exception {
        when(factory.getService(ProductType.FOOD)).thenReturn(foodProductService);

        mockMvc.perform(delete("/api/products/1").param("type", "FOOD"))
                .andExpect(status().isNoContent());
    }

    // -------------------------------------------------------
    // POST food product → 201
    // -------------------------------------------------------
    @Test
    void create_food_should_return_201() throws Exception {
        FoodProductRequest request = new FoodProductRequest();
        request.setType(ProductType.FOOD);
        request.setName("Lait bio");
        request.setPrice(1.5);
        request.setExpiryDate(LocalDate.now().plusMonths(3));
        request.setOrganic(true);

        FoodProductResponse response = new FoodProductResponse(
                1L, "Lait bio", 1.5,
                LocalDate.now().plusMonths(3), true);

        when(factory.getService(ProductType.FOOD)).thenReturn(foodProductService);
        when(foodProductService.create(any())).thenReturn(response);

        mockMvc.perform(post("/api/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Lait bio"))
                .andExpect(jsonPath("$.organic").value(true));
    }
}
