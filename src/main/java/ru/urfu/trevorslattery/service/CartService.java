package ru.urfu.trevorslattery.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.urfu.trevorslattery.dto.CartDto;
import ru.urfu.trevorslattery.dto.mapping.CartMapping;
import ru.urfu.trevorslattery.entity.CartItemEntity;
import ru.urfu.trevorslattery.repository.CartItemRepository;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartItemRepository cartItemRepository;
    private final CartMapping cartMapping;


    public CartDto addToCart(CartDto dto){
        CartItemEntity cartItem = cartMapping.toEntity(dto);
        CartItemEntity added = cartItemRepository.save(cartItem);
        return cartMapping.toDto(added);
    }

    public void removeFromCart(Long id){
        CartItemEntity cartItem = cartItemRepository.findById(id).orElseThrow();
        cartItemRepository.delete(cartItem);
    }
}
