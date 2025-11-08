package com.modular.domain.entity;

import lombok.Getter;

@Getter
public enum OrderStatus {
    CREATED("생성"),
    PAID("지불"),
    CANCELLED("취소");

    OrderStatus(String text) {
        this.text = text;
    }

    private final String text;
}
