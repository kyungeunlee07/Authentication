package com.example.authentication.service;

import com.example.authentication.dto.response.TokenResponse;
import com.example.authentication.dto.request.LoginRequest;
import com.example.authentication.entity.Member;
import com.example.authentication.jwt.JwtTokenProvider;
import com.example.authentication.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    @Transactional
    public TokenResponse login(LoginRequest loginRequest) {
        Member member = memberRepository.findMemberById(loginRequest.getId())
                .orElseThrow(() -> new RuntimeException("Member not found for ID: " + loginRequest.getId().toString()));
        UsernamePasswordAuthenticationToken authenticationToken = loginRequest.toAuthentication();
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        return jwtTokenProvider.generateToken(authentication, member.getId());
    }
}
