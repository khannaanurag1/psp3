package org.example.productservice3.TableInheritaneExamples.JoinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(name="jt_tpa")
@PrimaryKeyJoinColumn(name="user_id")
public class TPA extends User {
    private float rating;
}
