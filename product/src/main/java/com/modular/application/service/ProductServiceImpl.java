package com.modular.application.service;

import com.modular.domain.entity.Product;
import com.modular.domain.port.in.ProductInternalUseCase;
import com.modular.domain.port.out.product.ProductRepository;
import com.modular.domain.port.in.ProductManagementUseCase;
import com.modular.dto.product.ProductInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductManagementUseCase, ProductInternalUseCase { // Product-Modular Service

    private final ProductRepository productRepository;

    @Override
    public void createProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public ProductInfo getProductInfo(String productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("없는 상품입니다."));

        return new ProductInfo(product.getId(), product.getName(), product.getPrice());
    }

    @Override
    public ProductInfo decreaseStock(String productId, int quantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("없는 상품입니다."));

        // 재고 감소
        product.decreaseStock(quantity);
        productRepository.save(product);

        return new ProductInfo(product.getId(), product.getName(), product.getPrice());
    }
}
