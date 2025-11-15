package com.modular.service;

import com.modular.infrastructure.ProductRepository;
import com.modular.dto.product.ProductInfo;
import com.modular.dto.request.CreateProductDto;
import com.modular.entity.Product;
import com.modular.port.ExternalProductUseCase;
import com.modular.port.ProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductUseCase, ExternalProductUseCase {

    private final ProductRepository productRepository;


    @Override
    public ProductInfo createProduct(CreateProductDto createMemberDto) {
        Product product = new Product(createMemberDto.getName(), createMemberDto.getPrice(), createMemberDto.getStock());
        Product saveProduct = productRepository.save(product);

        return toProductInfo(saveProduct);
    }

    @Override
    public ProductInfo getProductById(String productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("없는 상품입니다."));

        return toProductInfo(product);
    }

    private ProductInfo toProductInfo(Product product) {
        return new ProductInfo(product.getId(), product.getName(), product.getPrice(), product.getStock());
    }

    @Override
    public ProductInfo decreaseStock(String productId, int quantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("없는 상품입니다."));

        // 재고 감소
        product.decreaseStock(quantity);
        productRepository.save(product);

        return toProductInfo(product);
    }
}
