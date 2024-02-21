package com.sda.demospringboot.democrudapp.controller;

import com.sda.demospringboot.democrudapp.exception.ResourceNotFoundException;
import com.sda.demospringboot.democrudapp.model.Order;
import com.sda.demospringboot.democrudapp.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/orders") // http://localhost:8080/api/orders
public class OrderController {
    private final OrderService orderService;

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @GetMapping("/getAllOrders")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orderList = orderService.getAllOrders();
        if (orderList.isEmpty()) {
            throw new ResourceNotFoundException("No orders found in DB");
        }
        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }

    @GetMapping("/ordersById/{id}")
    public ResponseEntity<Optional<Order>> getOrderById(@PathVariable Long id) {
        Optional<Order> orderById = orderService.getOrderById(id);
        orderById.orElseThrow(()-> new ResourceNotFoundException("Order with id: " + id + " doesn't exist in DB"));
        return new ResponseEntity<>(orderService.getOrderById(id), HttpStatus.OK);
    }

    @PostMapping("/addNewOrder")
    public ResponseEntity<Order> saveOrder(@RequestBody Order order) {
        Order newOrder = orderService.saveOrder(order);
        return new ResponseEntity<>(newOrder, HttpStatus.OK);
    }

    @PutMapping("/updateOrder")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order) {
        return new ResponseEntity<>(orderService.updateOrder(order), HttpStatus.OK);
    }

    @DeleteMapping("/deleteOrder/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id) {
        Optional<Order> orderOptional = orderService.getOrderById(id);
        orderOptional.orElseThrow(()-> new ResourceNotFoundException("Order with id: " + id + " doesn't exist in DB"));
        orderService.deleteOrderById(id);
        return new ResponseEntity<>("Order with id: " + id + " delete successfully", HttpStatus.OK);
    }
}
