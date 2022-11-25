package com.hansen.student.controller;

import com.hansen.student.model.Student;
import com.hansen.student.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
public class StudentController {

    @Autowired
    StudentService service;

    @PostMapping("/add")
    public ResponseEntity<?> addStudent(@RequestBody Student student) {
        return ResponseEntity.ok(service.create(student));
    }

    @GetMapping("/get/{rollNumber}")
    public ResponseEntity<?> getStudent(@PathVariable long rollNumber) {
        return ResponseEntity.ok(service.read(rollNumber));
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getStudents() {
        return ResponseEntity.ok(service.readAll());
    }

    @PatchMapping("/update")
    public ResponseEntity<?> updateStudent(@RequestBody Student student) {
        return ResponseEntity.ok(service.update(student));
    }
}