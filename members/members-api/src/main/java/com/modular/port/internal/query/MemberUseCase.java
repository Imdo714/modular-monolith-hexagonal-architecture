package com.modular.port.internal.query;

import com.modular.dto.member.MemberInfo;
import com.modular.dto.order.OrderHistoryDto;

import java.util.List;

public interface MemberUseCase { // Member-api-Modular
    // 내부에서 내부 호춣하는 인터페이스
    MemberInfo getMemberById(String memberId);
    List<OrderHistoryDto> getMemberOrderHistory(String memberId);
}
