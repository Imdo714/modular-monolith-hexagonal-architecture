package com.modular.service.internal;

import com.modular.dto.product.ProductInfo;
import com.modular.entity.Product;
import com.modular.repository.ProductRepository;
import com.modular.port.internal.ProductUseCase;
import com.modular.query.ProductQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductUseCase {

    private final ProductRepository productRepository;
    private final ProductQuery productQuery;

    @Override
    public ProductInfo getProductById(String productId) {
        Product product = productQuery.findProductById(productId);
        return productQuery.toProductInfo(product);
    }

}
