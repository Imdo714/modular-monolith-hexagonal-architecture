package com.modular.domain.port.out.product;

import com.modular.dto.product.ProductInfo;

public interface ProductPort { // Order-Modular port.out
    ProductInfo getProductInfo(String productId);
    ProductInfo decreaseStock(String productId, int quantity);
}
