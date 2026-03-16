package ru.urfu.trevorslattery.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.urfu.trevorslattery.entity.CartItemEntity;
import ru.urfu.trevorslattery.entity.ProductEntity;
import ru.urfu.trevorslattery.repository.CartItemRepository;
import ru.urfu.trevorslattery.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartItemRepository cartItemRepository;

    public List<CartItemEntity> getCartItems(){
        return cartItemRepository.findAll();
    }
    public CartItemEntity addToCart(CartItemEntity item){
        return cartItemRepository.save(item);
    }

    public void removeFromCart(Long id){
        cartItemRepository.deleteById(id);
    }
}
