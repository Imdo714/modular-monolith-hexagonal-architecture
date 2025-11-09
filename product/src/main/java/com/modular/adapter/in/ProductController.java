package com.modular.adapter.in;

import com.modular.domain.entity.Product;
import com.modular.domain.port.in.ProductManagementUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductManagementUseCase productManagementUseCase;

    @PostMapping
    public ResponseEntity<String> create(){
        Product product = new Product("상품1", 1000, 10);
        productManagementUseCase.createProduct(product);

        return ResponseEntity.ok("OK");
    }

}
