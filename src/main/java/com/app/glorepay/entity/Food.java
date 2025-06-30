package com.app.glorepay.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Food")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Food {

    /*
        task is to add a new column id of type Long.
        It should support the auto-generation of the primary key.
        Use appropriate annotation.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long foodId;
    /*
        task is to add a new column type of type String.
        It should not be null.
        Use appropriate annotation.
     */
    @Column(name = "type", nullable = false)
    private String type;
    /*
        task is to add a new column date of type Date.
        It should not be null.
        Use appropriate annotation.
     */
    @Column(name = "date", nullable = false)
    private LocalDate date;
    /*
        task is to add a new column amount of type Integer.
        It should not be null.
        Use appropriate annotation.
     */
    @Column(name = "amount", nullable = false)
    private Integer amount;

    /*
        task is to establish the mapping between Employee and Food
        it should be a appropriate mapping as per the diagram
     */
    @ManyToOne()
    @JoinColumn(name = "employeeId")
    @Valid
    private Employee employee;

}
