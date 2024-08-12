package com.example.employeemanagementsystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;

import java.util.List;
import javax.persistence.NamedQuery;

@Data
@Entity
@NamedQuery(
    name = "Department.findByEmployeeName",
    query = "SELECT d FROM Department d JOIN d.employees e WHERE e.name = :employeeName"
)
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;
}
