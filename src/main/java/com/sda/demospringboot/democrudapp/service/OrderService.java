package com.sda.demospringboot.democrudapp.service;

import com.sda.demospringboot.democrudapp.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Optional<Order> getOrderById(Long id);
    List<Order> getAllOrders();
    Order saveOrder(Order order);
    Order updateOrder(Order order);
    void deleteOrderById(Long id);
}
