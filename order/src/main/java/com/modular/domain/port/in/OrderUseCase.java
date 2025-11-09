package com.modular.domain.port.in;

import com.modular.domain.dto.request.CreateOrderDto;
import com.modular.domain.dto.response.OrderInfoResponse;

public interface OrderUseCase {
    // 외부에서 호출하는 추상 클래스 ex) Controller 같은 되서 호출이 됨
    // 즉, 외부에서 호출하는 공개 API, order 모듈의 기능을 쓰고 싶으면, 이 인터페이스의 규칙대로 호출해! 라고 외부에 약속(Contract)을 제공
    OrderInfoResponse createOrder(CreateOrderDto orderDto);
}
