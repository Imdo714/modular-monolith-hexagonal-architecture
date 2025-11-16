package com.modular.service.command;

import com.modular.dto.member.MemberInfo;
import com.modular.dto.request.CreateMemberDto;
import com.modular.entity.Member;
import com.modular.repository.MemberRepository;
import com.modular.port.command.MemberCommandUseCase;
import com.modular.query.MemberQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandUseCase {

    private final MemberRepository memberRepository;
    private final MemberQuery memberQuery;


    @Override
    public MemberInfo registerMember(CreateMemberDto createMemberDto) {
        Member member = new Member(createMemberDto.getName(), createMemberDto.getEmail());
        Member savedMember = memberRepository.save(member);
        return memberQuery.toMemberInfo(savedMember);
    }
}
