package com.modular.persistence;

import com.modular.domain.entity.Payment;
import com.modular.domain.entity.PaymentRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryPaymentRepository implements PaymentRepository {
    private final Map<String, Payment> store = new ConcurrentHashMap<>();


}
