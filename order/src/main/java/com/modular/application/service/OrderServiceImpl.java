package com.modular.application.service;

import com.modular.domain.dto.request.CreateOrderDto;
import com.modular.domain.dto.response.OrderInfoResponse;
import com.modular.domain.entity.Order;
import com.modular.domain.port.in.OrderUseCase;
import com.modular.domain.port.out.member.MemberPort;
import com.modular.domain.port.out.order.OrderRepository;
import com.modular.domain.port.out.product.ProductPort;
import com.modular.dto.member.MemberInfo;
import com.modular.dto.product.ProductInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderUseCase {

    // OrderService 는 Member모듈을 의존하지 않고 추상화에만 의존
    private final MemberPort memberPort;
    private final ProductPort productPort;
    private final OrderRepository orderRepository;

    @Override
    public OrderInfoResponse createOrder(CreateOrderDto orderDto) {
        MemberInfo member = memberPort.getMemberInfo(orderDto.getMemberId());
        ProductInfo product = productPort.decreaseStock(orderDto.getProductId(), orderDto.getQuantity());

        Order order = new Order(member.getMemberId(), product.getProductId(), orderDto.getQuantity());
        orderRepository.save(order);

        return OrderInfoResponse.of(order, member, product);
    }

}
