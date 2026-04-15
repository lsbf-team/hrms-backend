package com.lsbf.hrms.repository;

import com.lsbf.hrms.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
