package com.modular.service;

import com.modular.dto.member.MemberInfo;
import com.modular.dto.request.CreateMemberDto;
import com.modular.entity.Member;
import com.modular.repository.MemberRepository;
import com.modular.query.MemberQuery;
import com.modular.service.command.MemberCommandServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class MemberCommandServiceImplTest {

    private MemberCommandServiceImpl memberCommandServiceImpl;
    private MemberRepository memberRepository;
    private MemberQuery memberQuery;

    @BeforeEach
    void setUp() {
        memberRepository = mock(MemberRepository.class);
        memberQuery = mock(MemberQuery.class);

        // Mock 주입
        memberCommandServiceImpl = new MemberCommandServiceImpl(memberRepository, memberQuery);
    }

    @DisplayName("")
    @Test
    void test() {
        // given
        CreateMemberDto dto = new CreateMemberDto("홍길동", "email@test.com");
        Member member = new Member("홍길동", "email@test.com");

        when(memberRepository.save(any(Member.class)))
                .thenReturn(member);

        when(memberQuery.toMemberInfo(member))
                .thenReturn(new MemberInfo("member-123", "홍길동", "email@test.com"));

        // when
        MemberInfo memberInfo = memberCommandServiceImpl.registerMember(dto);

        // then
        assertThat(memberInfo).isNotNull();
        assertThat(memberInfo.getName()).isEqualTo("홍길동");
        assertThat(memberInfo.getEmail()).isEqualTo("email@test.com");

        verify(memberRepository, times(1)).save(any(Member.class));
        verify(memberQuery, times(1)).toMemberInfo(member);
    }
}