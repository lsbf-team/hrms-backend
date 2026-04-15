package com.lsbf.hrms.controller;

import com.lsbf.hrms.model.Designation;
import com.lsbf.hrms.service.DesignationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth/designations")
public class DesignationController {

    @Autowired
    private DesignationService designationService;

    @GetMapping
    public List<Designation> getAllDesignations() {
        return designationService.getAllDesignations();
    }

    @GetMapping("/{id}")
    public Designation getDesignationById(@PathVariable Long id) {
        return designationService.getDesignationById(id).orElse(null);
    }

    @PostMapping
    public Designation createDesignation(@RequestBody Designation designation) {
        return designationService.saveDesignation(designation);
    }

    @PutMapping("/{id}")
    public Designation updateDesignation(@PathVariable Long id, @RequestBody Designation designation) {
        designation.setId(id);
        return designationService.saveDesignation(designation);
    }

    @DeleteMapping("/{id}")
    public void deleteDesignation(@PathVariable Long id) {
        designationService.deleteDesignation(id);
    }
}
