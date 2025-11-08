package com.modular.domain.entity;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Payment {
    private final String id;
    private final String orderId;
    private final int amount;
    private PaymentStatus status;

    public Payment(String orderId, int amount) {
        this.id = UUID.randomUUID().toString();
        this.orderId = orderId;
        this.amount = amount;
        this.status = PaymentStatus.PENDING;
    }
}
