package com.modular.port.out;

import com.modular.dto.order.OrderHistoryDto;

import java.util.List;

public interface OrderPort {
    List<OrderHistoryDto> getOrderHistory(String memberId);
}
