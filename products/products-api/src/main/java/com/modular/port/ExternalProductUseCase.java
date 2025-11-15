package com.modular.port;

import com.modular.dto.product.ProductInfo;

public interface ExternalProductUseCase {
    // 외부에서 내부를 들어오는 인터페이스
    ProductInfo decreaseStock(String productId, int quantity);
}
