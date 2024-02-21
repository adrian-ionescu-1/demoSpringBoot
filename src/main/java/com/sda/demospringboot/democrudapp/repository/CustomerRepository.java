package com.sda.demospringboot.democrudapp.repository;

import com.sda.demospringboot.democrudapp.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
