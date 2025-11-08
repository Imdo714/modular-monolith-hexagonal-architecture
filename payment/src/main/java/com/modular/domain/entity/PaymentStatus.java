package com.modular.domain.entity;

import lombok.Getter;

@Getter
public enum PaymentStatus {
    PENDING("보류 중"),
    COMPLETED("완료")
    ;

    PaymentStatus(String text) {
        this.text = text;
    }

    private final String text;
}
