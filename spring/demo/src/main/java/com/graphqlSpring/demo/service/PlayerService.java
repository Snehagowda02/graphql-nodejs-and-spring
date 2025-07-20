package com.graphqlSpring.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.graphqlSpring.demo.model.Player;
import com.graphqlSpring.demo.model.Team;

import jakarta.annotation.PostConstruct;

@Service
public class PlayerService {


    public List<Player> players = new ArrayList<>();

    AtomicInteger id = new AtomicInteger(0); // helps to generate ids
    
    public List<Player> findAll(){
        return players; 
    }

    public Optional<Player> findOne(Integer id){
        return players.stream()
        .filter(player -> player.id().equals(id)).findFirst(); //findfirst() returns optional
        // returns optional.empty()  if none matched to ID
    }

    public Player create(String name,Team team ){ 
        Player player = new Player(id.incrementAndGet(), name, team);
        players.add(player);
        return player;
    }

    public Player delete(Integer id){
        Player player= players.stream().
            filter(p -> p.id()== id).findFirst().
            orElseThrow(() -> new IllegalArgumentException());
        // Player player = players.get(id);
        players.remove(player);
        return player;
    }

    public Player update(Integer id, String name, Team team){
        Player updatedPlayer = new Player(id, name, team);
        // Player oldPlayer = players.stream()
        //     .filter(p -> p.Id() == id).findFirst()
        //     .orElseThrow(() -> new IllegalArgumentException());
        // if(oldPlayer !=null){
        //     int index= players.indexOf(oldPlayer);
        //     players.set(index, updatedPlayer);
        // } else{
        //     throw  new IllegalArgumentException("Invalid player");

        // }

        Optional<Player> optional = players.stream().filter(p-> Objects.equals(p.id(), id)).findFirst();
        if(optional.isPresent()){ // isPresent() is a method in java.util.Optional
            Player oldplayer = optional.get();
            int index = players.indexOf(oldplayer);
            players.set(index, updatedPlayer);

        } else{
            throw new IllegalArgumentException("Invalid Player");
        }
        return updatedPlayer;
    }
    
    @PostConstruct
    private void init(){
        players.add(new Player(id.incrementAndGet(), "kohli", Team.RCB));
        players.add(new Player(id.incrementAndGet(), "dhoni", Team.CSK));
        players.add(new Player(id.incrementAndGet(), "Rohit", Team.MI));

    }

 

}
