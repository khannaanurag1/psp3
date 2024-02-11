package org.example.productservice3.TableInheritaneExamples.TablePerClass;

import jakarta.persistence.Entity;

@Entity(name="tpc_mentor")
public class Mentor extends User {
    private int numberOfClasses;
}
