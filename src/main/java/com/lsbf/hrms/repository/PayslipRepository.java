package com.lsbf.hrms.repository;

import com.lsbf.hrms.model.Payslip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayslipRepository extends JpaRepository<Payslip, Long> {
}
