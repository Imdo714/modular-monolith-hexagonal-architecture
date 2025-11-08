package com.modular.data;

import com.modular.domain.entity.Order;
import com.modular.domain.entity.OrderRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryOrderRepository implements OrderRepository {
    private final Map<String, Order> store = new ConcurrentHashMap<>();

}
