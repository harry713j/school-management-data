package com.example.entity;

import java.time.LocalDate;

public class Student {
    private Integer studentId;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;

    public Student() {
    }

    public Student(int studentId, String firstName, String lastName, LocalDate dateOfBirth) {
        this.studentId = studentId;
        this.dateOfBirth = dateOfBirth;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public LocalDate getDataOfBirth() {
        return dateOfBirth;
    }

    public void setDataOfBirth(LocalDate dataOfBirth) {
        this.dateOfBirth = dataOfBirth;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
