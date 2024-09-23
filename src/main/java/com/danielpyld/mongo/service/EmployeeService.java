package com.danielpyld.mongo.service;

import com.danielpyld.mongo.entities.Department;
import com.danielpyld.mongo.entities.Employee;
import com.danielpyld.mongo.entities.Task;
import com.danielpyld.mongo.repository.DepartmentRepository;
import com.danielpyld.mongo.repository.EmployeeRepository;
import com.danielpyld.mongo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    // Create or update an employee
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Assign an employee to a department
    public Employee assignToDepartment(String employeeId, String departmentId) {
        Optional<Department> department = departmentRepository.findById(departmentId);
        Optional<Employee> employee = employeeRepository.findById(employeeId);

        if (department.isPresent() && employee.isPresent()) {
            employee.get().setDepartment(department.get());
            return employeeRepository.save(employee.get());
        }

        return null; // Or throw an exception
    }

    // Find all employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Find an employee by ID
    public Optional<Employee> getEmployeeById(String id) {
        return employeeRepository.findById(id);
    }

    // Delete an employee by ID
    public void deleteEmployee(String id) {
        employeeRepository.deleteById(id);
    }
}
