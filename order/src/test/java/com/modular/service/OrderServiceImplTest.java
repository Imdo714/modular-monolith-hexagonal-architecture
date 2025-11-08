package com.modular.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class OrderServiceImplTest {

    private OrderServiceImpl orderService;
    private MemberReader memberReader;

    @BeforeEach
    void setUp() {
        memberReader = mock(MemberReader.class);
        orderService = new OrderServiceImpl(memberReader);
    }

    @DisplayName("단위 : 회원이 존재하면 주문저장")
    @Test
    void createOrder() {
        // given
        when(memberReader.existsById("임도현")).thenReturn(true);

        // when & then
        assertDoesNotThrow(() -> orderService.createOrder());
    }

    @DisplayName("단위 : 회원이 없으면 예외발생")
    @Test
    void createOrder_exception() {
        // given
        when(memberReader.existsById("임도현")).thenReturn(false);

        // when & then
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> orderService.createOrder()
        );

        assertEquals("존재하지 않는 회원입니다.", exception.getMessage());
    }


}