package com.modular.data;

import com.modular.entity.Member;

import java.util.Optional;

public interface MemberRepository {
    void save(Member member);
    Optional<Member> findById(String memberId);
}
