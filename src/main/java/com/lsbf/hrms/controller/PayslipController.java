package com.lsbf.hrms.controller;

import com.lsbf.hrms.model.Payslip;
import com.lsbf.hrms.service.PayslipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payslips")
public class PayslipController {

    @Autowired
    private PayslipService payslipService;

    @GetMapping
    public List<Payslip> getAllPayslips() {
        return payslipService.getAllPayslips();
    }

    @GetMapping("/{id}")
    public Payslip getPayslipById(@PathVariable Long id) {
        return payslipService.getPayslipById(id).orElse(null);
    }

    @PostMapping
    public Payslip createPayslip(@RequestBody Payslip payslip) {
        return payslipService.savePayslip(payslip);
    }

    @PutMapping("/{id}")
    public Payslip updatePayslip(@PathVariable Long id, @RequestBody Payslip payslip) {
        payslip.setId(id);
        return payslipService.savePayslip(payslip);
    }

    @DeleteMapping("/{id}")
    public void deletePayslip(@PathVariable Long id) {
        payslipService.deletePayslip(id);
    }
}
