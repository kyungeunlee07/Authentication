package com.example.authentication.controller;

import com.example.authentication.dto.request.LoginRequest;
import com.example.authentication.dto.response.LoginResponse;
import com.example.authentication.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/members")
public class MemberController {

    private final MemberService memberService;
    @PostMapping
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {

        return memberService.login(loginRequest);
    }

}
