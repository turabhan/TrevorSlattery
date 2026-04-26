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

//    @GetMapping
//    public List<OrderDto> getAll(){
//        return orderService.getOrders();
//    }
    @PostMapping
    public OrderDto saveOrder(@RequestBody OrderDto order){
        return orderService.createOrder(order);
    }
    @GetMapping("/{id}")
    public OrderDto findOrderById(@RequestBody Long id){
        return orderService.getOrderById(id);
    }
}
