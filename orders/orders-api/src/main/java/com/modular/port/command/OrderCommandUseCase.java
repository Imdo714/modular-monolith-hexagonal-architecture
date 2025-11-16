package com.modular.port.command;

import com.modular.dto.request.CreateOrderDto;
import com.modular.dto.response.OrderInfoResponse;

public interface OrderCommandUseCase {
    OrderInfoResponse createOrder(CreateOrderDto createOrderDto);
}
