package com.danielpyld.mongo.service;

import com.danielpyld.mongo.entities.Department;
import com.danielpyld.mongo.repository.DepartmentRepository;
import com.danielpyld.mongo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    // Create or update a department
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    // Find all departments
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    // Find a department by ID
    public Optional<Department> getDepartmentById(String id) {
        return departmentRepository.findById(id);
    }

    // Delete a department by ID
    public void deleteDepartment(String id) {
        departmentRepository.deleteById(id);
    }
}
