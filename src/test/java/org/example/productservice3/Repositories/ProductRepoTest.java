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
        //subselect will do optimization here and call 2 select queries instead of
        //1 select and 1 subquery
        Category category = categoryRepo.findById(2L).get();
        List<Product> products = category.getProducts();
        for(Product product : products) {
            System.out.println(product.getId());
        }



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
        //In this case, using select we will see 5 queries in total (1+4),
        //So to avoid this, one solution is using @batchsize or using mode.subselect
        //in subselect, we will only see 2 queries instead of 5
        //in case of batchsize=2>4, we will see 4/2=2 + 1 = 3 queries
        //in case of batchsize=6>4, we will see 2 queries only
        //run this testcase with select , subselect , select+batchsize to show difference
        //https://hackernoon.com/3-ways-to-deal-with-hibernate-n1-problem
        //https://dheerajgopinath.medium.com/the-issue-with-fetchmode-subselect-and-onetomany-mappings-in-hibernate-and-jpa-f79724068897
        //https://itecnote.com/tecnote/hibernate-subselect-vs-batch-fetching/
        //https://www.baeldung.com/hibernate-fetchmode
        List<Category> cats = categoryRepo.findAll();
        for(Category category : cats) {
            List<Product> products = category.getProducts();
            if(products.size() > 0) {
                System.out.println(products.get(0).getPrice());
            }
//            for(Product product : products) {
//                System.out.println(product.getId());
//            }
        }
    }
}