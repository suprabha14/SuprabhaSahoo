package com.example.employeemanagementsystem.repository;

import com.example.employeemanagementsystem.entity.Department;
import com.example.employeemanagementsystem.projection.DepartmentProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    List<DepartmentProjection> findAllProjectedBy();
}
