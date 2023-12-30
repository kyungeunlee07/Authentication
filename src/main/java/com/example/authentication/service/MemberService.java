package com.example.authentication.service;

import com.example.authentication.dto.request.LoginRequest;
import com.example.authentication.dto.response.LoginResponse;
import com.example.authentication.entity.Member;
import com.example.authentication.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public LoginResponse login(LoginRequest loginRequest) {

        Member member = memberRepository.findMemberById(loginRequest.getId())
                .orElseThrow(() -> new RuntimeException("Member not found for ID: " + loginRequest.getId().toString()));

        return new LoginResponse(member);

    }
}
