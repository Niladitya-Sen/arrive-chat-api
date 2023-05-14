package com.wayahead.arrivechat.service;

import com.wayahead.arrivechat.table.Role;
import com.wayahead.arrivechat.repository.CustomerRepository;
import com.wayahead.arrivechat.repository.MessageRepository;
import com.wayahead.arrivechat.request.AddMessageRequest;
import com.wayahead.arrivechat.table.Customer;
import com.wayahead.arrivechat.table.Messages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final MessageRepository messageRepository;

    public List<Messages> getMessagesBySessionId(String sessionId) {
        return messageRepository.findByUserId(customerRepository.findBySessionId(sessionId).orElse(new Customer()).getId());
    }

    public void addMessage(AddMessageRequest request) {
        var customer = customerRepository.findBySessionId(request.sessionId());

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
