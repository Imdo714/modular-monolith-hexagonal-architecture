package com.modular;

import com.modular.dto.member.MemberInfo;
import com.modular.dto.order.OrderHistoryDto;
import com.modular.entity.Member;
import com.modular.port.out.OrderPort;
import com.modular.query.MemberQuery;
import com.modular.service.internal.MemberServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

class MemberServiceImplTest {

    private MemberServiceImpl memberServiceImpl;
    private MemberQuery memberQuery;
    private OrderPort orderPort;

    @BeforeEach
    void setUp() {
        // Mock 객체 생성
        memberQuery = mock(MemberQuery.class);
        orderPort = mock(OrderPort.class);

        // Mock 주입
        memberServiceImpl = new MemberServiceImpl(memberQuery, orderPort);
    }

    @DisplayName("getMemberById_회원_조회_성공")
    @Test
    void getMemberById() {
        // given
        Member member = new Member("홍길동", "email@test.com");
        when(memberQuery.findMemberById("member-123")).thenReturn(member);
        when(memberQuery.toMemberInfo(member))
                .thenReturn(new MemberInfo("member-123", "홍길동", "email@test.com"));

        // when
        MemberInfo result = memberServiceImpl.getMemberById("member-123");

        // then
        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo("홍길동");
        assertThat(result.getEmail()).isEqualTo("email@test.com");

        verify(memberQuery, times(1)).findMemberById("member-123");
        verify(memberQuery, times(1)).toMemberInfo(member);
    }

    @DisplayName("getMemberById_회원_조회시_예외발생")
    @Test
    void getMemberById_exception() {
        // given
        when(memberQuery.findMemberById("member-123"))
                .thenThrow(new IllegalArgumentException("회원 없음"));

        // when & then
        assertThatThrownBy(() -> memberServiceImpl.getMemberById("member-123"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("회원 없음");

        verify(memberQuery, times(1)).findMemberById("member-123");
    }

    @DisplayName("getMemberOrderHistory_회원의_주문_이력_조회_성공")
    @Test
    void getMemberOrderHistory() {
        // given
        List<OrderHistoryDto> history = List.of(
                new OrderHistoryDto("order1", "member-123", "product-123", 5),
                new OrderHistoryDto("order2", "member-123", "product-32", 2)
        );

        when(orderPort.getOrderHistory("member-123"))
                .thenReturn(history);

        // when
        List<OrderHistoryDto> result = memberServiceImpl.getMemberOrderHistory("member-123");

        // then
        assertThat(result).hasSize(2);
        verify(orderPort, times(1)).getOrderHistory("member-123");
    }
}