package com.modular.query;

import com.modular.dto.member.MemberInfo;
import com.modular.entity.Member;
import com.modular.persistence.query.MemberQuery;
import com.modular.persistence.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberQueryImpl implements MemberQuery {

    private final MemberRepository memberRepository;

    @Override
    public Member findMemberById(String memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("회원 없음"));
    }

    @Override
    public MemberInfo toMemberInfo(Member member) {
        return new MemberInfo(member.getId(), member.getName(), member.getEmail());
    }

}
