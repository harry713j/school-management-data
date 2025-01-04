package com.example.service;

import com.example.model.Student;
import com.example.repo.StudentRepository;

import java.util.List;

public class StudentService {
    private final StudentRepository repository;

    public StudentService(){
        this.repository = new StudentRepository();
    }

    public void registerStudent(Student student){
        this.repository.create(student);
    }

    public List<Student> getAllStudents(){
        return this.repository.findAll();
    }

    public Student getStudent(int studentId){
        return this.repository.findById(studentId);
    }
}
