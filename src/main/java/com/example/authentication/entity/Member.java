package com.example.authentication.entity;

import io.jsonwebtoken.Claims;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    private String id;
    private String password;
    private Date loginedAt;

    public Member(String id, String password, Date loginedAt) {
        this.id = id;
        this.password = password;
        this.loginedAt = loginedAt;
    }

    public Member(Claims claims) {
        this.id = claims.get("id").toString();
    }

    public void encodePassword(PasswordEncoder passwordEncoder){
        this.password = passwordEncoder.encode(password);
    }
}
