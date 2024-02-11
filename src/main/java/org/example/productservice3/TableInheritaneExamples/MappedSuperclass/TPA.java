package org.example.productservice3.TableInheritaneExamples.MappedSuperclass;

import jakarta.persistence.Entity;

@Entity(name="msc_tpa")
public class TPA extends User {
    private float rating;
}
