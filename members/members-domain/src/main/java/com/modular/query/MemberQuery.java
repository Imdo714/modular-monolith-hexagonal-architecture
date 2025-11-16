package com.modular.query;

import com.modular.dto.member.MemberInfo;
import com.modular.entity.Member;

public interface MemberQuery {
    Member findMemberById(String memberId);
    MemberInfo toMemberInfo(Member member);
}
