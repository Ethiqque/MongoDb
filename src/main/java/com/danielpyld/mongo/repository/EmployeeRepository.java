package com.danielpyld.mongo.repository;

import com.danielpyld.mongo.entities.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
}
