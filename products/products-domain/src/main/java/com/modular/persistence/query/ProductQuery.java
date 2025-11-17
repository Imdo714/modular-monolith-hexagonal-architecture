package com.modular.persistence.query;

import com.modular.dto.product.ProductInfo;
import com.modular.entity.Product;

public interface ProductQuery {
    Product findProductById(String productId);
    ProductInfo toProductInfo(Product product);
}
