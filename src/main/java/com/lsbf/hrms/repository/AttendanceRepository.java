package com.lsbf.hrms.repository;

import com.lsbf.hrms.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
}
