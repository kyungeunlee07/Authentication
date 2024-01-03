package com.example.authentication.dto;

import lombok.Getter;

@Getter
public enum Code {
    SUCCESS(200, "select success"),
    FAILED(400, "select fail");

    private final int status;
    private final String message;

    Code(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
