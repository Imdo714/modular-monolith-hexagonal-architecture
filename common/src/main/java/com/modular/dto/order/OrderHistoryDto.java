package com.modular.dto.order;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderHistoryDto {
    private String orderId;
    private String memberId;
    private String productId;
    private int quantity;

}
