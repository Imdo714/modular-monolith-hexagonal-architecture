package com.modular.service.command;

import com.modular.dto.member.MemberInfo;
import com.modular.dto.product.ProductInfo;
import com.modular.dto.request.CreateOrderDto;
import com.modular.dto.response.OrderInfoResponse;
import com.modular.entity.Order;
import com.modular.persistence.repository.OrderRepository;
import com.modular.port.internal.command.OrderCommandUseCase;
import com.modular.port.out.MemberPort;
import com.modular.port.out.ProductPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderCommentServiceImpl implements OrderCommandUseCase {

    private final OrderRepository orderRepository;
    private final MemberPort memberPort;
    private final ProductPort productPort;

    @Override
    public OrderInfoResponse createOrder(CreateOrderDto createOrderDto) {
        MemberInfo member = memberPort.getMemberById(createOrderDto.getMemberId());
        ProductInfo product = productPort.decreaseStock(createOrderDto.getProductId(), createOrderDto.getQuantity());

        Order orderNew = new Order(member.getMemberId(), product.getProductId(), createOrderDto.getQuantity());
        Order order = orderRepository.save(orderNew);

        return OrderInfoResponse.of(order, member, product);
    }
}
