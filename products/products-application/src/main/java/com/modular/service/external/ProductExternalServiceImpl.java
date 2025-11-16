package com.modular.service.external;

import com.modular.dto.product.ProductInfo;
import com.modular.entity.Product;
import com.modular.repository.ProductRepository;
import com.modular.port.external.ExternalProductUseCase;
import com.modular.query.ProductQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductExternalServiceImpl implements ExternalProductUseCase {

    private final ProductRepository productRepository;
    private final ProductQuery productQuery;

    @Override
    public ProductInfo decreaseStock(String productId, int quantity) {
        Product product = productQuery.findProductById(productId);

        // 재고 감소
        product.decreaseStock(quantity);
        productRepository.save(product);

        return productQuery.toProductInfo(product);
    }
}
