package com.modular.domain.dto.request;

import com.modular.domain.entity.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateOrderDto {
    private String memberId;
    private String productId;
    private int quantity;
    private OrderStatus status;
}
