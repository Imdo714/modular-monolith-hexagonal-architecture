package com.modular.port.internal.command;

import com.modular.dto.request.CreateOrderDto;
import com.modular.dto.response.OrderInfoResponse;

public interface OrderCommandUseCase {
    OrderInfoResponse createOrder(CreateOrderDto createOrderDto);
}
