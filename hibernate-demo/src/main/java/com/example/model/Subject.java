package com.example.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private Long subjectId;
    @Column(name = "subject_name")
    private String subjectName;
    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Teacher> teachers;
    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Course> courses;

    public Subject() {
    }

    public Subject(Long subjectId, String subjectName, List<Teacher> teachers, List<Course> courses) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.teachers = teachers;
        this.courses = courses;
    }

    public Subject(String subjectName, List<Teacher> teachers, List<Course> courses) {
        this.subjectName = subjectName;
        this.teachers = teachers;
        this.courses = courses;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectId=" + subjectId +
                ", subjectName='" + subjectName + '\'' +
                ", teachers=" + teachers +
                ", courses=" + courses +
                '}';
    }
}
