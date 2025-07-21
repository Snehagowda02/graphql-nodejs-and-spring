package com.graphqlSpring.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graphqlSpring.demo.entities.Users;
import com.graphqlSpring.demo.repo.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    //creating user
    public Users createUser(Users user){
        return userRepo.save(user);
    }

    //getting all users

    public List<Users> getAllUsers(){
        return userRepo.findAll();
    }
    //get user by id
    public Optional<Users> getByUserId(Integer id){
        return userRepo.findById(id);

    }

    //updating user
    // public Users updateUser(Users user){
    //     return userRepo.
    // }
    //delete user
    public Boolean deleteUser(int id){
         userRepo.deleteById(id);
         return true;
    } 

    
}
