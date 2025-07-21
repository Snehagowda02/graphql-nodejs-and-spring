package com.graphqlSpring.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.graphqlSpring.demo.entities.Orders;

public interface OrderRepo extends JpaRepository<Orders, Integer> {
    
    
}
