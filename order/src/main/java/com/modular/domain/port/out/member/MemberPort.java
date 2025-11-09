package com.modular.domain.port.out.member;

import com.modular.dto.member.MemberInfo;

public interface MemberPort { // Order-Modular port.out
    MemberInfo getMemberInfo(String memberId);
}
