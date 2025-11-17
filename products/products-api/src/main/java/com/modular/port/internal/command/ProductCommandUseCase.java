package com.modular.port.internal.command;

import com.modular.dto.product.ProductInfo;
import com.modular.dto.request.CreateProductDto;

public interface ProductCommandUseCase {
    ProductInfo createProduct(CreateProductDto createMemberDto);
}
