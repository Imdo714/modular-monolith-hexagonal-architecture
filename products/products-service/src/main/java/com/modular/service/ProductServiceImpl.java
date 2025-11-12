package com.modular.service;

import com.modular.data.ProductRepository;
import com.modular.port.ProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductUseCase {

    private final ProductRepository productRepository;


}
