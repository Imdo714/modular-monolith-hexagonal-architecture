package com.modular.port;

import com.modular.dto.product.ProductInfo;
import com.modular.dto.request.CreateProductDto;

public interface ProductUseCase {
    // 내부에서 내부 호춣하는 인터페이스

    ProductInfo createProduct(CreateProductDto createMemberDto);
    ProductInfo getProductById(String productId);
}
