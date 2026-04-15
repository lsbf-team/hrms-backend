package com.lsbf.hrms.controller;

import com.lsbf.hrms.model.CompanyHoliday;
import com.lsbf.hrms.service.CompanyHolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/holidays")
public class CompanyHolidayController {

    @Autowired
    private CompanyHolidayService companyHolidayService;

    @GetMapping
    public List<CompanyHoliday> getAllHolidays() {
        return companyHolidayService.getAllHolidays();
    }

    @GetMapping("/{id}")
    public CompanyHoliday getHolidayById(@PathVariable Long id) {
        return companyHolidayService.getHolidayById(id).orElse(null);
    }

    @PostMapping
    public CompanyHoliday createHoliday(@RequestBody CompanyHoliday holiday) {
        return companyHolidayService.saveHoliday(holiday);
    }

    @PutMapping("/{id}")
    public CompanyHoliday updateHoliday(@PathVariable Long id, @RequestBody CompanyHoliday holiday) {
        holiday.setId(id);
        return companyHolidayService.saveHoliday(holiday);
    }

    @DeleteMapping("/{id}")
    public void deleteHoliday(@PathVariable Long id) {
        companyHolidayService.deleteHoliday(id);
    }
}
