package com.modular.data;

import com.modular.doamin.entity.Member;
import com.modular.doamin.entity.MemberRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryMemberRepository implements MemberRepository {
    private final Map<String, Member> store = new ConcurrentHashMap<>();


}
