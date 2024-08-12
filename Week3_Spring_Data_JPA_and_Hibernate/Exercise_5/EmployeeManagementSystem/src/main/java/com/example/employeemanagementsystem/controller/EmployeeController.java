package com.example.employeemanagementsystem.controller;

import com.example.employeemanagementsystem.entity.Employee;
import com.example.employeemanagementsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/department/{departmentName}")
    public List<Employee> getEmployeesByDepartmentName(@PathVariable String departmentName) {
        return employeeService.getEmployeesByDepartmentName(departmentName);
    }

    @GetMapping("/email/{email}")
    public Employee getEmployeeByEmail(@PathVariable String email) {
        return employeeService.getEmployeeByEmail(email);
    }

    @GetMapping("/search/{name}")
    public List<Employee> getEmployeesByNameContaining(@PathVariable String name) {
        return employeeService.getEmployeesByNameContaining(name);
    }

    @GetMapping("/department-id/{id}")
    public List<Employee> getEmployeesByDepartmentId(@PathVariable Long id) {
        return employeeService.getEmployeesByDepartmentId(id);
    }
}
