package com.modular.controller;

import com.modular.dto.request.CreateOrderDto;
import com.modular.dto.response.OrderInfoResponse;
import com.modular.port.internal.command.OrderCommandUseCase;
import com.modular.port.internal.query.OrdersUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController { // Order-api-Modular

    private final OrdersUseCase ordersUseCase;
    private final OrderCommandUseCase orderCommandUseCase;

    @PostMapping
    public ResponseEntity<OrderInfoResponse> getOrders(@RequestBody CreateOrderDto createOrderDto) {
        return ResponseEntity.ok(orderCommandUseCase.createOrder(createOrderDto));
    }


}
