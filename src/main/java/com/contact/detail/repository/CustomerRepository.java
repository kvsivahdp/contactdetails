package com.contact.detail.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contact.detail.entity.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
