package com.graphqlSpring.demo.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.graphqlSpring.demo.entities.Users;
import com.graphqlSpring.demo.service.UserService;



@Controller
public class UserController{

    @Autowired
    private UserService userService;

    // @SchemaMapping(typeName="Mutation", field="createUser")
    @MutationMapping("createUser")
    public Users createUser(@Argument String name, @Argument String email, @Argument String phone){
        Users user = new Users();
        user.setName(name);
        user.setEmail(email);
        user.setPhone(phone);
        return userService.createUser(user);
        // shift plus alt user
    }

    @QueryMapping("getAllusers")
    public List<Users> getALlusers(){
       return userService.getAllUsers();
    }

    @QueryMapping("getUser")
    public Users getuser(@Argument int id){
        Optional<Users> user =  userService.getByUserId(id);
        return user.get();
    }

    @MutationMapping
    public Boolean deleteUser(@Argument int id){
        return userService.deleteUser(id);
    }
}