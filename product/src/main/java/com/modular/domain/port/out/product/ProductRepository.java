package com.modular.domain.port.out.product;

import com.modular.domain.entity.Product;

import java.util.Optional;

public interface ProductRepository {
    void save(Product product);
    Optional<Product> findById(String id);
}
