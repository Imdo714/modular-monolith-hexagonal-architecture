package com.modular.memory;

import com.modular.entity.Member;
import com.modular.persistence.repository.MemberRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryMemberRepository implements MemberRepository {

    private final Map<String, Member> data = new ConcurrentHashMap<>();

    @Override
    public Member save(Member member) {
        data.put(Objects.requireNonNull(member).getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(String id) {
        return Optional.ofNullable(data.get(id));
    }
}
