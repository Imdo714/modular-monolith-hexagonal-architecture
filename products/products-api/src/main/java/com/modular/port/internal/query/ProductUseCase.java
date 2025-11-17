package com.modular.port.internal.query;

import com.modular.dto.product.ProductInfo;

public interface ProductUseCase {
    // 내부에서 내부 호춣하는 인터페이스
    ProductInfo getProductById(String productId);
}
