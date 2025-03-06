package com.employee.demo.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name="Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private double salary;

}
