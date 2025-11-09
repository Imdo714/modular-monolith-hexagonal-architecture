package com.modular.service;


import com.modular.application.service.OrderServiceImpl;
import com.modular.domain.dto.request.CreateOrderDto;
import com.modular.domain.dto.response.OrderInfoResponse;
import com.modular.domain.entity.Order;
import com.modular.domain.entity.OrderStatus;
import com.modular.domain.port.out.member.MemberPort;
import com.modular.domain.port.in.OrderUseCase;
import com.modular.domain.port.out.order.OrderRepository;
import com.modular.domain.port.out.product.ProductPort;
import com.modular.dto.member.MemberInfo;
import com.modular.dto.product.ProductInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class OrderServiceImplTest {

    private MemberPort memberPort;
    private ProductPort productPort;
    private OrderRepository orderRepository;
    private OrderUseCase orderUseCase;

    @BeforeEach
    void setUp() {
        // Mock 객체 생성
        memberPort = mock(MemberPort.class);
        productPort = mock(ProductPort.class);
        orderRepository = mock(OrderRepository.class);

        // Mock 주입
        orderUseCase = new OrderServiceImpl(memberPort, productPort, orderRepository);
    }

    @DisplayName("주문 생성 시 모든 정보가 올바르게 처리되고 OrderInfoResponse DTO를 반환한다")
    @Test
    void createOrder_Success() {
        // given
        CreateOrderDto orderDto = new CreateOrderDto("memberId", "productId", 2, OrderStatus.CREATED);

        MemberInfo mockMember = new MemberInfo("memberId", "홍길동");
        when(memberPort.getMemberInfo("memberId"))
                .thenReturn(mockMember);

        ProductInfo mockProduct = new ProductInfo("productId", "테스트 상품", 10000); // 10000원짜리 상품
        when(productPort.decreaseStock("productId", 2))
                .thenReturn(mockProduct);

        // when
        OrderInfoResponse response = orderUseCase.createOrder(orderDto);

        // then
        assertThat(response).isNotNull();
        assertThat(response.getMemberId()).isEqualTo("memberId"); // 주문자 ID
        assertThat(response.getMemberName()).isEqualTo("홍길동"); // 주문자 이름
        assertThat(response.getProductId()).isEqualTo("productId"); // 상품 ID
        assertThat(response.getProductName()).isEqualTo("테스트 상품"); // 상품 이름
        assertThat(response.getPrice()).isEqualTo(10000); // 상품 가격
        assertThat(response.getQuantity()).isEqualTo(2); // 주문 수량
        assertThat(response.getSum()).isEqualTo(20000); // 총 가격

        ArgumentCaptor<Order> orderCaptor = ArgumentCaptor.forClass(Order.class);
        verify(orderRepository, times(1)).save(orderCaptor.capture());

        Order savedOrder = orderCaptor.getValue();
        assertThat(savedOrder).isNotNull();
        assertThat(savedOrder.getMemberId()).isEqualTo("memberId");
        assertThat(savedOrder.getProductId()).isEqualTo("productId");
        assertThat(savedOrder.getQuantity()).isEqualTo(2);

        // 반환 값이 없을 때 verify 를 사용해 memberPort.getMemberInfo 메서드가 "memberId" 인자와 함께 1번 호출되었는지 검증
        verify(memberPort, times(1)).getMemberInfo("memberId");
        verify(productPort, times(1)).decreaseStock("productId", 2);
    }


}