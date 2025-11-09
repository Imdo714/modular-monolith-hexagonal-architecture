package com.modular.doamin.port.in;

import com.modular.doamin.entity.Member;

public interface MemberManagementUseCase { // Member-Modular port.in
    
    // 관리자나 외부 API가 멤버를 관리하기 위해 호출하는 인터페이스

    /**
     * 회원 등록
     */
    void registerMember(Member member);
}
