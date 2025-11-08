package com.modular.data;

import com.modular.domain.entity.Product;
import com.modular.domain.entity.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryProductRepository implements ProductRepository {
    private final Map<String, Product> store = new ConcurrentHashMap<>();
}
