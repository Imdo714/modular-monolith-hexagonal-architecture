package com.modular.controller;

import com.modular.dto.product.ProductInfo;
import com.modular.dto.request.CreateProductDto;
import com.modular.port.internal.command.ProductCommandUseCase;
import com.modular.port.internal.query.ProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{productId}")
    public ResponseEntity<ProductInfo> getProduct(@PathVariable String productId) {
        return ResponseEntity.ok(productUseCase.getProductById(productId));
    }

}
