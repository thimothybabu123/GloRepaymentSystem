package com.app.glorepay.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "PrivateTransport")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PrivateTransport {

    /*
        task is to add a new column id of type Long.
        It should support the auto-generation of the primary key.
        Use appropriate annotation.
     */
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long privateTransportId;
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
    private Date date;
    /*
        task is to add a new column miles of type Integer.
        It should not be null.
        Use appropriate annotation.
     */
    @Column(name = "miles", nullable = false)
    private Integer miles;
    /*
        task is to add a new column amount of type Integer.
        It should not be null.
        Use appropriate annotation.
     */
    @Column(name = "amount", nullable = false)
    private Integer amount;

    /*
        task is to establish the mapping between Employee and PrivateTransport
        it should be an appropriate mapping as per the diagram

     */
    @ManyToOne()
    @JoinColumn(name = "employeeId")
    @Valid
    private Employee employee;
}
