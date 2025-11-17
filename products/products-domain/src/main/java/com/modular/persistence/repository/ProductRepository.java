package com.modular.persistence.repository;

import com.modular.entity.Product;

import java.util.Optional;

public interface ProductRepository {
    Product save(Product product);
    Optional<Product> findById(String memberId);
}
