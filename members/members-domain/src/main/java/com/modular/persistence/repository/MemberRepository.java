package com.modular.persistence.repository;

import com.modular.entity.Member;

import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(String memberId);
}
