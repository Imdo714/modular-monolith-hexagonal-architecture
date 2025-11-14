package com.modular.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateProductDto {
    private String name;
    private int price;
    private int stock;
}
