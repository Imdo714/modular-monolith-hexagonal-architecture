package com.modular.service;

import com.modular.infrastructure.OrderRepository;
import com.modular.dto.member.MemberInfo;
import com.modular.dto.product.ProductInfo;
import com.modular.dto.request.CreateOrderDto;
import com.modular.dto.response.OrderInfoResponse;
import com.modular.entity.Order;
import com.modular.port.ExternalMemberUseCase;
import com.modular.port.ExternalProductUseCase;
import com.modular.port.OrdersUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrdersUseCase { // Order-service-Modular

    private final OrderRepository orderRepository;
    private final ExternalMemberUseCase externalMemberUseCase;
    private final ExternalProductUseCase externalProductUseCase;

    @Override
    public OrderInfoResponse createOrder(CreateOrderDto createOrderDto) {
        MemberInfo member = externalMemberUseCase.getMemberById(createOrderDto.getMemberId());
        ProductInfo product = externalProductUseCase.decreaseStock(createOrderDto.getProductId(), createOrderDto.getQuantity());

        Order orderNew = new Order(member.getMemberId(), product.getProductId(), createOrderDto.getQuantity());
        Order order = orderRepository.save(orderNew);

        return OrderInfoResponse.of(order, member, product);
    }
}
