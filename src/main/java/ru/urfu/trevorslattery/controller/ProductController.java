package ru.urfu.trevorslattery.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.urfu.trevorslattery.entity.ProductEntity;
import ru.urfu.trevorslattery.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<ProductEntity> getAllProducts(){
        return productService.getAllProducts();
    }
    @GetMapping("/{id}")
    public ProductEntity getProduct(@PathVariable Long id){
        return productService.getProductById(id);
    }
    @PostMapping
    public ProductEntity createProduct(@RequestBody ProductEntity product){
        return productService.saveProduct(product);
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }

}
