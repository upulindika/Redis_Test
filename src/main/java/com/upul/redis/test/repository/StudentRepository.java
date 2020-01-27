package com.upul.redis.test.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.upul.redis.test.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, String> {}