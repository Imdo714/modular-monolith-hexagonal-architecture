package com.modular.memory;

import com.modular.entity.Order;
import com.modular.persistence.repository.OrderRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryOrderRepository implements OrderRepository {
    private final Map<String, Order> data = new ConcurrentHashMap<>();

    @Override
    public Order save(Order order) {
        data.put(Objects.requireNonNull(order).getId(), order);
        return order;
    }

    @Override
    public Optional<Order> findById(String id) {
        return Optional.ofNullable(data.get(id));
    }

    @Override
    public List<Order> getOrderHistory(String memberId) {
        return data.values().stream()
                .filter(order -> Objects.equals(order.getMemberId(), memberId))
                .toList();
    }
}
