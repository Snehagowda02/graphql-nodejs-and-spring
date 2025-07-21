package com.graphqlSpring.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.graphqlSpring.demo.entities.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {
    
}
