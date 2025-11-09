package com.modular.adapter.in;

import com.modular.doamin.entity.Member;
import com.modular.doamin.port.in.MemberManagementUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberManagementUseCase memberManagementUseCase;

    @PostMapping
    public ResponseEntity<String> register() {
        Member member = new Member("임도현", "email@naver.com");
        memberManagementUseCase.registerMember(member);
        return ResponseEntity.ok("OK");
    }
}
