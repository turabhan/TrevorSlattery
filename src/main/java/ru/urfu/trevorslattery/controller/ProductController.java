package ru.urfu.trevorslattery.controller;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.urfu.trevorslattery.dto.ProductDto;
import ru.urfu.trevorslattery.entity.ProductEntity;
import ru.urfu.trevorslattery.service.ProductService;


@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/{id}")
    public String getProduct(@PathVariable Long id, Model model){
            model.addAttribute("product", productService.getProductById(id));
            return "product_details";
    }


    @PostMapping
    public String createProduct(@ModelAttribute ProductDto product){
        productService.saveProduct(product);
        return "redirect:/products";
    }


    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return "redirect:/products";
    }

}
