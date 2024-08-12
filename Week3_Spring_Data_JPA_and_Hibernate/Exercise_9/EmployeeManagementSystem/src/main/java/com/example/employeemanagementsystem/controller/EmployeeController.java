package com.example.employeemanagementsystem.controller;

import com.example.employeemanagementsystem.projection.EmployeeProjection;
import com.example.employeemanagementsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/projections")
    public List<EmployeeProjection> getAllEmployeeProjections() {
        return employeeService.getAllEmployeeProjections();
    }

    @GetMapping("/projections/department/{departmentName}")
    public List<EmployeeProjection> getEmployeeProjectionsByDepartment(@PathVariable String departmentName) {
        return employeeService.getEmployeeProjectionsByDepartment(departmentName);
    }
}
