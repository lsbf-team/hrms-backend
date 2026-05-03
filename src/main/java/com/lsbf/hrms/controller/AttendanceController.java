package com.lsbf.hrms.controller;

import com.lsbf.hrms.model.Attendance;
import com.lsbf.hrms.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @GetMapping("/fetch")
    public List<Attendance> getAllAttendances() {
        return attendanceService.getAllAttendances();
    }


    @PostMapping("/check-in")
    public Attendance checkIn(@RequestBody Attendance attendance) {
        return attendanceService.saveAttendance(attendance);
    }
    @PostMapping("/check-out")
    public Attendance checkOut(@RequestBody Attendance attendance) {
        return attendanceService.saveAttendance(attendance);
    }
    /*
    @GetMapping("/{id}")
    public Attendance getAttendanceById(@PathVariable Long id) {
        return attendanceService.getAttendanceById(id).orElse(null);
    }


    @PutMapping("/{id}")
    public Attendance updateAttendance(@PathVariable Long id, @RequestBody Attendance attendance) {
        attendance.setId(id);
        return attendanceService.saveAttendance(attendance);
    }

    @DeleteMapping("/{id}")
    public void deleteAttendance(@PathVariable Long id) {
        attendanceService.deleteAttendance(id);
    }*/
}
