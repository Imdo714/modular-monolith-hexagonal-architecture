package com.modular.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
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
