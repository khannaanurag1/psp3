package org.example.productservice3.Clients.FakeStore.Dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class FakeStoreClientProductDto {
    private Long id;
    private String title;
    private String description;
    private String image;
    //private RatingDto rating;
    private Double price;
    private String category;
}
