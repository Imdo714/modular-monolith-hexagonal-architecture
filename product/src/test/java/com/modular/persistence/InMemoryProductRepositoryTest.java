package com.modular.persistence;

import com.modular.adapter.out.persistence.InMemoryProductRepository;
import com.modular.domain.entity.Product;
import com.modular.domain.port.out.product.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class InMemoryProductRepositoryTest {

    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        productRepository = new InMemoryProductRepository();
    }

    @DisplayName("상품을 생성하고 ID로 조회하면 해당 상품이 반환된다.")
    @Test
    void save() {
        // given
        Product productToSave = new Product("상품1", 1000, 5);
        String productId = productToSave.getId();
        System.out.println(productId);

        // when
        productRepository.save(productToSave);
        Optional<Product> foundProduct = productRepository.findById(productId);

        // then
        assertThat(foundProduct).isPresent();
        assertThat(foundProduct.get().getName()).isEqualTo("상품1");
        assertThat(foundProduct.get().getId()).isEqualTo(productId);
    }
}