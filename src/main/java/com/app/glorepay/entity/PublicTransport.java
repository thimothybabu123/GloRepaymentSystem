package com.app.glorepay.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "PublicTransport")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PublicTransport {

    /*
        task is to add a new column id of type Long.
        It should support the auto-generation of the primary key.
        Use appropriate annotation.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long publicTransportId;
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
    @Column(name = "amount", nullable = false)
    private Integer amount;

    /*
        task is to establish the mapping between Employee and PublicTransport
        it should be a appropriate mapping as per the diagram
     */
    @ManyToOne()
    @JoinColumn(name = "employeeId")
    @Valid
    private Employee employee;

}
