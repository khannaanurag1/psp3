package org.example.productservice3.Controllers;

import org.example.productservice3.Models.Product;
import org.example.productservice3.Services.IProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {

    //@Autowired
    @MockBean
    private IProductService productService;

    @Autowired
    private ProductController productController;

    @Test
    public void Test_GetProduct_ReturnProduct() {
        //Arrange
        //when(productService.getProduct()).thenReturn(new Product());
        //when(productService.getProduct(any(Long.class))).thenReturn(new Product());

        Product product = new Product();
        product.setTitle("Test Product");
        product.setDescription("Product created for testing purpose");
        when(productService.getProduct(any(Long.class))).thenReturn(product);


        //Act
        ResponseEntity<Product> productResponseEntity =  productController.GetProduct(1L);

        //Assert
        assertNotNull(productResponseEntity);
        assertEquals("Test Product",productResponseEntity.getBody().getTitle());
    }

    @Test
    public void Test_GetProduct_InternalDependencyThrowsException() {
        //Arrange
        when(productService.getProduct(any(Long.class))).thenThrow(new RuntimeException("Something is wrong"));

        //Act
        //ResponseEntity<Product> productResponseEntity =  productController.GetProduct(1L);
        //Assert
        //assertNotNull(productResponseEntity);
        assertThrows(RuntimeException.class,()-> productController.GetProduct(1L));
    }

    @Test
    public void Test_GetProductWithInvalidId_ThrowsException() {
        //Assert
        assertThrows(IllegalArgumentException.class, () -> productController.GetProduct(0L));
    }
}