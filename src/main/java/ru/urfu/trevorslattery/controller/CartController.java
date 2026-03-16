package ru.urfu.trevorslattery.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.urfu.trevorslattery.entity.CartItemEntity;
import ru.urfu.trevorslattery.entity.ProductEntity;
import ru.urfu.trevorslattery.service.CartService;

import java.util.List;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @GetMapping
    public List<CartItemEntity> getAll(){
        return cartService.getCartItems();
    }
    @PostMapping
    public CartItemEntity addCartItem(@RequestBody CartItemEntity item){
        return cartService.addToCart(item);
    }
    @DeleteMapping("/{id}")
    public void deleteItemById(@PathVariable Long id){
        cartService.removeFromCart(id);
    }
}
