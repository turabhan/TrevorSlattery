package ru.urfu.trevorslattery.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.urfu.trevorslattery.dto.OrderDto;
import ru.urfu.trevorslattery.entity.OrderEntity;
import ru.urfu.trevorslattery.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    @PostMapping
    public OrderDto saveOrder(@RequestBody OrderDto order){
        return orderService.createOrder(order);
    }
    @GetMapping("/{id}")
    public OrderDto findOrderById(@PathVariable Long id){
        return orderService.getOrderById(id);
    }
}
