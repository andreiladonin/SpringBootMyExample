package ru.springladonin.musicweb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.springladonin.musicweb.entities.Order;
import ru.springladonin.musicweb.repositories.OrderRepository;

@Service
public class OrderService {


    private OrderRepository orderRepository;

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }


}
