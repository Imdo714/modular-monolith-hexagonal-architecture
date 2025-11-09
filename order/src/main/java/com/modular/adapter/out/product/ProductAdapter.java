package com.modular.adapter.out.product;

import com.modular.domain.port.in.ProductInternalUseCase;
import com.modular.domain.port.out.product.ProductPort;
import com.modular.dto.product.ProductInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductAdapter implements ProductPort { // Order-Modular Adapter.out

    // Product-Modular port.in 을 주입 받음
    private final ProductInternalUseCase productInternalUseCase;

    @Override
    public ProductInfo getProductInfo(String productId) {
        return productInternalUseCase.getProductInfo(productId);
    }

    @Override
    public ProductInfo decreaseStock(String productId, int quantity) {
        return productInternalUseCase.decreaseStock(productId, quantity);
    }
}
