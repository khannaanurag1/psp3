package org.example.productservice3.TableInheritaneExamples.JoinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(name="jt_instructor")
@PrimaryKeyJoinColumn(name="user_id")
public class Instructor extends User {
    private String company;
}
