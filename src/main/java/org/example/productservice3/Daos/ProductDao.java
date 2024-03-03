package org.example.productservice3.Daos;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.example.productservice3.Models.Category;
import org.example.productservice3.Models.Status;

import java.util.Date;

@Getter
@Setter
public class ProductDao {
    private Long id;
    private Date createdAt;
    private Date lastUpdatedAt;
    private Status status;
    private String title;
    private String description;
    private String imageUrl;
    private Double price;
    private Long categoryId;
    private Boolean isSpecial;
}
