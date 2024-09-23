package com.danielpyld.mongo.service;

import com.danielpyld.mongo.entities.Employee;
import com.danielpyld.mongo.entities.Task;
import com.danielpyld.mongo.repository.EmployeeRepository;
import com.danielpyld.mongo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    // Create or update a task
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    // Assign a task to an employee
    public Task assignTaskToEmployee(String taskId, String employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        Optional<Task> task = taskRepository.findById(taskId);

        if (task.isPresent() && employee.isPresent()) {
            task.get().setAssignedEmployee(employee.get());
            return taskRepository.save(task.get());
        }

        return null; // Or throw an exception
    }

    // Find all tasks
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Find a task by ID
    public Optional<Task> getTaskById(String id) {
        return taskRepository.findById(id);
    }

    // Delete a task by ID
    public void deleteTask(String id) {
        taskRepository.deleteById(id);
    }
}
