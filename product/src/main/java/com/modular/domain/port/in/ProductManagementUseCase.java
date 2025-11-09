package com.modular.domain.port.in;

import com.modular.domain.entity.Product;

public interface ProductManagementUseCase { // Product-Modular port.in

    // 관리자나 외부 API가 상품을 관리하기 위해 호출하는 인터페이스

    /**
     * 새로운 상품을 등록
     */
    void createProduct(Product product);
}
