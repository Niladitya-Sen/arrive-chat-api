package com.wayahead.arrivechat;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final MessageRepository messageRepository;

    public List<Messages> getMessagesByUserId(String sessionId) {
        return messageRepository.findByUserId(customerRepository.findBySessionId(sessionId).orElseThrow().getId());
    }

    public void addMessage(AddMessageRequest request) {
        var customer = customerRepository.findBySessionId(request.sessionId());
        System.out.println(request.language() + request.sessionId());
        if (customer.isPresent()) {
            var newMessage = Messages.builder()
                    .userId(customer.get().getId())
                    .msgBy(request.msgBy())
                    .text(request.text())
                    .language(request.language())
                    .time(request.time())
                    .build();
            messageRepository.save(newMessage);
        }
    }

    public void addUser(Customer request) {
        var user = Customer.builder()
                .sessionId(request.getSessionId())
                .language(request.getLanguage())
                .role(Role.CUSTOMER)
                .build();
        customerRepository.save(user);
    }
}
