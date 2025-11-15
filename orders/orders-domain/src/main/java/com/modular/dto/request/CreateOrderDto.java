package com.modular.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateOrderDto {
    private String memberId; // 주문자
    private String productId; // 상품
    private int quantity; // 주문 수량
}
