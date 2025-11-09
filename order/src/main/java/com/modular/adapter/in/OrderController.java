package com.modular.adapter.in;

import com.modular.domain.dto.request.CreateOrderDto;
import com.modular.domain.dto.response.OrderInfoResponse;
import com.modular.domain.entity.OrderStatus;
import com.modular.domain.port.in.OrderUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final OrderUseCase orderUseCase;

    @PostMapping
    public ResponseEntity<OrderInfoResponse> create(){
        CreateOrderDto orderDto = new CreateOrderDto("memberId", "productId", 2, OrderStatus.CREATED);
        return ResponseEntity.ok(orderUseCase.createOrder(orderDto));
    }

}
