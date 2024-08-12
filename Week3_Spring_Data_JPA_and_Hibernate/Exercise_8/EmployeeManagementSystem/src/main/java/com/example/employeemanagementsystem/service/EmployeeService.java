package com.example.employeemanagementsystem.service;

import com.example.employeemanagementsystem.projection.EmployeeProjection;
import com.example.employeemanagementsystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeProjection> getAllEmployeeProjections() {
        return employeeRepository.findAllProjectedBy();
    }

    public List<EmployeeProjection> getEmployeeProjectionsByDepartment(String departmentName) {
        return employeeRepository.findByDepartmentName(departmentName);
    }
}
