package com.modular.dto.product;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductInfo {
    private String productId;
    private String name;
    private int price;
    private int stock;
}
