package com.modular.service.external;

import com.modular.dto.order.OrderHistoryDto;
import com.modular.entity.Order;
import com.modular.repository.OrderRepository;
import com.modular.port.external.ExternalOrderUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderExternalServiceImpl implements ExternalOrderUseCase {

    private final OrderRepository orderRepository;

    @Override
    public List<OrderHistoryDto> getOrderHistory(String memberId) {
        List<Order> orderList = orderRepository.getOrderHistory(memberId);

        return orderList.stream()
                .map(order -> new OrderHistoryDto(
                        order.getId(),
                        order.getMemberId(),
                        order.getProductId(),
                        order.getQuantity()
                ))
                .toList();
    }
}
