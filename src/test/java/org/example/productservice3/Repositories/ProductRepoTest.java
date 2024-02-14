package org.example.productservice3.Repositories;

import jakarta.transaction.Transactional;
import org.example.productservice3.Models.Category;
import org.example.productservice3.Models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepoTest {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Test
    @Transactional
    @Rollback(value = false)
    void saveProductAndCategory() {
        Category category = new Category();
        category.setName("Electronics");
        categoryRepo.save(category);


        Product product = new Product();
        product.setTitle("Laptop");
        product.setCategory(category);
        productRepo.save(product);
        List<Product> l = new ArrayList<>();
        l.add(product);
        category.setProducts(l);
        
        Category category1 = categoryRepo.findById(category.getId()).get();
        //Product product1 = productRepo.findById(product.getId()).get();
        System.out.println("debug");
    }


    @Test
    @Transactional
    @Rollback(value = false)
    void saveProductAndCategoryForFetchMode() {
        Category category = categoryRepo.findById(2L).get();
//        List<Product> products = category.getProducts();
//        for(Product product : products) {
//            System.out.println(product.getId());
//        }



//        Product product = new Product();
//        product.setTitle("Laptop");
//        product.setPrice(103222.99);
//        product.setCategory(category);
//        Product product1 = productRepo.save(product);
//
//        product = new Product();
//        product.setTitle("Machine");
//        product.setPrice(231.345);
//        product.setCategory(category);
//        Product product2 = productRepo.save(product);
//
//        product = new Product();
//        product.setTitle("Machine22");
//        product.setPrice(231.345);
//        product.setCategory(category);
//        Product product3 = productRepo.save(product);

    }


    @Test
    @Transactional
    @Rollback(value = false)
    void saveProductAndCategoryForNPlusOne() {
        //5 QUERIES RAN
        List<Category> cats = categoryRepo.findAll();
        for(Category category : cats) {
            List<Product> products = category.getProducts();
            //if(products.size() > 0) {
            //    products.get(0).getPrice();
            //}
            for(Product product : products) {
                System.out.println(product.getId());
            }
        }
    }
}