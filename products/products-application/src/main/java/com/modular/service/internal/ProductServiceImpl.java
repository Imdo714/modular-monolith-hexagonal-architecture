package com.modular.service.internal;

import com.modular.dto.product.ProductInfo;
import com.modular.entity.Product;
import com.modular.persistence.repository.ProductRepository;
import com.modular.port.internal.query.ProductUseCase;
import com.modular.persistence.query.ProductQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductUseCase {

    private final ProductQuery productQuery;

    @Override
    public ProductInfo getProductById(String productId) {
        Product product = productQuery.findProductById(productId);
        return productQuery.toProductInfo(product);
    }

}
