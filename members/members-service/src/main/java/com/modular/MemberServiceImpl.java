package com.modular;

import com.modular.dto.member.MemberInfo;
import com.modular.dto.request.CreateMemberDto;
import com.modular.entity.Member;
import com.modular.data.MemberRepository;
import com.modular.port.ExternalMemberUseCase;
import com.modular.port.MemberUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberUseCase, ExternalMemberUseCase { // Member-service-Modular

    private final MemberRepository memberRepository;

    @Override
    public MemberInfo getMemberById(String memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("회원 없음"));

        return toMemberInfo(member);
    }

    @Override
    public MemberInfo registerMember(CreateMemberDto createMemberDto) {
        Member member = new Member(createMemberDto.getEmail(), createMemberDto.getName());
        Member savedMember = memberRepository.save(member);

        return toMemberInfo(savedMember);
    }

    private MemberInfo toMemberInfo(Member member) {
        return new MemberInfo(member.getId(), member.getName(),  member.getEmail());
    }
}
