package ru.urfu.trevorslattery.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.urfu.trevorslattery.dto.CartDto;
import ru.urfu.trevorslattery.dto.mapping.CartMapping;
import ru.urfu.trevorslattery.entity.CartItemEntity;
import ru.urfu.trevorslattery.entity.ProductEntity;
import ru.urfu.trevorslattery.entity.UserEntity;
import ru.urfu.trevorslattery.repository.CartItemRepository;
import ru.urfu.trevorslattery.repository.ProductRepository;
import ru.urfu.trevorslattery.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartItemRepository cartItemRepository;
    private final CartMapping cartMapping;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public List<CartDto> getUserCart(String email){
        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return cartItemRepository.findByUser(user).stream()
                .map(cartMapping::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public void addToCart(String email, Long productId, Integer quantity) {
        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        ProductEntity product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        CartItemEntity cartItem = cartItemRepository.findByUser(user).stream()
                .filter(item -> item.getProduct().getId().equals(productId))
                .findFirst()
                .orElse(new CartItemEntity());

        if (cartItem.getId() == null) {
            cartItem.setUser(user);
            cartItem.setProduct(product);
            cartItem.setQuantity(quantity);
        } else {
            cartItem.setQuantity(cartItem.getQuantity() + quantity);
        }

        cartItemRepository.save(cartItem);
    }

    public void removeFromCart(Long id){
        cartItemRepository.deleteById(id);
    }
}
