package com.wayahead.arrivechat.request;

public record AdminSignupRequest(
        String name,
        String employeeId,
        String password
) {}
