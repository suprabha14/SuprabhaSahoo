package com.example.employeemanagementsystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import lombok.Data;

@Data
@Entity
@NamedQuery(
    name = "Employee.findByDepartmentId",
    query = "SELECT e FROM Employee e WHERE e.department.id = :departmentId"
)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @ManyToOne
    private Department department;
}
