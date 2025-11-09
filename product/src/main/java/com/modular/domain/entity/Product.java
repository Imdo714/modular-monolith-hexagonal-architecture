package com.modular.domain.entity;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Product {

    private String id;
    private String name;
    private int price;
    private int stock;

    public Product(String name, int price, int stock) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public void decreaseStock(int quantity) {
        if (this.stock < quantity) {
            throw new IllegalArgumentException("재고가 부족합니다.");
        }
        this.stock -= quantity;
    }

}
