package com.modular.port.external;

import com.modular.dto.order.OrderHistoryDto;

import java.util.List;

public interface ExternalOrderUseCase {
    // 외부에서 내부를 들어오는 인터페이스
    List<OrderHistoryDto> getOrderHistory(String memberId);
}
