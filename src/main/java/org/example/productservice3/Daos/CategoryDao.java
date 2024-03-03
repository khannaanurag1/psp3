package org.example.productservice3.Daos;

import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.example.productservice3.Models.Product;
import org.example.productservice3.Models.Status;

import java.util.Date;
import java.util.List;

@Setter
@Getter
public class CategoryDao {
    private Long id;
    private Date createdAt;
    private Date lastUpdatedAt;
    private Status status;
    private String name;
    private String description;
}
