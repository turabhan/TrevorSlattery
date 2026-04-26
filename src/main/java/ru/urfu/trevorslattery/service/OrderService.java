package ru.urfu.trevorslattery.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.urfu.trevorslattery.dto.OrderDto;
import ru.urfu.trevorslattery.dto.mapping.OrderMapping;
import ru.urfu.trevorslattery.entity.OrderEntity;
import ru.urfu.trevorslattery.repository.OrderRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final TransactionLogService transactionLogService;
    private final OrderMapping orderMapping;


    public OrderDto createOrder(OrderDto dto){
        OrderEntity order = orderMapping.toEntity(dto);
        order.setCreatedAt(LocalDateTime.now());
        OrderEntity createdOrder = orderRepository.save(order);
        transactionLogService.log(
                "CREATE_ORDER",
                createdOrder.getUser().getId(),
                "Order id=" + createdOrder.getId());

        return orderMapping.toDto(createdOrder);
    }

    public OrderDto getOrderById(Long id){
        OrderEntity orderById = orderRepository.findById(id).orElseThrow();

        return orderMapping.toDto(orderById);
    }
}
