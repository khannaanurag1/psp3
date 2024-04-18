package org.example.productservice3.Repositories;

import org.example.productservice3.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
    Product save(Product product);

    Optional<Product> findProductById(Long id);

    List<Product> findProductByPriceBetween(double low,double high);

    List<Product> findByPrice(Double price);

    List<Product> findAllByIsSpecialTrue();
    List<Product> findAllByIsSpecialFalse();

    List<Product> findAllByIsSpecial(Boolean value);

    List<Product> findAllByOrderByIdDesc();

    List<Product> findAllByOrderByPriceDesc();

    List<Product> findByIdIsNotNullOrderByPrice();

    @Query("SELECT p.title FROM Product p WHERE p.id=?1")
    String getProductNameFromId(Long id);

    @Query("SELECT c.name FROM Product p join Category c on p.category.id=c.id where p.id=:id")
    String getCategoryNameFromProductId(@Param("id") Long id);
}
