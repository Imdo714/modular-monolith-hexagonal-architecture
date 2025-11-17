package com.modular.service.external;

import com.modular.dto.member.MemberInfo;
import com.modular.entity.Member;
import com.modular.port.external.ExternalMemberUseCase;
import com.modular.persistence.query.MemberQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberExternalServiceImpl implements ExternalMemberUseCase {

    private final MemberQuery memberQuery;

    @Override
    public MemberInfo getMemberById(String memberId) {
        Member member = memberQuery.findMemberById(memberId);
        return memberQuery.toMemberInfo(member);
    }

}
