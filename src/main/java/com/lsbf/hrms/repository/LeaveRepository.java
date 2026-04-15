package com.lsbf.hrms.repository;

import com.lsbf.hrms.model.Leave;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveRepository extends JpaRepository<Leave, Long> {
}
