package com.modular.port;

import com.modular.dto.member.MemberInfo;
import com.modular.dto.request.CreateMemberDto;

public interface MemberUseCase { // Member-api-Modular
    // 내부에서 내부 호춣하는 인터페이스

    MemberInfo getMemberById(String memberId);

    MemberInfo registerMember(CreateMemberDto createMemberDto);
}
