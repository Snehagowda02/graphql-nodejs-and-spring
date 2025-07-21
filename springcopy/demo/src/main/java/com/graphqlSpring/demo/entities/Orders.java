package com.graphqlSpring.demo.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="orders")
public class Orders {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer orderId;
    private String address;
    private String orderDetails;
    private double price;

    @ManyToOne
    @JoinColumn(name= "user_id")
    private Users user;

}
