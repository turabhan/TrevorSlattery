package ru.urfu.trevorslattery.controller;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.urfu.trevorslattery.entity.ProductEntity;
import ru.urfu.trevorslattery.service.ProductService;


@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

//    @GetMapping//check later
//    public String getAllProducts(Model model){
//        model.addAttribute("products", productService.getAllProducts());
//        return "products";
//    }
    @GetMapping("/{id}")
    public String getProduct(@PathVariable Long id, Model model){
        try {
            model.addAttribute("product", productService.getProductById(id));
            return "product_details";
        } catch (Exception e) {
            throw new EntityNotFoundException(e);
        }
    }
    @PostMapping
    public String createProduct(@RequestBody ProductEntity product){
        productService.saveProduct(product);
        return "redirect:/products";
    }
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return "redirect:/products";
    }

}
