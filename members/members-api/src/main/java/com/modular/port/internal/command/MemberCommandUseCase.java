package com.modular.port.internal.command;

import com.modular.dto.member.MemberInfo;
import com.modular.dto.request.CreateMemberDto;

public interface MemberCommandUseCase {
    MemberInfo registerMember(CreateMemberDto createMemberDto);
}
