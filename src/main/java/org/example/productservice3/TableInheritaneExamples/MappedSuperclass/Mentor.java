package org.example.productservice3.TableInheritaneExamples.MappedSuperclass;

import jakarta.persistence.Entity;

@Entity(name="msc_mentor")
public class Mentor extends User {
    private int numberOfClasses;
}
