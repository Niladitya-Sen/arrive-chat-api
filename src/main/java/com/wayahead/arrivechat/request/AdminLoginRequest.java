package com.wayahead.arrivechat.request;

public record AdminLoginRequest (
        String name,
        String employeeId,
        String password
) {}
