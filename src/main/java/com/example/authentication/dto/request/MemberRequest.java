package com.example.authentication.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberRequest {

    private String id;
    private String password;
    private String accessToken;
}
