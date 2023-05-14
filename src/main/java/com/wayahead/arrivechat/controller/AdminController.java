package com.wayahead.arrivechat.controller;

import com.wayahead.arrivechat.request.AdminLoginRequest;
import com.wayahead.arrivechat.request.AdminSignupRequest;
import com.wayahead.arrivechat.response.AdminChatResponse;
import com.wayahead.arrivechat.response.AdminLoginResponse;
import com.wayahead.arrivechat.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/arriveChat/admin")
@RequiredArgsConstructor
@RestController
public class AdminController {
    private final AdminService adminService;

    @PostMapping("/signup")
    public void adminSignup(@RequestBody AdminSignupRequest adminSignupRequest) {
        adminService.adminSignup(adminSignupRequest);
    }

    @PostMapping("/login")
    public AdminLoginResponse adminLogin(@RequestBody AdminLoginRequest adminLoginRequest) {
        return adminService.adminLogin(adminLoginRequest);
    }

    @GetMapping("/chats")
    public List<AdminChatResponse> getAllChats() {
        return adminService.getAllChats();
    }
}
