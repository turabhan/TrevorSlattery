package ru.urfu.trevorslattery.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.urfu.trevorslattery.dto.OrderDto;
import ru.urfu.trevorslattery.dto.mapping.CartMapping;
import ru.urfu.trevorslattery.dto.mapping.OrderMapping;
import ru.urfu.trevorslattery.entity.CartItemEntity;
import ru.urfu.trevorslattery.entity.OrderEntity;
import ru.urfu.trevorslattery.entity.OrderItemEntity;
import ru.urfu.trevorslattery.entity.UserEntity;
import ru.urfu.trevorslattery.enums.OrderStatus;
import ru.urfu.trevorslattery.repository.CartItemRepository;
import ru.urfu.trevorslattery.repository.OrderItemRepository;
import ru.urfu.trevorslattery.repository.OrderRepository;
import ru.urfu.trevorslattery.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final TransactionLogService transactionLogService;
    private final OrderMapping orderMapping;
    private final UserRepository userRepository;
    private final CartItemRepository cartItemRepository;
    private final CartMapping cartMapping;
    private final OrderItemRepository orderItemRepository;


    public OrderDto createOrder(OrderDto dto) {
        OrderEntity order = orderMapping.toEntity(dto);
        order.setCreatedAt(LocalDateTime.now());
        OrderEntity createdOrder = orderRepository.save(order);
        transactionLogService.log(
                "CREATE_ORDER",
                createdOrder.getUser().getId(),
                "Order id=" + createdOrder.getId());

        return orderMapping.toDto(createdOrder);
    }

    public OrderDto getOrderById(Long id) {
        OrderEntity orderById = orderRepository.findById(id).orElseThrow();

        return orderMapping.toDto(orderById);
    }

    @Transactional
    public OrderDto checkout(String email) {
        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<CartItemEntity> cartItems = cartItemRepository.findByUser(user);
        if (cartItems.isEmpty()) {
            throw new RuntimeException("Корзина пуста");
        }

        OrderEntity order = new OrderEntity();
        order.setUser(user);
        order.setCreatedAt(LocalDateTime.now());
        order.setStatus(OrderStatus.CREATED);

        for (CartItemEntity cartItem : cartItems) {
            OrderItemEntity orderItem = new OrderItemEntity();

            orderItem.setOrder(order); //привязываем позицию к заказу
            orderItem.setProduct(cartItem.getProduct());
            orderItem.setQuantity(cartItem.getQuantity());

            //актуальная цену из продукта
            orderItem.setPrice(cartItem.getProduct().getPrice());

            //позиция в список заказа
            order.getItems().add(orderItem);
        }
        OrderEntity savedOrder = orderRepository.save(order);
        cartItemRepository.deleteAll(cartItems);

        transactionLogService.log("ORDER_CREATED", user.getId(),
                "Order ID: " + savedOrder.getId());

        return orderMapping.toDto(savedOrder);
    }
}