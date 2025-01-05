package com.example.service;

import com.example.model.Student;
import com.example.repo.ModelRepository;

import java.util.List;

public class StudentService {
    private final ModelRepository<Student> repository;

    public StudentService(){
        this.repository = new ModelRepository<>(Student.class);
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
