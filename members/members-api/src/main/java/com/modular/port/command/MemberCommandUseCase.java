package com.modular.port.command;

import com.modular.dto.member.MemberInfo;
import com.modular.dto.request.CreateMemberDto;

public interface MemberCommandUseCase {
    MemberInfo registerMember(CreateMemberDto createMemberDto);
}
