package com.danielpyld.mongo.repository;

import com.danielpyld.mongo.entities.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Task, String> {
}
