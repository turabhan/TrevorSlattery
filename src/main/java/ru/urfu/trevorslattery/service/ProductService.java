package ru.urfu.trevorslattery.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.urfu.trevorslattery.entity.ProductEntity;
import ru.urfu.trevorslattery.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<ProductEntity> getAllProducts(){
        return productRepository.findAll();
    }
    public ProductEntity getProductById(Long id){
        return productRepository.findById(id).orElseThrow();
    }
    public ProductEntity saveProduct(ProductEntity product){
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
