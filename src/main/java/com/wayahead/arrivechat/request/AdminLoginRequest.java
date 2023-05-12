package com.wayahead.arrivechat.request;

public record AdminLoginRequest (
        String employeeId,
        String language,
        String password
) {}
