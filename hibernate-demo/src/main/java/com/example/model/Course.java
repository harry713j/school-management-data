package com.example.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long courseId;
    @Column(name = "course_name")
    private String courseName;
    @ManyToMany(mappedBy = "courses", fetch = FetchType.EAGER)
    private List<Student> students;
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    public Course() {
    }

    public Course(Long courseId, String courseName, List<Student> students, Teacher teacher, Subject subject) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.students = students;
        this.teacher = teacher;
        this.subject = subject;
    }

    public Course(String courseName, List<Student> students, Teacher teacher, Subject subject) {
        this.courseName = courseName;
        this.students = students;
        this.teacher = teacher;
        this.subject = subject;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", students=" + students +
                ", teacher=" + teacher +
                ", subject=" + subject +
                '}';
    }
}
