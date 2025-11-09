package com.modular.domain.entity;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Order {
    private String id;
    private String memberId;
    private String productId;
    private int quantity;
    private OrderStatus status;

    public Order(String memberId, String productId, int quantity) {
        this.id = UUID.randomUUID().toString();
        this.memberId = memberId;
        this.productId = productId;
        this.quantity = quantity;
        this.status = OrderStatus.CREATED;
    }

}
