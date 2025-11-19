package com.modular.service.internal;

import com.modular.dto.product.ProductInfo;
import com.modular.entity.Product;
import com.modular.persistence.query.ProductQuery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class ProductServiceImplTest {

    private ProductServiceImpl productService;
    private ProductQuery productQuery;

    @BeforeEach
    void setUp() {
        // Mock 객체 생성
        productQuery = mock(ProductQuery.class);

        // Mock 주입
        productService = new ProductServiceImpl(productQuery);
    }

    @DisplayName("getProductById_상품_조회_성공")
    @Test
    void getProductById() {
        // given
        Product product = new Product("product-123", "상품1", 1000, 100);
        when(productQuery.toProductInfo(product))
                .thenReturn(new ProductInfo("product-123", "상품1", 1000, 100));

        // when
        ProductInfo productResult = productService.getProductById("product-123");

        // then
        assertThat(productResult).isNotNull();
        assertThat(productResult.getProductId()).isEqualTo("product-123");
        assertThat(productResult.getName()).isEqualTo("상품1");
        assertThat(productResult.getPrice()).isEqualTo(1000);
        assertThat(productResult.getStock()).isEqualTo(100);

        verify(productQuery, times(1)).toProductInfo(product);
    }

}