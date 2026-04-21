package ru.urfu.trevorslattery.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.urfu.trevorslattery.entity.ProductEntity;
import ru.urfu.trevorslattery.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final TransactionLogService transactionLogService;

//    public List<ProductEntity> getAllProducts(){
//        return productRepository.findAll();
//    }
    public ProductEntity getProductById(Long id){
        return productRepository.findById(id).orElseThrow();
    }
    public ProductEntity saveProduct(ProductEntity product){
        ProductEntity saved = productRepository.save(product);

        transactionLogService.log("CREATE PRODUCT", null,
                "Product id="+saved.getId());

        return saved;


    }

    public void deleteProduct(Long id) {
        ProductEntity product = productRepository.findById(id).orElseThrow();

        productRepository.delete(product);

        transactionLogService.log("DELETE PRODUCT", null,
                "Product id" + id);
    }
}
