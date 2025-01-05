package com.example.service;

import com.example.model.Subject;
import com.example.repo.ModelRepository;

import java.util.List;

public class SubjectService {
    private final ModelRepository<Subject> repo;

    public SubjectService() {
        this.repo = new ModelRepository<>(Subject.class);
    }

    public void registerSubject(Subject subject){
        this.repo.create(subject);
    }

    public List<Subject> getAllSubjects(){
        return this.repo.findAll();
    }

    public Subject getSubject(int subjectId){
        return this.repo.findById(subjectId);
    }
}
