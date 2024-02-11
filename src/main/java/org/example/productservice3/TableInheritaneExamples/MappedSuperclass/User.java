package org.example.productservice3.TableInheritaneExamples.MappedSuperclass;

import jakarta.persistence.*;

@MappedSuperclass
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
}
