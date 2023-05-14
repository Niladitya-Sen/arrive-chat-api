package com.wayahead.arrivechat.service;

import com.wayahead.arrivechat.repository.AdminRepository;
import com.wayahead.arrivechat.repository.CustomerRepository;
import com.wayahead.arrivechat.repository.MessageRepository;
import com.wayahead.arrivechat.request.AdminLoginRequest;
import com.wayahead.arrivechat.request.AdminSignupRequest;
import com.wayahead.arrivechat.response.AdminChatResponse;
import com.wayahead.arrivechat.response.AdminLoginResponse;
import com.wayahead.arrivechat.table.Admin;
import com.wayahead.arrivechat.table.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepository adminRepository;
    private final CustomerRepository customerRepository;
    private final MessageRepository messageRepository;
    public AdminLoginResponse adminLogin(AdminLoginRequest adminLoginRequest) {
        var admin = adminRepository.findByEmployeeId(adminLoginRequest.employeeId());
        if (admin.isEmpty()) {
            return new AdminLoginResponse (
                    false
            );
        }
        if (admin.get().getPassword().equals(adminLoginRequest.password()) && admin.get().getEmployeeId().equals(adminLoginRequest.employeeId())) {
            admin.get().setLanguage(adminLoginRequest.language());
            adminRepository.save(admin.get());
            return new AdminLoginResponse (
                    true
            );
        } else {
            return new AdminLoginResponse (
                    false
            );
        }
    }

    public List<AdminChatResponse> getAllChats() {
        ArrayList<AdminChatResponse> adminChatResponses = new ArrayList<>();
        var customers = customerRepository.findAll();
        customers.forEach(customer -> adminChatResponses.add(new AdminChatResponse (
                customer.getSessionId(),
                messageRepository.findByUserId(customer.getId())
        )));
        return adminChatResponses;
    }

    public void adminSignup(AdminSignupRequest adminSignupRequest) {
        adminRepository.save(
                Admin.builder()
                        .name(adminSignupRequest.name())
                        .employeeId(adminSignupRequest.employeeId())
                        .password(adminSignupRequest.password())
                        .role(Role.ADMIN)
                        .build()
        );
    }
}
