package com.wayahead.arrivechat.repository;

import com.wayahead.arrivechat.table.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findBySessionId(String sessionId);
}
