package org.example.productservice3.TableInheritaneExamples.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name="st_tpa")
@DiscriminatorValue(value = "1")
public class TPA extends User {
    private float rating;
}
