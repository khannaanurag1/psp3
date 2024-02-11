package org.example.productservice3.TableInheritaneExamples.MappedSuperclass;

import jakarta.persistence.Entity;

@Entity(name="msc_instructor")
public class Instructor extends User {
    private String company;
}
