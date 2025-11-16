package com.modular.controller;

import com.modular.dto.product.ProductInfo;
import com.modular.dto.request.CreateProductDto;
import com.modular.port.command.ProductCommandUseCase;
import com.modular.port.internal.ProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductUseCase productUseCase;
    private final ProductCommandUseCase productCommandUseCase;

    @PostMapping
    public ResponseEntity<ProductInfo> save(@RequestBody CreateProductDto createMemberDto) {
        return ResponseEntity.ok(productCommandUseCase.createProduct(createMemberDto));
    }

}
