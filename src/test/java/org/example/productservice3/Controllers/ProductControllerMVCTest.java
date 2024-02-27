package org.example.productservice3.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.productservice3.Models.Product;
import org.example.productservice3.Services.IProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.ArrayList;
import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//TESTING FROM CLIENT PERSPECTIVE
@WebMvcTest(ProductController.class)
public class ProductControllerMVCTest {

    @Autowired
    private MockMvc mockMvc;

    //SHOW IT ONCE FIRST TESTCASE THROWS AN ERROR
    @MockBean
    private IProductService productService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getAllProducts() throws Exception {
        //mockMvc.perform(get("/products")).andExpect(status().isOk());

//        mockMvc.perform(get("/products"))
//                .andExpect(status().isOk())
//                .andExpect(content().string(""));

//        mockMvc.perform(get("/products"))
//                .andExpect(status().isOk())
//                .andExpect(content().string("[]"));

        List<Product> productList = new ArrayList<>();
        Product product = new Product();
        product.setTitle("Test2");
        productList.add(product);
        when(productService.getAllProducts()).thenReturn(productList);
//        mockMvc.perform(get("/products"))
//                .andExpect(status().isOk())
//                .andExpect(content().string("[]"));

        //Here 1 is a size of list received
        mockMvc.perform(get("/products"))
               .andExpect(status().isOk())
               .andExpect(content().string(objectMapper.writeValueAsString(productList)))
                .andExpect(jsonPath("$[0].title").value("Test2"))
                .andExpect(jsonPath("$.length()").value(1));
    }


    @Test
    public void createProduct() throws Exception {
        Product productToCreate = new Product();
        productToCreate.setTitle("IPhone15");
        productToCreate.setDescription("Most Powerful Iphone Ever");

        Product expectedProduct = new Product();
        expectedProduct.setId(1000L);
        expectedProduct.setDescription("Most Powerful Iphone Ever");
        expectedProduct.setTitle("IPhone15");

        when(productService.createProduct(any(Product.class))).thenReturn(expectedProduct);

        //Here 10 is number of total fields or attributes of Product class
        mockMvc.perform(post("/products")
                        .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(productToCreate)))
                .andExpect(status().isOk())
                .andExpect(content().string(objectMapper.writeValueAsString(expectedProduct)))
                .andExpect(jsonPath("$.title").value("IPhone15"))
                .andExpect(jsonPath("$.length()").value(10));

    }
}

