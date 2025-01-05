package com.example.service;

import com.example.model.Teacher;
import com.example.repo.ModelRepository;

import java.util.List;

public class TeacherService {
    private final ModelRepository<Teacher> repo;

    public TeacherService(){
        this.repo = new ModelRepository<>(Teacher.class);
    }

    public void registerTeacher(Teacher teacher){
        this.repo.create(teacher);
    }

    public List<Teacher> getAllTeachers(){
        return this.repo.findAll();
    }

    public Teacher getTeacher(int teacherId){
        return this.repo.findById(teacherId);
    }
}
