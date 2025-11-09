package com.modular.doamin.port.out;

import com.modular.doamin.entity.Member;

import java.util.Optional;

public interface MemberRepository {
    void save(Member member);
    Optional<Member> findById(String id);
}
