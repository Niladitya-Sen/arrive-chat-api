package com.wayahead.arrivechat.repository;

import com.wayahead.arrivechat.table.Messages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MessageRepository extends JpaRepository<Messages, Long> {
    List<Messages> findByUserId(Long userId);
}
