package com.graphqlSpring.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graphqlSpring.demo.entities.Orders;
import com.graphqlSpring.demo.repo.OrderRepo;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    //create
    public Orders createOrder(Orders order){
       return orderRepo.save(order);
    }
    //getAll
    public List<Orders> getAllOrders(){
        return orderRepo.findAll();
    }
    //getbyId
    public Optional<Orders> getOrderById(int id){
        return orderRepo.findById(id);
    }
    //delete
    public boolean delteorder(int id){
        Orders order =  orderRepo.findById(id).orElseThrow(() -> new RuntimeException("order is not found"));
        orderRepo.delete(order);
        return true;
    }


    
}
