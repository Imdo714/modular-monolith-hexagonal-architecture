package com.modular.controller;

import com.modular.port.OrdersUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController { // Order-api-Modular

    private final OrdersUseCase ordersUseCase;

    @GetMapping("/test")
    public ResponseEntity<String> getOrders() {
        log.info("getOrders");
        ordersUseCase.createOrder();
        return ResponseEntity.ok("Orders created");
    }
}
