package ru.urfu.trevorslattery.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.urfu.trevorslattery.dto.ProductDto;
import ru.urfu.trevorslattery.dto.mapping.ProductMapping;
import ru.urfu.trevorslattery.entity.ProductEntity;
import ru.urfu.trevorslattery.repository.ProductRepository;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final TransactionLogService transactionLogService;
    private final ProductMapping productMapping;

    public ProductDto getProductById(Long id){
        ProductEntity productById = productRepository.findById(id).orElseThrow();

        return productMapping.toDto(productById);
    }

    public ProductDto saveProduct(ProductDto dto){
        ProductEntity product = productMapping.toEntity(dto);
        ProductEntity savedProduct = productRepository.save(product);
        transactionLogService.log("CREATE PRODUCT", null,
                "Product id="+savedProduct.getId());

        return productMapping.toDto(savedProduct);
    }

    public void deleteProduct(Long id) {
        ProductEntity product = productRepository.findById(id).orElseThrow();

        productRepository.delete(product);

        transactionLogService.log("DELETE PRODUCT", null,
                "Product id=" + id);
    }
}
