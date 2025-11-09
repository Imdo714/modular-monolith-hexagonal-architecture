package com.modular.application.service;

import com.modular.doamin.entity.Member;
import com.modular.doamin.port.in.MemberInternalUseCase;
import com.modular.doamin.port.out.MemberRepository;
import com.modular.doamin.port.in.MemberManagementUseCase;
import com.modular.dto.member.MemberInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberManagementUseCase, MemberInternalUseCase {

    private final MemberRepository memberRepository;

    @Override
    public void registerMember(Member member) {
        memberRepository.save(member);
    }

    @Override
    public MemberInfo getMemberInfo(String memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("회원 없음"));

        return new MemberInfo(member.getId(), member.getName());
    }

}
