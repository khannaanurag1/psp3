package org.example.productservice3.Controllers;

import org.example.productservice3.Dtos.ProductDto;
import org.example.productservice3.Models.Product;
import org.example.productservice3.Services.IProductService;
import org.example.productservice3.Stubs.ProductServiceStub;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

//https://spring.io/blog/2007/01/15/unit-testing-with-stubs-and-mocks
@SpringBootTest
public class ProductControllerFlowTest {

    @Autowired
    ProductController productController;

    @Autowired
    //ProductServiceStub productServiceStub;
    IProductService productService;

    @Test
    public void Test_CreateAndFetchProduct_WorksSuccessfully() {
        //Arrange
        ProductDto productDto = new ProductDto();
        productDto.setId(1L);
        productDto.setTitle("ABC");
        productDto.setDescription("ABCDEF");

        //Arrange
        productController.createProduct(productDto);
        ResponseEntity<Product> productResponseEntity = productController.GetProduct(1L);
        productDto.setTitle("ABCD");
        productDto.setPrice(10000.00);
        productController.updateProduct(1L,productDto);
        ResponseEntity<Product> productResponseEntity2 = productController.GetProduct(1L);


        //Assert
        assertEquals("ABC",productResponseEntity.getBody().getTitle());
        assertEquals("ABCD",productResponseEntity2.getBody().getTitle());
        assertEquals(10000.0,productResponseEntity2.getBody().getPrice());
        assertEquals("ABCDEF",productResponseEntity.getBody().getDescription());
    }
}