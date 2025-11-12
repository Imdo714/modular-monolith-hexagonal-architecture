package com.modular.service;

import com.modular.port.MemberUseCase;
import com.modular.port.OrdersUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrdersUseCase { // Order-service-Modular

    private final MemberUseCase memberUseCase;

    @Override
    public void createOrder() {
        memberUseCase.callMember();
    }
}
