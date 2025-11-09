package com.modular.adapter.out.member;

import com.modular.doamin.port.in.MemberInternalUseCase;
import com.modular.domain.port.out.member.MemberPort;
import com.modular.dto.member.MemberInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberAdapter implements MemberPort { // Order-Modular adapter.out
    
    // Member-Modular port.in 을 주입 받음
    private final MemberInternalUseCase memberInternalUseCase;

    @Override
    public MemberInfo getMemberInfo(String memberId) {
        return memberInternalUseCase.getMemberInfo(memberId);
    }
}
