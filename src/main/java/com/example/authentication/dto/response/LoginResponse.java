package com.example.authentication.dto.response;
import com.example.authentication.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class LoginResponse {

    private String id;
    private String password;
    private Date loginedAt;

    public LoginResponse(Member member) {
        this.id = member.getId();
        this.password = member.getPassword();
        this.loginedAt = member.getLoginedAt();
    }
}
