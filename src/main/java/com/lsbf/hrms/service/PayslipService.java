package com.lsbf.hrms.service;

import com.lsbf.hrms.model.Payslip;
import com.lsbf.hrms.repository.PayslipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PayslipService {

    @Autowired
    private PayslipRepository payslipRepository;

    public List<Payslip> getAllPayslips() {
        return payslipRepository.findAll();
    }

    public Optional<Payslip> getPayslipById(Long id) {
        return payslipRepository.findById(id);
    }

    public Payslip savePayslip(Payslip payslip) {
        return payslipRepository.save(payslip);
    }

    public void deletePayslip(Long id) {
        payslipRepository.deleteById(id);
    }
}
