package com.modular.port.out;

import com.modular.dto.member.MemberInfo;

public interface MemberPort {
    MemberInfo getMemberById(String memberId);
}
