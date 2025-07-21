package com.graphqlSpring.demo.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
import java.util.ArrayList;

@Data
@Entity
@Table(name= "users")
public class Users {
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "userId")
    private Integer userId;

    private String name;

    private String email;

    private String phone;

    @OneToMany(mappedBy="user", cascade=CascadeType.ALL)
    //All is delete ,save ,update on all
    private List<Orders> orders = new ArrayList<>();


}
