package com.sda.demospringboot.democrudapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String address;
    private String email;
    private String phone;

    // One-To-Many relationship with order entity
    @OneToMany(mappedBy = "customer")
    private List<Order> orders;
}
