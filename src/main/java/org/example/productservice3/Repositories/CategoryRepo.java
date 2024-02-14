package org.example.productservice3.Repositories;

import org.example.productservice3.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Long> {

}
