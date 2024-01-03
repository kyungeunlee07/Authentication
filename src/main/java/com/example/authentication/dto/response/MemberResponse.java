package com.example.authentication.dto.response;

import com.example.authentication.dto.Code;
import com.example.authentication.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class MemberResponse {
    private final Date result;
    private final int rtnCd;
    private final String rtnMsg;

    public MemberResponse(Member member, Code code){
        if(code.getStatus() == 400) {
            this.result = null;
            this.rtnCd = code.getStatus();
            this.rtnMsg = code.getMessage();
        }else {
            this.result = member.getLoginedAt();
            this.rtnCd = code.getStatus();
            this.rtnMsg = code.getMessage();
        }
    }
}