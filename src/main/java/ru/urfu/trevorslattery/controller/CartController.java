package ru.urfu.trevorslattery.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.urfu.trevorslattery.service.CartService;
import ru.urfu.trevorslattery.service.OrderService;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;
    private final OrderService orderService;

    @GetMapping("/cart")
    public String viewCart(Principal principal, Model model) {
        if (principal == null) return "redirect:/login";

        model.addAttribute("cartItems", cartService
                .getUserCart(principal.getName()));
        return "cart";
    }

    @PostMapping("/cart/add/{productId}")
    public String addToCart(@PathVariable Long productId,
                            @RequestParam Integer quantity,
                            Principal principal) {
        if (principal == null) return "redirect:/login";

        cartService.addToCart(principal.getName(), productId, quantity);
        return "redirect:/products";
    }

    @PostMapping("/checkout")
    public String checkout(Principal principal) {
        if (principal == null) return "redirect:/login";

        orderService.checkout(principal.getName());
        return "redirect:/products";
    }

    @PostMapping("/cart/remove/{id}")
    public String deleteItemById(@PathVariable Long id){
        cartService.removeFromCart(id);
        return "redirect:/cart";
    }
}