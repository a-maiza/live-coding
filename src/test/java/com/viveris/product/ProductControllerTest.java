package com.viveris.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Test
    void getAll_should_return_200() throws Exception {
        // TODO
    }

    @Test
    void getById_should_return_404_when_not_found() throws Exception {
        // TODO: simuler ProductNotFoundException avec Mockito
        // mockMvc.perform(get("/api/products/99"))
        //        .andExpect(status().isNotFound());
    }

    @Test
    void create_should_return_201() throws Exception {
        // TODO
    }

    @Test
    void create_should_return_400_when_name_is_blank() throws Exception {
        // TODO: envoyer un JSON avec name vide et vérifier HTTP 400
    }

    @Test
    void delete_should_return_204() throws Exception {
        // TODO
    }
}
