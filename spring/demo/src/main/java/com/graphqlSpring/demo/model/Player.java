package com.graphqlSpring.demo.model;

import com.graphqlSpring.demo.model.Team;

public record Player(Integer id, String name, Team team){
    
}