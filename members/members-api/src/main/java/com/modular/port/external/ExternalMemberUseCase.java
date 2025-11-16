package com.modular.port.external;

import com.modular.dto.member.MemberInfo;

public interface ExternalMemberUseCase {
    // 외부에서 내부를 들어오는 인터페이스
    MemberInfo getMemberById(String memberId);
}
