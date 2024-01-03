package com.example.authentication.controller;

import com.example.authentication.dto.request.LoginRequest;
import com.example.authentication.dto.request.MemberRequest;
import com.example.authentication.dto.response.MemberResponse;
import com.example.authentication.dto.response.TokenResponse;
import com.example.authentication.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/members")
public class MemberController {

    private final MemberService memberService;
    @PostMapping
    public TokenResponse login(@RequestBody LoginRequest loginRequest) {
        return memberService.login(loginRequest);
    }

    @GetMapping
    public MemberResponse getMemberInfo(@RequestBody MemberRequest memberRequest) {
        return memberService.getMemberInfo(memberRequest);
    }
}
