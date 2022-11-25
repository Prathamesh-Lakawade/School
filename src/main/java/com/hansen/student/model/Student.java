package com.hansen.student.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "students")
public class Student {

    @Id
    private final long rollNumber;

    private String name;
    private String address;
    private String standard;
    private String division;
    private String classTeacher;

    public Student(long rollNumber, String name, String address, String standard, String division,
                   String classTeacher) {
        super();
        this.rollNumber = rollNumber;
        this.name = name;
        this.address = address;
        this.standard = standard;
        this.division = division;
        this.classTeacher = classTeacher;
    }

    public long getRollNumber() {
        return rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getClassTeacher() {
        return classTeacher;
    }

    public void setClassTeacher(String classTeacher) {
        this.classTeacher = classTeacher;
    }
}