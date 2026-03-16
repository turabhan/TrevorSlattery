package ru.urfu.trevorslattery.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.urfu.trevorslattery.entity.OrderEntity;
import ru.urfu.trevorslattery.repository.OrderRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public List<OrderEntity> getOrders(){
        return orderRepository.findAll();
    }
    public OrderEntity createOrder(OrderEntity order){
        return orderRepository.save(order);
    }
    public OrderEntity getOrderById(Long id){
        return orderRepository.findById(id).orElseThrow();
    }
}
