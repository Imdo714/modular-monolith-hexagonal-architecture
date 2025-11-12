package com.modular.controller;

import com.modular.dto.member.MemberInfo;
import com.modular.dto.request.CreateMemberDto;
import com.modular.port.MemberUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberUseCase memberUseCase;

    @PostMapping
    public ResponseEntity<MemberInfo> save(@RequestBody CreateMemberDto  createMemberDto) {
        return ResponseEntity.ok(memberUseCase.registerMember(createMemberDto));
    }

    @GetMapping("/test")
    public ResponseEntity<MemberInfo> getMember() {
        return ResponseEntity.ok(memberUseCase.getMemberInfo());
    }
}
