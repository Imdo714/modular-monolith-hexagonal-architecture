package com.modular.domain.dto.response;

import com.modular.domain.entity.Order;
import com.modular.dto.member.MemberInfo;
import com.modular.dto.product.ProductInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class OrderInfoResponse {

    private String orderId;
    private String memberId;
    private String memberName;
    private String productId;
    private String productName;
    private int price;
    private int quantity;
    private int sum;

    public static OrderInfoResponse of(Order order, MemberInfo member, ProductInfo product){
        return OrderInfoResponse.builder()
                .orderId(order.getId())
                .memberId(member.getMemberId())
                .memberName(member.getName())
                .productId(product.getProductId())
                .productName(product.getName())
                .price(product.getPrice())
                .quantity(order.getQuantity())
                .sum(order.getQuantity() * product.getPrice())
                .build();
    }
}
