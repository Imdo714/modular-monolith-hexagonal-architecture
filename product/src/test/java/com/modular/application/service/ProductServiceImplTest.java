package com.modular.application.service;

import com.modular.domain.entity.Product;
import com.modular.domain.port.in.ProductInternalUseCase;
import com.modular.domain.port.in.ProductManagementUseCase;
import com.modular.domain.port.out.product.ProductRepository;
import com.modular.dto.product.ProductInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

class ProductServiceImplTest {

    private ProductRepository productRepository;
    private ProductInternalUseCase productInternalUseCase;
    private ProductManagementUseCase productManagementUseCase;

    @BeforeEach
    void setUp() {
        // Mock 객체 생성
        productRepository = mock(ProductRepository.class);

        // Mock 주입
        productInternalUseCase = new ProductServiceImpl(productRepository);
        productManagementUseCase = new ProductServiceImpl(productRepository);
    }

    @DisplayName("상품 재고가 정상적으로 감소하고 정보가 반환된다")
    @Test
    void decreaseStock_Success() {
        // given
        Product product = new Product("테스트 상품", 10000, 10);
        when(productRepository.findById(product.getId()))
                .thenReturn(Optional.of(product));

        // when
        ProductInfo resultInfo = productInternalUseCase.decreaseStock(product.getId(), 3);

        // then
        assertThat(resultInfo).isNotNull();
        assertThat(resultInfo.getName()).isEqualTo("테스트 상품");
        assertThat(resultInfo.getPrice()).isEqualTo(10000);

        //  productRepository.save(product); 할때 인자 값 product 가져 오기
        ArgumentCaptor<Product> productCaptor = ArgumentCaptor.forClass(Product.class);

        Product savedProduct = productCaptor.getValue();
        assertThat(savedProduct.getStock()).isEqualTo(7);
        verify(productRepository, times(1)).save(productCaptor.capture());
    }

    @DisplayName("재고 감소 실패: 상품의 재고보다 많은 수량을 요청 시 예외가 발생한다")
    @Test
    void decreaseStock_Fail_OutOfStock() {
        // given
        Product product = new Product("재고 부족 상품", 10000, 1);
        when(productRepository.findById(product.getId()))
                .thenReturn(Optional.of(product));

        // when then
        assertThatThrownBy(() -> {
            productInternalUseCase.decreaseStock(product.getId(), 3);
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("재고가 부족합니다.");

        // 도메인 로직에서 실패해서 save 메서드 호출이 안되어야 함
        verify(productRepository, never()).save(any(Product.class));
    }
}