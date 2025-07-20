package com.graphqlSpring.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.graphqlSpring.demo.model.Player;
import com.graphqlSpring.demo.model.Team;
import com.graphqlSpring.demo.service.PlayerService;


@Controller
public class PlayerController {
    
    // private final PlayerService playerService;

    // public PlayerController(PlayerService playerService){
    //     this.playerService = playerService;
    // }

    @Autowired
    private  PlayerService playerService;


    @QueryMapping
    //findAll below should exactly same as findAll in type Query{}
    public List<Player> findAll(){
        return playerService.findAll();
    }

    @QueryMapping
    public Player findOne(@Argument Integer id){
        Optional<Player> pla = playerService.findOne(id);
        Player p =pla.get();
        return p;
    }

    @MutationMapping
    public Player create(@Argument String name, @Argument Team team){
        return playerService.create(name, team);
    }

    @MutationMapping
    public Player update(@Argument Integer id, @Argument String name, @Argument Team team){
        return playerService.update(id, name, team);
    }


    @MutationMapping
    public Player delete(@Argument Integer id){
        return playerService.delete(id);

    }



    
}
