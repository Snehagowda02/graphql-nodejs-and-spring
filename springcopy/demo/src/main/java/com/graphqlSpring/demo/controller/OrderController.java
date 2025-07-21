package com.graphqlSpring.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.graphqlSpring.demo.entities.Orders;
import com.graphqlSpring.demo.entities.Users;
import com.graphqlSpring.demo.service.OrderService;
import com.graphqlSpring.demo.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @MutationMapping
    public Orders createOrder(
        @Argument String orderDetails,
        @Argument String address,
        @Argument Float price,
        @Argument int userId){
            log.info("order controller");

            Optional<Users> optional = userService.getByUserId(userId);
            Users user = optional.get();
            Orders order = new Orders();
            order.setOrderDetails(orderDetails);
            order.setAddress(address);
            order.setPrice(price);
            order.setUser(user);
            return orderService.createOrder(order);
        }
    
        @QueryMapping
        public Orders getOrder(@Argument int id){
           Optional<Orders> op = orderService.getOrderById(id);
           Orders or = op.get();
           return or;

        }
    
}
