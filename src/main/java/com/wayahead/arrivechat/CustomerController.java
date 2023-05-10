package com.wayahead.arrivechat;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/arriveChat/customer")
@RestController
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    @PostMapping("/addChat")
    public void addMessages(@RequestBody AddMessageRequest request) {
        customerService.addMessage(request);
    }

    @PostMapping("/addCustomer")
    public void addUser(@RequestBody Customer request) {
        customerService.addUser(request);
    }
    @GetMapping("/getChat")
    public List<Messages> getMessages(@RequestParam String sessionId) {
        return customerService.getMessagesByUserId(sessionId);
    }
}
