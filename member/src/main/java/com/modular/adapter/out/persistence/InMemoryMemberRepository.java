package com.modular.adapter.out.persistence;

import com.modular.doamin.entity.Member;
import com.modular.doamin.port.out.MemberRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryMemberRepository implements MemberRepository {
    private final Map<String, Member> data = new ConcurrentHashMap<>();

    @Override
    public void save(Member member) {
        data.put(Objects.requireNonNull(member).getId(), member);
    }

    @Override
    public Optional<Member> findById(String id) {
        return Optional.ofNullable(data.get(id));
    }


}
