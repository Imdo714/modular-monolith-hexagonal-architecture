package com.modular.service;

import com.modular.port.ExternalMemberUseCase;
import com.modular.port.OrdersUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrdersUseCase { // Order-service-Modular

    private final ExternalMemberUseCase memberUseCase;

    @Override
    public void createOrder() {

    }
}
