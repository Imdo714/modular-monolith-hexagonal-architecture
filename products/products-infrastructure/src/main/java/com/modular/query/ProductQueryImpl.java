package com.modular.query;

import com.modular.dto.product.ProductInfo;
import com.modular.entity.Product;
import com.modular.persistence.query.ProductQuery;
import com.modular.persistence.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductQueryImpl implements ProductQuery {

    private final ProductRepository productRepository;

    @Override
    public Product findProductById(String productId) {
        return  productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("없는 상품입니다."));
    }

    @Override
    public ProductInfo toProductInfo(Product product) {
        return new ProductInfo(product.getId(), product.getName(), product.getPrice(), product.getStock());
    }
}
