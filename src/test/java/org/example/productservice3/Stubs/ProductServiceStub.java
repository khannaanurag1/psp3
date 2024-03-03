package org.example.productservice3.Stubs;

import org.example.productservice3.Models.Product;
import org.example.productservice3.Services.IProductService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Service
public class ProductServiceStub implements IProductService {
    Map<Long,Product> products;

    public ProductServiceStub() {
        products = new HashMap<Long,Product>();
    }
    @Override
    public List<Product> getAllProducts() {
       List<Product> prds = (List)products.values();
       return prds;
    }

    @Override
    public Product getProduct(Long id) {
        return products.get(id);
    }

    @Override
    public Product createProduct(Product product) {
        products.put(product.getId(),product);
        return products.get(product.getId());
    }

    @Override
    public Product updateProduct(Product product, Long productId) {
        products.put(productId,product);
        return products.get(productId);
    }

    @Override
    public String deleteProduct(Long id) {
        return null;
    }
}
