package ru.urfu.trevorslattery.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.urfu.trevorslattery.dto.CartDto;
import ru.urfu.trevorslattery.service.CartService;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;


    @PostMapping
    public CartDto addCartItem(@RequestBody CartDto cartItem){
        return cartService.addToCart(cartItem);
    }

    @DeleteMapping("/{id}")
    public void deleteItemById(@PathVariable Long id){
        cartService.removeFromCart(id);
    }
}
