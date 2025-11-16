package com.modular.service.internal;

import com.modular.dto.member.MemberInfo;
import com.modular.dto.order.OrderHistoryDto;
import com.modular.entity.Member;
import com.modular.port.internal.MemberUseCase;
import com.modular.port.out.OrderPort;
import com.modular.query.MemberQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberUseCase { // Member-service-Modular

    private final MemberQuery memberQuery;
    private final OrderPort orderPort;

    @Override
    public MemberInfo getMemberById(String memberId) {
        Member member = memberQuery.findMemberById(memberId);
        return memberQuery.toMemberInfo(member);
    }

    @Override
    public List<OrderHistoryDto> getMemberOrderHistory(String memberId) {
        return orderPort.getOrderHistory(memberId);
    }
}
