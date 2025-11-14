package com.modular;

import com.modular.data.MemberRepository;
import com.modular.dto.member.MemberInfo;
import com.modular.dto.request.CreateMemberDto;
import com.modular.entity.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

class MemberServiceImplTest {

    private MemberServiceImpl memberServiceImpl;
    private MemberRepository memberRepository;

    @BeforeEach
    void setUp() {
        // Mock 객체 생성
        memberRepository = mock(MemberRepository.class);

        // Mock 주입
        memberServiceImpl = new MemberServiceImpl(memberRepository);
    }

    @DisplayName("getMemberById_회원_조회_성공")
    @Test
    void getMemberById() {
        // given
        Member member = new Member("홍길동", "email@test.com");
        when(memberRepository.findById("1"))
                .thenReturn(Optional.of(member));

        // when
        MemberInfo result = memberServiceImpl.getMemberById("1");

        // then
        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo("홍길동");
        assertThat(result.getEmail()).isEqualTo("email@test.com");
        verify(memberRepository, times(1)).findById("1");
    }

    @DisplayName("getMemberById_회원_조회시_예외발생")
    @Test
    void getMemberById_exception() {
        // given
        when(memberRepository.findById("1"))
                .thenReturn(Optional.empty());

        // when & then
        assertThatThrownBy(() -> memberServiceImpl.getMemberById("1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("회원 없음");

        verify(memberRepository, times(1)).findById("1");
    }

    @DisplayName("registerMember_회원_추가_성공_로직")
    @Test
    void registerMember() {
        // given
        CreateMemberDto dto = new CreateMemberDto("홍길동", "email@test.com");

        Member member = new Member(dto.getName(), dto.getEmail());

        when(memberRepository.save(any(Member.class)))
                .thenReturn(member);

        // when
        MemberInfo result = memberServiceImpl.registerMember(dto);

        // then
        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo("홍길동");
        assertThat(result.getEmail()).isEqualTo("email@test.com");
        verify(memberRepository, times(1)).save(any(Member.class));
    }
}