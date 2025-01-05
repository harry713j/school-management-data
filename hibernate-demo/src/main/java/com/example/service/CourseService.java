package com.example.service;

import com.example.model.Course;
import com.example.repo.ModelRepository;

import java.util.List;

public class CourseService {
    private final ModelRepository<Course> repo;

    public CourseService(){
        this.repo = new ModelRepository<>(Course.class);
    }

    public void registerCourse(Course course){
        this.repo.create(course);
    }

    public List<Course> getAllCourses(){
        return this.repo.findAll();
    }

    public Course getCourse(int courseId){
        return this.repo.findById(courseId);
    }
}
