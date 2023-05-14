package com.wayahead.arrivechat.repository;

import com.wayahead.arrivechat.table.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Optional<Admin> findByEmployeeId(String employeeId);
}
