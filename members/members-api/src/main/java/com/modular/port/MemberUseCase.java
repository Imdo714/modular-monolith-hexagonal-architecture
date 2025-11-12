package com.modular.port;

import com.modular.dto.member.MemberInfo;
import com.modular.dto.request.CreateMemberDto;

public interface MemberUseCase { // Member-api-Modular
    void callMember();

    MemberInfo getMemberInfo();

    MemberInfo registerMember(CreateMemberDto createMemberDto);
}
