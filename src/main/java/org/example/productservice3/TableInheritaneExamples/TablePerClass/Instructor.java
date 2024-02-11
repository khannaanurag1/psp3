package org.example.productservice3.TableInheritaneExamples.TablePerClass;

import jakarta.persistence.Entity;

@Entity(name="tpc_instructor")
public class Instructor extends User {
    private String company;
}
