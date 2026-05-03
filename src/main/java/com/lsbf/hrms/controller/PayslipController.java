package com.lsbf.hrms.controller;

import com.lsbf.hrms.model.Payslip;
import com.lsbf.hrms.service.PayslipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth/payslip")
public class PayslipController {

    @Autowired
    private PayslipService payslipService;

    @GetMapping("/fetch")
    public List<Payslip> getAllPayslips() {
        return payslipService.getAllPayslips();
    }

    @PostMapping
    public Payslip createPayslip(@RequestBody Payslip payslip) {
        return payslipService.savePayslip(payslip);
    }



/*
    @GetMapping("/{id}")
    public Payslip getPayslipById(@PathVariable Long id) {
        return payslipService.getPayslipById(id).orElse(null);
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
*/
}
