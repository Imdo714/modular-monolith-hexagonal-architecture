package com.modular.domain.entity;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Product {

    private final String id;
    private final String name;
    private final int price;
    private final int stock;

    public Product(String name, int price, int stock) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
        this.stock = stock;
    }


}
