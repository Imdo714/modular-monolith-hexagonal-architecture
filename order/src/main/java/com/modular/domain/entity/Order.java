package com.modular.domain.entity;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Order {
    private final String id;
    private final String memberId;
    private final String productId;
    private final int quantity;
    private final OrderStatus status;

    public Order(String memberId, String productId, int quantity) {
        this.id = UUID.randomUUID().toString();
        this.memberId = memberId;
        this.productId = productId;
        this.quantity = quantity;
        this.status = OrderStatus.CREATED;
    }

}
