package com.example.authentication.service;

import com.example.authentication.entity.Member;
import com.example.authentication.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService {
    private final MemberRepository memberRepository;

    public UserDetailsService userDetailsService() {

        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return memberRepository.findMemberById(username)
                        .map(this::createUserDetails)
                        .orElseThrow(() -> new UsernameNotFoundException("해당하는 회원을 찾을 수 없습니다."));
            }

            private UserDetails createUserDetails(Member member) {
                return User.builder()
                        .username(member.getId())
                        .password(member.getPassword())
                        .build();
            }
        };
    }
};
