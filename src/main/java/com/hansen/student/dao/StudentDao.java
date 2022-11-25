package com.hansen.student.dao;

import com.hansen.student.model.Student;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface StudentDao extends MongoRepository<Student, Long> {

}
