package com.example.employeemanagementsystem.service;

import com.example.employeemanagementsystem.projection.DepartmentProjection;
import com.example.employeemanagementsystem.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<DepartmentProjection> getAllDepartmentProjections() {
        return departmentRepository.findAllProjectedBy();
    }
}
