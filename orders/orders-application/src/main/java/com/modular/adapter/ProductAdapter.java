package com.modular.adapter;

import com.modular.dto.product.ProductInfo;
import com.modular.port.external.ExternalProductUseCase;
import com.modular.port.out.ProductPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductAdapter implements ProductPort {

    private final ExternalProductUseCase externalProductUseCase;

    @Override
    public ProductInfo decreaseStock(String productId, int quantity) {
        return externalProductUseCase.decreaseStock(productId, quantity);
    }
}
