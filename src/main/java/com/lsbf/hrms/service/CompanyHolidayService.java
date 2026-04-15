package com.lsbf.hrms.service;

import com.lsbf.hrms.model.CompanyHoliday;
import com.lsbf.hrms.repository.CompanyHolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyHolidayService {

    @Autowired
    private CompanyHolidayRepository companyHolidayRepository;

    public List<CompanyHoliday> getAllHolidays() {
        return companyHolidayRepository.findAll();
    }

    public Optional<CompanyHoliday> getHolidayById(Long id) {
        return companyHolidayRepository.findById(id);
    }

    public CompanyHoliday saveHoliday(CompanyHoliday holiday) {
        return companyHolidayRepository.save(holiday);
    }

    public void deleteHoliday(Long id) {
        companyHolidayRepository.deleteById(id);
    }
}
