package com.modular.adapter;

import com.modular.dto.member.MemberInfo;
import com.modular.port.external.ExternalMemberUseCase;
import com.modular.port.out.MemberPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberAdapter implements MemberPort {

    private final ExternalMemberUseCase externalMemberUseCase;

    @Override
    public MemberInfo getMemberById(String memberId) {
        return externalMemberUseCase.getMemberById(memberId);
    }
}
