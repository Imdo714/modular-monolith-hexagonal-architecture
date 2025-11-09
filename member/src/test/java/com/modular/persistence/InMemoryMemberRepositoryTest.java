package com.modular.persistence;

import com.modular.adapter.out.persistence.InMemoryMemberRepository;
import com.modular.doamin.entity.Member;
import com.modular.doamin.port.out.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class InMemoryMemberRepositoryTest {

    private MemberRepository memberRepository;

    @BeforeEach
    void setUp() {
        memberRepository = new InMemoryMemberRepository();
    }

    @DisplayName("상품을 생성하고 ID로 조회하면 해당 상품이 반환된다.")
    @Test
    void save() {
        // given
        Member member = new Member("임도현", "email@naver.com");
        String memberId = member.getId();

        // when
        memberRepository.save(member);
        Optional<Member> foundMember = memberRepository.findById(memberId);

        // then
        assertThat(foundMember).isPresent();
        assertThat(foundMember.get().getId()).isEqualTo(memberId);
        assertThat(foundMember.get().getName()).isEqualTo("임도현");
        assertThat(foundMember.get().getEmail()).isEqualTo("email@naver.com");
    }

}