package com.modular.adapter;

import com.modular.dto.order.OrderHistoryDto;
import com.modular.port.external.ExternalOrderUseCase;
import com.modular.port.out.OrderPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderAdapter implements OrderPort {

    private final ExternalOrderUseCase externalOrderUseCase;

    @Override
    public List<OrderHistoryDto> getOrderHistory(String memberId) {
        return externalOrderUseCase.getOrderHistory(memberId);
    }
}
