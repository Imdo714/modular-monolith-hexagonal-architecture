package com.modular.port.out;

import com.modular.dto.product.ProductInfo;

public interface ProductPort {
    ProductInfo decreaseStock(String productId, int quantity);
}
