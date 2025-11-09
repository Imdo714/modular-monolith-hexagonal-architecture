package com.modular.domain.port.in;

import com.modular.dto.product.ProductInfo;

public interface ProductInternalUseCase { // Product-Modular port.in

    // 다른 모듈이 Product-Modular 내부 비즈니스 로직을 수행하기 위해 호출하는 인터페이스

    /**
     * 상품 ID로 기본 정보를 조회합니다.
     */
    ProductInfo getProductInfo(String productId);

    /**
     * 주문을 위해 상품 재고를 감소시키고, 처리된 상품 정보를 반환합니다.
     */
    ProductInfo decreaseStock(String productId, int quantity);
}
