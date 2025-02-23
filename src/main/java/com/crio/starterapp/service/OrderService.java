package com.crio.starterapp.service;

import com.crio.starterapp.entities.Order;
import com.crio.starterapp.exception.ResourceNotFoundException;
import com.crio.starterapp.repository.OrderRepository;

import java.util.List;

public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id " + id));
    }

    public Order updateOrder(Long id, Order updatedOrder) {
        Order existingOrder = getOrderById(id);

        existingOrder.setOrderDate(updatedOrder.getOrderDate());
        existingOrder.setTotalPrice(updatedOrder.getTotalPrice());
        existingOrder.setGroceryItemList(updatedOrder.getGroceryItemList());
        existingOrder.setCustomer(updatedOrder.getCustomer());

        return orderRepository.save(existingOrder);
    }

    public void deleteOrder(Long id) {
        Order orderToDelete = getOrderById(id);
        orderRepository.delete(orderToDelete);
    }
}
