package com.modular.data;

import com.modular.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryProductRepository implements ProductRepository {

    private final Map<String, Product> data = new ConcurrentHashMap<>();

    @Override
    public void save(Product product) {
        data.put(Objects.requireNonNull(product).getId(), product);
    }

    @Override
    public Optional<Product> findById(String id) {
        return Optional.ofNullable(data.get(id));
    }
}
