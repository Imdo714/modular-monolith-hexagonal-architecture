package com.modular.doamin.port.in;

import com.modular.dto.member.MemberInfo;

public interface MemberInternalUseCase { // Member-Modular port.in
    
    // Member 모듈의 기능을 쓰고 싶으면, 이 인터페이스의 규칙대로 호출해! 라고 외부에 약속(Contract)을 제공

    /**
     * memberId로 멤버 정보를 조회합니다.
     */
    MemberInfo getMemberInfo(String memberId);
}
