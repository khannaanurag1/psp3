package org.example.productservice3.Controllers;

import org.example.productservice3.Models.Product;
import org.example.productservice3.Services.IProductService;
import org.example.productservice3.Stubs.ProductServiceStub;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class ProductControllerTest {

    @Autowired
    private ProductController productController;

    //@Autowired
    @MockBean
    private IProductService productService;

    @Captor
    private ArgumentCaptor<Long> idcaptor;

    @Test
    @DisplayName("getting product successfully")
    public void Test_GetProduct_ReturnProduct() {
        //Arrange
        Product product = new Product();
        product.setPrice(1000D);
        product.setTitle("Iphone15");

        when(productService.getProduct(any(Long.class))).thenReturn(product);

        //Act
        ResponseEntity<Product> productResponseEntity = productController.GetProduct(1L);

        //Assert
        assertNotNull(productResponseEntity);
        assertEquals(1000D,productResponseEntity.getBody().getPrice());
        assertEquals("Iphone15",productResponseEntity.getBody().getTitle());
        verify(productService,times(1)).getProduct(1L);
    }

    @Test
    @DisplayName("dependency threw an exception ")
    public void Test_GetProduct_InternalDependencyThrowsException() {
        //Arrange
        when(productService.getProduct(any(Long.class))).thenThrow(new RuntimeException("Something went very wrong"));

        //Act and Assert
        assertThrows(RuntimeException.class, ()-> productController.GetProduct(1L));
    }

    @Test
    @DisplayName("wrong id 0 lead to an exception")
    public void Test_GetProductWithInvalidId_ThrowsException() {
        assertThrows(IllegalArgumentException.class,()->productController.GetProduct(0L));
    }

    //First Run Test and show result
    //Second Debug by placing breakpoint
    //Third, increase the parameter value as +1 in controller and run this tc to show it fails
    @Test
    public void Test_ProductControllerCallsProductServiceWithSameId() {
        //Arrange
        Long id = 2L;

        //Act
        productController.GetProduct(id);

        //Assert
        verify(productService).getProduct(idcaptor.capture());
        assertEquals(id , idcaptor.getValue());
    }
}