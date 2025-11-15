package com.modular.port;

import com.modular.dto.request.CreateOrderDto;
import com.modular.dto.response.OrderInfoResponse;

public interface OrdersUseCase { // Order-api-Modular
    // 내부에서 내부 호춣하는 인터페이스
    OrderInfoResponse createOrder(CreateOrderDto createOrderDto);
}
