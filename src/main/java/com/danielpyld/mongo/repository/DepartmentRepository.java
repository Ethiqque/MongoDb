package com.danielpyld.mongo.repository;

import com.danielpyld.mongo.entities.Department;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DepartmentRepository extends MongoRepository<Department, String> {
}
