package com.modular.controller;

import com.modular.dto.member.MemberInfo;
import com.modular.dto.order.OrderHistoryDto;
import com.modular.dto.request.CreateMemberDto;
import com.modular.port.command.MemberCommandUseCase;
import com.modular.port.internal.MemberUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberUseCase memberUseCase;
    private final MemberCommandUseCase memberCommandUseCase;

    @PostMapping
    public ResponseEntity<MemberInfo> save(@RequestBody CreateMemberDto  createMemberDto) {
        return ResponseEntity.ok(memberCommandUseCase.registerMember(createMemberDto));
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<MemberInfo> getMember(@PathVariable String memberId) {
        return ResponseEntity.ok(memberUseCase.getMemberById(memberId));
    }

    @GetMapping("/{memberId}/orders")
    public ResponseEntity<List<OrderHistoryDto>> getMemberOrderHistory(@PathVariable String memberId) {
        return ResponseEntity.ok(memberUseCase.getMemberOrderHistory(memberId));
    }
}
