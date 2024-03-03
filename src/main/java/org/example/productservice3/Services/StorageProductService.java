package org.example.productservice3.Services;

import org.example.productservice3.Models.Category;
import org.example.productservice3.Models.Product;
import org.example.productservice3.Repositories.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StorageProductService implements IProductService {
    ProductRepo productRepo;

    public StorageProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }
    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product getProduct(Long id) {
       Optional<Product> optionalProduct = productRepo.findProductById(id);
        return  optionalProduct.get();
    }

    @Override
    public Product createProduct(Product product) {
        Product resultProduct = productRepo.save(product);
        return resultProduct;
    }

    @Override
    public Product updateProduct(Product product, Long productId) {
        return null;
    }

    @Override
    public String deleteProduct(Long id) {
        return null;
    }
}
