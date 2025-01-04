package com.example;

import com.example.model.Student;
import com.example.service.StudentService;

import java.time.LocalDate;

public class App
{
    public static void main( String[] args )
    {
        /*
        * 1. Create SessionFactory
        * 2. Create Session
        * 3. Begin Transaction
        * 4. Start database operation
        * */

        StudentService studentService = new StudentService();

        Student student = new Student("Ronny", "Delt",
                LocalDate.of(1990, 6, 27), "8564234576");

        studentService.registerStudent(student);

        studentService.getAllStudents().forEach(System.out::println);

        System.out.println(studentService.getStudent(2));
    }
}
