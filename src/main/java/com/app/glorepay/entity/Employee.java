package com.app.glorepay.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import java.util.List;

/*
    task is to add the required annotation to make this class a JPA entity
 */

@Entity
@Table(name = "Employee")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    /*
        task is to add a new column id of type Long.
        It should support the auto-generation of the primary key.
        Use appropriate annotation.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    /*
        task is to add a new column name of type String.
        It should not be null.
        Use appropriate annotation.
     */
    @Column(name = "name", nullable = false)
    private String name;
    /*
        task is to add a new column email of type String.
        It should not be null.
        It should be unique.
        Use appropriate annotation.
     */
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    private final Integer maxLimit = 5000;

    /*
        task is to establish the mapping between Employee and PublicTransport
        it should be a appropriate mapping as per the diagram
     */
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @Valid
    private List<PublicTransport> publicTransport;

    /*
        task is to establish the mapping between Employee and PrivateTransport
        it should be a appropriate mapping as per the diagram
     */
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @Valid
    private List<PrivateTransport> privateTransport;

    /*
        task is to establish the mapping between Employee and Food
        it should be a appropriate mapping as per the diagram
     */
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @Valid
    private List<Food> food;
}
