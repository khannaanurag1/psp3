package org.example.productservice3.TableInheritaneExamples.TablePerClass;

import jakarta.persistence.Entity;

@Entity(name="tpc_tpa")
public class TPA extends User {
    private float rating;
}
