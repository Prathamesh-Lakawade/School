package com.hansen.student.service;

import com.hansen.student.dao.StudentDao;
import com.hansen.student.model.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class StudentService {

    @Autowired
    StudentDao dao;

    public String create(Student entity) {
        if (read(entity.getRollNumber()).equals("INFO: ROLL NUMBER DOES NOT EXIST")) {
            dao.save(entity);
            return "SUCCESS: STUDENT ADDED SUCCESSFULLY";
        } else {
            return "ERROR: STUDENT WITH SAME ROLL NUMBER EXISTS. TRY WITH ANOTHER ROLL NUMBER";
        }
    }

    public Object read(long rollNumber) {
        if (rollNumber > 0) {
            if (dao.findById(rollNumber).isEmpty()) {
                return "INFO: ROLL NUMBER DOES NOT EXIST";
            } else {
                return dao.findById(rollNumber);
            }
        } else {
            return "ERROR: INVALID ROLL NUMBER (ROLL NUMBER SHOULD BE GREATER THAN 0)";
        }
    }

    public Object readAll() {
        if (dao.findAll().isEmpty()) {
            return "INFO: NO STUDENT PRESENT IN DATABASE";
        } else {
            return dao.findAll();
        }
    }

    public Object update(Student entity) {
        
        if (read(entity.getRollNumber()).equals("INFO: ROLL NUMBER DOES NOT EXIST")) {
            return "ERROR: STUDENT DOES NOT EXIST";
        } else {
            Optional<Student> currentEntity = dao.findById(entity.getRollNumber());

            if (currentEntity.isPresent()) {
                if (entity.getName() != null) {
                    currentEntity.get().setName(entity.getName());
                }
                if (entity.getAddress() != null) {
                    currentEntity.get().setAddress(entity.getAddress());
                }
                if (entity.getStandard() != null) {
                    currentEntity.get().setStandard(entity.getStandard());
                }
                if (entity.getDivision() != null) {
                    currentEntity.get().setDivision(entity.getDivision());
                }
                if (entity.getClassTeacher() != null) {
                    currentEntity.get().setClassTeacher(entity.getClassTeacher());
                }

                dao.save(currentEntity.get());
                return "SUCCESS: STUDENT UPDATED SUCCESSFULLY";
            } else {
                return "ERROR: COULD NOT FIND STUDENT. TRY AFTER SOMETIME";
            }
        }
    }
}