package org.example.productservice3.TableInheritaneExamples.JoinedTable;

import jakarta.persistence.*;

@Entity(name="jt_user")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
}
